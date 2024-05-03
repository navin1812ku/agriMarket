package farmer.in.AgriMarket.service.implementation.retailer;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.dto.retailer.RetailerChangePasswordRequest;
import farmer.in.AgriMarket.model.retailer.RetailerLoginModel;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import farmer.in.AgriMarket.password.EncodePassword;
import farmer.in.AgriMarket.repository.retailer.RetailerLoginRepository;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.service.retailer.RetailerChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetailerChangePasswordServiceImpl implements RetailerChangePasswordService {

    @Autowired
    private RetailerRepository retailerRepository;

    @Autowired
    private RetailerLoginRepository retailerLoginRepository;

    @Autowired
    private EncodePassword encodePassword;

    @Override
    public Object changePassword(String retailerID, RetailerChangePasswordRequest retailerChangePasswordRequest) {
        RetailerModel retailerModel=retailerRepository.findByRetailerId(retailerID);
        if(retailerModel==null){
            Response response=new Response();
            response.setMessage("Something went wrong please try again later");
            return response;
        }
        else{
            if(encodePassword.verifyPassword(retailerChangePasswordRequest.getNewPassword(),retailerModel.getPassword())){
                Response response=new Response();
                response.setMessage("Entered password matches the old password");
                return response;
            }
            else{
                String password=encodePassword.encode(retailerChangePasswordRequest.getNewPassword());
                retailerModel.setPassword(password);

                retailerRepository.save(retailerModel);

                RetailerLoginModel retailerLoginModel=retailerLoginRepository.findByRetailerId(retailerID);
                if(retailerLoginModel==null){
                    Response response=new Response();
                    response.setMessage("Something went wrong please try again later");
                    return response;
                }
                else{
                    String password1=encodePassword.encode(retailerChangePasswordRequest.getNewPassword());
                    retailerLoginModel.setPassword(password);

                    retailerLoginRepository.save(retailerLoginModel);
                }

                List<Object> retailerDetails=new ArrayList<>();

                retailerDetails.add(retailerLoginModel);
                retailerDetails.add(retailerModel);
                retailerDetails.add(retailerChangePasswordRequest.getNewPassword());

                return retailerDetails;
            }
        }
    }
}
