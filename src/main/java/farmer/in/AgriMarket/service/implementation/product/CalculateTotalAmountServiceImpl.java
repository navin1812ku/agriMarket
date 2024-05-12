package farmer.in.AgriMarket.service.implementation.product;


import farmer.in.AgriMarket.dto.product.CalculateTotalAmountRequest;
import farmer.in.AgriMarket.dto.product.CalculateTotalAmountResponse;
import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.product.ProductModel;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.repository.product.ProductRepository;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.service.product.CalculateTotalAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateTotalAmountServiceImpl implements CalculateTotalAmountService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RetailerRepository retailerRepository;


    @Override
    public Object updateProductByQuantity(CalculateTotalAmountRequest calculateTotalAmountRequest) {
        Long productId= calculateTotalAmountRequest.getProductId();
        ProductModel productModel=productRepository.findByProductId(productId);
        if(productModel==null){
            Response response=new Response();
            response.setMessage("Requested product doesn't exists, kindly refresh the page");
            return response;
        }
        else{
            //Checking product is available
            if(productModel.getProductQuantityPerKG()< calculateTotalAmountRequest.getRetailerProductQuantity()){
                Response response=new Response();
                response.setMessage("Product quantity you have requested exceeded the product quantity available");
                return response;
            }
            else{
                CalculateTotalAmountResponse calculateTotalAmountResponse =new CalculateTotalAmountResponse();

                Double totalAmount=productModel.getProductCost() * calculateTotalAmountRequest.getRetailerProductQuantity();

                calculateTotalAmountResponse.setTotalAmount(totalAmount);

                return calculateTotalAmountResponse;
            }
        }
    }
}
