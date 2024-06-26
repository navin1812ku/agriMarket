package farmer.in.AgriMarket.service.implementation.product;


import farmer.in.AgriMarket.dto.product.AddProductRequest;
import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.exception.FarmerIdNotFoundException;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.model.farmer.FarmerProductHistory;
import farmer.in.AgriMarket.model.product.ProductModel;
import farmer.in.AgriMarket.password.EncodePassword;
import farmer.in.AgriMarket.repository.farmer.FarmerProductHistoryRepository;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.repository.product.ProductRepository;
import farmer.in.AgriMarket.service.product.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AddProductServiceImpl implements AddProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private EncodePassword encodePassword;

    @Autowired
    private FarmerProductHistoryRepository farmerProductHistoryRepository;

    @Override
    public Object addProduct(AddProductRequest addProductRequest) {
        String farmerId= addProductRequest.getFarmerId();

        FarmerModel farmerModel=farmerRepository.findByFarmerId(farmerId);

        if(farmerModel==null){
            Response response=new Response();
            response.setMessage("The given farmerId: "+farmerId+" not found in DB");
            return response;
        }
        else{

            Long productId=encodePassword.randomNumber();

            boolean flag=true;
            while(flag) {
                ProductModel model = productRepository.findByProductId(productId);
                if (model != null) {
                    productId = encodePassword.randomNumber();
                } else {
                    flag = false;
                }
            }

            ProductModel productModel=new ProductModel();

            productModel.setProductId(productId);
            productModel.setProductImage(addProductRequest.getProductImage());
            productModel.setProductName(addProductRequest.getProductName());
            productModel.setProductDescription(addProductRequest.getProductDescription());
            productModel.setProductQuantityPerKG(addProductRequest.getProductQuantityPerKG());
            productModel.setProductCost(addProductRequest.getProductCost());
            productModel.setFarmerId(farmerId);
            productModel.setFarmerName(farmerModel.getFullName());
            productModel.setFarmerRatting(
                    farmerModel.getRating()!=0 ?
                            farmerModel.getRating().toString():
                            "This is the first product kindly buy this and give review"
            );

            productRepository.save(productModel);

            FarmerProductHistory farmerProductHistory=new FarmerProductHistory();

            farmerProductHistory.setFarmerId(farmerId);
            farmerProductHistory.setProductId(productId);
            farmerProductHistory.setProductName(addProductRequest.getProductName());
            farmerProductHistory.setProductQuantity(addProductRequest.getProductQuantityPerKG());
            farmerProductHistory.setProductCost(addProductRequest.getProductCost());
            farmerProductHistory.setTotalProfitCost(0.0);

            farmerProductHistoryRepository.save(farmerProductHistory);

            boolean isProductHistoryAdded=false;

            if(farmerModel.getFarmerProductHistories()==null){
                farmerModel.setFarmerProductHistories(new ArrayList<>((Collection) farmerProductHistory));
                isProductHistoryAdded=true;
            }
            else{
                farmerModel.getFarmerProductHistories().add(farmerProductHistory);
                isProductHistoryAdded=true;
            }

            Response response=new Response();
            if(isProductHistoryAdded){
                response.setMessage("Product is added to farmer history and to the sale");
            }

            List<Object> productDetails=new ArrayList<>();

            productDetails.add(response);
            productDetails.add(productRepository.findByProductId(productId));

            return productDetails;
        }
    }
}
