package farmer.in.AgriMarket.service.implementation.product;

import farmer.in.AgriMarket.dto.product.ProductPlaceOrderRequest;
import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.farmer.FarmerProductHistory;
import farmer.in.AgriMarket.model.farmer.FarmerRetailerHistory;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.model.product.ProductModel;
import farmer.in.AgriMarket.model.retailer.RetailerFarmerHistory;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import farmer.in.AgriMarket.repository.farmer.FarmerProductHistoryRepository;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.repository.farmer.FarmerRetailerHistoryRepository;
import farmer.in.AgriMarket.repository.product.ProductRepository;
import farmer.in.AgriMarket.repository.retailer.RetailerFarmerHistoryRepository;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.service.product.ProductPlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ProductPlaceOrderServiceImpl implements ProductPlaceOrderService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RetailerRepository retailerRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private FarmerProductHistoryRepository farmerProductHistoryRepository;

    @Autowired
    private FarmerRetailerHistoryRepository farmerRetailerHistoryRepository;

    @Autowired
    private RetailerFarmerHistoryRepository retailerFarmerHistoryRepository;

    @Override
    public Object placeOrder(ProductPlaceOrderRequest productPlaceOrderRequest) {
        Long productId= productPlaceOrderRequest.getProductId();
        String retailerId= productPlaceOrderRequest.getRetailerId();
        Integer retailerProductQuantity= productPlaceOrderRequest.getRetailerProductQuantity();

        ProductModel productModel=productRepository.findByProductId(productId);

        String farmerId=productModel.getFarmerId();

        if(productModel==null){
            Response response=new Response();
            response.setMessage("Requested product doesn't exists, kindly refresh the page");
            return response;
        }
        else if(!productPlaceOrderRequest.getPaymentPaid()){
            Response response=new Response();
            response.setMessage("Kindly complete the payment process and then you can place the order");
            return response;
        }
        else{
            //Updating product quantity
            productModel.setProductQuantityPerKG(productModel.getProductQuantityPerKG()-retailerProductQuantity);
            productRepository.save(productModel);

            Double paidAmount=productModel.getProductCost()*retailerProductQuantity;

            //Adding order details to farmer history
            FarmerModel farmerModel=farmerRepository.findByFarmerId(farmerId);
            if(farmerModel==null){
                Response response=new Response();
                response.setMessage("Something went wrong please try again later");
                return response;
            }
            else{
                FarmerRetailerHistory farmerRetailerHistory =new FarmerRetailerHistory();

                farmerRetailerHistory.setFarmerId(farmerId);

                farmerRetailerHistory.setProductName(productModel.getProductName());
                farmerRetailerHistory.setProductCost(productModel.getProductCost());
                farmerRetailerHistory.setProductQuantity(productModel.getProductQuantityPerKG());
                farmerRetailerHistory.setRetailerId(retailerId);

                //Adding retailer details in farmer history
                RetailerModel retailerModel=retailerRepository.findByRetailerId(retailerId);
                if(retailerModel==null){
                    Response response=new Response();
                    response.setMessage("Something went wrong please try again later");
                    return response;
                }
                else{
                    farmerRetailerHistory.setRetailerName(retailerModel.getFullName());
                    farmerRetailerHistory.setRetailerRating(
                            retailerModel.getRating()==0 ?
                                    "This is the first product kindly buy this and give review"
                                    :retailerModel.getRating().toString()
                    );
                }
                farmerRetailerHistory.setRetailerProductQuantity(retailerProductQuantity);
                farmerRetailerHistory.setRetailerPaidCost(paidAmount);

                farmerRetailerHistoryRepository.save(farmerRetailerHistory);

                FarmerProductHistory farmerProductHistory=farmerProductHistoryRepository.findByFarmerIdAndProductId(farmerId,productId);

                farmerProductHistory.setTotalProfitCost(farmerProductHistory.getTotalProfitCost()==0 ?
                        paidAmount:
                        farmerProductHistory.getTotalProfitCost()+paidAmount
                );
                farmerProductHistoryRepository.save(farmerProductHistory);

                farmerRepository.save(farmerModel);
            }

            //Adding order details to retailer history
            RetailerModel retailerModel=retailerRepository.findByRetailerId(retailerId);
            if(retailerModel==null){
                Response response=new Response();
                response.setMessage("Something went wrong please try again later");
                return response;
            }
            else{
                RetailerFarmerHistory retailerFarmerHistory=new RetailerFarmerHistory();

                retailerFarmerHistory.setRetailerId(retailerId);
                retailerFarmerHistory.setProductName(productModel.getProductName());
                retailerFarmerHistory.setProductCost(productModel.getProductCost());
                retailerFarmerHistory.setRetailerProductQuantity(retailerProductQuantity);
                retailerFarmerHistory.setRetailerPaidAmount(paidAmount);
                retailerFarmerHistory.setFarmerName(farmerModel.getFullName());
                retailerFarmerHistory.setFarmerRating(
                        farmerModel.getRating()==0 ?
                                "This is the first product kindly buy this and give review":
                                farmerModel.getRating().toString()
                );

                retailerFarmerHistoryRepository.save(retailerFarmerHistory);

                retailerRepository.save(retailerModel);
            }

            //Order placed message
            Response response=new Response();
            response.setMessage("Successfully purchased");

            List<Object> orderDetails=new ArrayList<>();
            orderDetails.add(response);
            orderDetails.add(productModel);
            orderDetails.add(farmerModel);
            orderDetails.add(retailerModel);

            return orderDetails;
        }
    }
}
