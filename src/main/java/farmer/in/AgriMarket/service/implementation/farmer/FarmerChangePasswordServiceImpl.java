package farmer.in.AgriMarket.service.implementation.farmer;

import farmer.in.AgriMarket.dto.farmer.FarmerChangePasswordRequest;
import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.farmer.FarmerLoginModel;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.password.EncodePassword;
import farmer.in.AgriMarket.repository.farmer.FarmerLoginRepository;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.service.farmer.FarmerChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FarmerChangePasswordServiceImpl implements FarmerChangePasswordService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private FarmerLoginRepository farmerLoginRepository;
    @Autowired
    private EncodePassword encodePassword;


    @Override
    public Object changePassword(String farmerId, FarmerChangePasswordRequest farmerChangePasswordRequest) {
        FarmerModel farmerModel=farmerRepository.findByFarmerId(farmerId);
        if(farmerModel==null){
            Response response=new Response();
            response.setMessage("Something went wrong please try again later");
            return response;
        }
        else{
            if(encodePassword.verifyPassword(farmerChangePasswordRequest.getNewPassword(),farmerModel.getPassword())){
                Response response=new Response();
                response.setMessage("Entered password matches the old password");
                return response;
            }
            else{
                String password=encodePassword.encode(farmerChangePasswordRequest.getNewPassword());
                farmerModel.setPassword(password);

                farmerRepository.save(farmerModel);

                FarmerLoginModel farmerLoginModel=farmerLoginRepository.findByFarmerId(farmerId);
                if(farmerLoginModel==null){
                    Response response=new Response();
                    response.setMessage("Something went wrong please try again later");
                    return response;
                }
                else{
                    String password1=encodePassword.encode(farmerChangePasswordRequest.getNewPassword());
                    farmerLoginModel.setPassword(password);

                    farmerLoginRepository.save(farmerLoginModel);
                }

                List<Object> farmerDetails=new ArrayList<>();

                farmerDetails.add(farmerLoginModel);
                farmerDetails.add(farmerModel);
                farmerDetails.add(farmerChangePasswordRequest.getNewPassword());

                return farmerDetails;
            }
        }
    }
}
