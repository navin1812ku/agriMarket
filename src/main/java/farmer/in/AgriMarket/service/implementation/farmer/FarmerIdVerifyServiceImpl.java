package farmer.in.AgriMarket.service.implementation.farmer;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.email.EmailSender;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.service.farmer.FarmerIdVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerIdVerifyServiceImpl implements FarmerIdVerifyService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private EmailSender emailSender;

    @Override
    public Object idVerify(String farmerId) {
        FarmerModel farmerModel=farmerRepository.findByFarmerId(farmerId);
        if(farmerModel==null){
            Response response=new Response();
            response.setMessage("Given FarmerId has no account, Kindly contact the admin");
            return response;
        }
        else{
            String email=farmerModel.getEmail();
            String body="Forget Password Service";
            String subject="You can change the password now";
            emailSender.sendEmail(email,body,subject);
            return farmerModel;
        }
    }
}
