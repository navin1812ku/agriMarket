package farmer.in.AgriMarket.service.implementation.farmer;

import farmer.in.AgriMarket.dto.farmer.FarmerCanChangePasswordRequest;
import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.email.EmailSender;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.password.EncodePassword;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.service.farmer.FarmerCanChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerCanChangePasswordServiceImpl implements FarmerCanChangePasswordService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private EncodePassword encodePassword;

    @Autowired
    private EmailSender emailSender;

    @Override
    public Object changePasswordIsPossible(String farmerId, FarmerCanChangePasswordRequest farmerCanChangePasswordRequest) {
        FarmerModel farmerModel=farmerRepository.findByFarmerId(farmerId);
        if(farmerModel==null){
            Response response=new Response();
            response.setMessage("Given farmerId does not have an account, Kindly contact the admin");
            return response;
        }
        else {
            if(encodePassword.verifyPassword(farmerCanChangePasswordRequest.getOldPassword(),farmerModel.getPassword())){

                String email=farmerModel.getEmail();
                String body="Change Password Service";
                String subject="You can change the password now";
                emailSender.sendEmail(email,body,subject);

                Response response=new Response();
                response.setMessage("FarmerId with: "+farmerId+" can change password");
                return response;
            }
            else{
                Response response=new Response();
                response.setMessage("FarmerId with: "+farmerId+" can not change password because password doesn't matches");
                return response;
            }
        }
    }
}
