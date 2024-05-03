package farmer.in.AgriMarket.service.implementation.retailer;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.dto.retailer.RetailerCanChangePasswordRequest;
import farmer.in.AgriMarket.email.EmailSender;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import farmer.in.AgriMarket.password.EncodePassword;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.service.retailer.RetailerCanChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RetailerCanChangePasswordServiceImpl implements RetailerCanChangePasswordService {

    @Autowired
    private RetailerRepository retailerRepository;

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private EncodePassword encodePassword;

    @Override
    public Object canChangePassword(String retailerId, RetailerCanChangePasswordRequest retailerCanChangePasswordRequest) {
        RetailerModel retailerModel=retailerRepository.findByRetailerId(retailerId);
        if(retailerModel==null){
            Response response=new Response();
            response.setMessage("Given farmerId does not have an account, Kindly contact the admin");
            return response;
        }
        else {
            if(encodePassword.verifyPassword(retailerCanChangePasswordRequest.getOldPassword(),retailerModel.getPassword())){
                String email=retailerModel.getEmail();
                String body="Change Password Service";
                String subject="You can change the password now";
                emailSender.sendEmail(email,body,subject);

                Response response=new Response();
                response.setMessage("FarmerId with: "+retailerId+" can change password");
                return response;
            }
            else{
                Response response=new Response();
                response.setMessage("FarmerId with: "+retailerId+" can not change password because password doesn't matches");
                return response;
            }
        }
    }
}
