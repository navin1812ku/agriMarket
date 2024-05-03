package farmer.in.AgriMarket.service.implementation.retailer;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.dto.retailer.RetailerForgetPasswordRequest;
import farmer.in.AgriMarket.model.retailer.RetailerLoginModel;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import farmer.in.AgriMarket.password.EncodePassword;
import farmer.in.AgriMarket.repository.retailer.RetailerLoginRepository;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.service.retailer.RetailerForgetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetailerForgetPasswordServiceImpl implements RetailerForgetPasswordService {

    @Autowired
    private RetailerRepository retailerRepository;

    @Autowired
    private RetailerLoginRepository retailerLoginRepository;

    @Autowired
    private EncodePassword encodePassword;

    @Override
    public Object forgetPassword(String retailerId, RetailerForgetPasswordRequest retailerForgetPasswordRequest) {
        RetailerModel retailerModel=retailerRepository.findByRetailerId(retailerId);
        if(retailerModel==null){
            Response response=new Response();
            response.setMessage("Something went wrong please try again later");
            return response;
        }
        else{
            if(encodePassword.verifyPassword(retailerForgetPasswordRequest.getNewPassword(),retailerModel.getPassword())){
                Response response=new Response();
                response.setMessage("Password matches the old password");
                return response;
            }
            String password=encodePassword.encode(retailerForgetPasswordRequest.getNewPassword());
            retailerModel.setPassword(password);

            retailerRepository.save(retailerModel);

            RetailerLoginModel retailerLoginModel=retailerLoginRepository.findByRetailerId(retailerId);
            if(retailerLoginModel==null){
                Response response=new Response();
                response.setMessage("Something went wrong please try again later");
                return response;
            }
            else{
                if(encodePassword.verifyPassword(retailerForgetPasswordRequest.getNewPassword(),retailerLoginModel.getPassword())){
                    Response response=new Response();
                    response.setMessage("Password matches the old password");
                    return response;
                }
                String password1=encodePassword.encode(retailerForgetPasswordRequest.getNewPassword());
                retailerLoginModel.setPassword(password1);

                retailerLoginRepository.save(retailerLoginModel);

                List<Object> retailerDetails=new ArrayList<>();

                retailerDetails.add(retailerLoginModel);
                retailerDetails.add(retailerModel);
                retailerDetails.add(retailerForgetPasswordRequest.getNewPassword());

                return retailerDetails;
            }
        }
    }
}
