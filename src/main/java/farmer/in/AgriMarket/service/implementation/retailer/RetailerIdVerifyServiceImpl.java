package farmer.in.AgriMarket.service.implementation.retailer;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.email.EmailSender;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.service.retailer.RetailerIdVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetailerIdVerifyServiceImpl implements RetailerIdVerifyService {

    @Autowired
    private RetailerRepository retailerRepository;

    @Autowired
    private EmailSender emailSender;

    @Override
    public Object idVerify(String retailerId) {
        RetailerModel retailerModel=retailerRepository.findByRetailerId(retailerId);
        if(retailerModel==null){
            Response response=new Response();
            response.setMessage("Given FarmerId has no account, Kindly contact the admin");
            return response;
        }
        else{
            String email=retailerModel.getEmail();
            String body="Forget Password Service";
            String subject="You can change the password now";
            emailSender.sendEmail(email,body,subject);
            return retailerModel;
        }
    }
}
