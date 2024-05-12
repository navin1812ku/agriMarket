package farmer.in.AgriMarket.service.implementation.retailer;

import farmer.in.AgriMarket.dto.retailer.RetailerNewRequest;
import farmer.in.AgriMarket.email.EmailSender;
import farmer.in.AgriMarket.model.retailer.RetailerLoginModel;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import farmer.in.AgriMarket.password.EncodePassword;
import farmer.in.AgriMarket.repository.randomNumber.RandomNumberRepository;
import farmer.in.AgriMarket.repository.retailer.RetailerLoginRepository;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.service.retailer.RetailerNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetailerNewServiceImpl implements RetailerNewService {

    @Autowired
    private EncodePassword encodePassword;

    @Autowired
    private RetailerLoginRepository retailerLoginRepository;

    @Autowired
    private RetailerRepository retailerRepository;

    @Autowired
    private RandomNumberRepository randomNumberRepository;

    @Autowired
    private EmailSender emailSender;

    @Override
    public List<Object> addRetailer(RetailerNewRequest retailerNewRequest) {
        long randomNumber=encodePassword.randomNumber();
        boolean flag=true;
        while(flag){
            if(randomNumberRepository.findByRandomNumber(randomNumber)==null){
                flag=false;
            }
            else{
                randomNumber=encodePassword.randomNumber();
            }
        }
        String retailerId = retailerNewRequest.getRetailerId()+"@"+randomNumber;
        String password=encodePassword.encode(retailerNewRequest.getPassword());

        RetailerLoginModel retailerLoginModel=new RetailerLoginModel();
        retailerLoginModel.setRetailerId(retailerId);
        retailerLoginModel.setPassword(password);
        retailerLoginModel.setRole(retailerNewRequest.getRole());

        retailerLoginRepository.save(retailerLoginModel);

        RetailerModel retailerModel=new RetailerModel();
        retailerModel.setRetailerId(retailerId);
        retailerModel.setPassword(password);
        retailerModel.setEmail(retailerNewRequest.getEmail());
        retailerModel.setRating(0.0);

        retailerRepository.save(retailerModel);

        List<Object> retailerDetails=new ArrayList<>();
        retailerDetails.add(retailerLoginRepository.findByRetailerId(retailerId));
        retailerDetails.add(retailerRepository.findByRetailerId(retailerId));

        String email=retailerNewRequest.getEmail();
        String body="Your Login credential "+
                "Login Id : "+retailerId+
                "Password : "+retailerNewRequest.getPassword();
        String subject="Login Credential";
        emailSender.sendEmail(email,subject,body);

        return retailerDetails;
    }
}
