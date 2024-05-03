package farmer.in.AgriMarket.service.implementation.farmer;

import farmer.in.AgriMarket.dto.farmer.FarmerNewRequest;
import farmer.in.AgriMarket.email.EmailSender;
import farmer.in.AgriMarket.model.farmer.FarmerLoginModel;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.password.EncodePassword;
import farmer.in.AgriMarket.repository.farmer.FarmerLoginRepository;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.repository.randomNumber.RandomNumberRepository;
import farmer.in.AgriMarket.service.farmer.FarmerNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FarmerNewServiceImpl implements FarmerNewService {

    @Autowired
    private EncodePassword encodePassword;

    @Autowired
    private FarmerLoginRepository farmerLoginRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private RandomNumberRepository randomNumberRepository;

    @Autowired
    private EmailSender emailSender;

    @Override
    public List<Object> addFarmer(FarmerNewRequest farmerNewRequest) {
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
        String farmerId= farmerNewRequest.getFarmerId()+"@"+randomNumber;
        String password=encodePassword.encode(farmerNewRequest.getPassword());

        FarmerLoginModel farmerLoginModel=new FarmerLoginModel();

        farmerLoginModel.setFarmerId(farmerId);
        farmerLoginModel.setPassword(password);
        farmerLoginModel.setRole(farmerNewRequest.getRole());

        farmerLoginRepository.save(farmerLoginModel);

        FarmerModel farmerModel=new FarmerModel();
        farmerModel.setFarmerId(farmerId);
        farmerModel.setPassword(password);
        farmerModel.setEmail(farmerNewRequest.getEmail());

        farmerRepository.save(farmerModel);

        List<Object> farmerDetails=new ArrayList<>();

        farmerDetails.add(farmerLoginRepository.findByFarmerId(farmerId));
        farmerDetails.add(farmerRepository.findByFarmerId(farmerId));

        String email=farmerNewRequest.getEmail();
        String body="Your Login credential "+
                "Login Id : "+farmerId+
                "Password : "+farmerNewRequest.getPassword();
        String subject="Login Credential";
        emailSender.sendEmail(email,subject,body);
        return farmerDetails;
    }
}
