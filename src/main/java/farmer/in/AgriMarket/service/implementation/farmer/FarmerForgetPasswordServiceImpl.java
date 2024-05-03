package farmer.in.AgriMarket.service.implementation.farmer;

import farmer.in.AgriMarket.dto.farmer.FarmerForgetPasswordRequest;
import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.farmer.FarmerLoginModel;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.password.EncodePassword;
import farmer.in.AgriMarket.repository.farmer.FarmerLoginRepository;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.service.farmer.FarmerForgetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FarmerForgetPasswordServiceImpl implements FarmerForgetPasswordService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private FarmerLoginRepository farmerLoginRepository;

    @Autowired
    private EncodePassword encodePassword;

    @Override
    public Object forgetPassword(String farmerId, FarmerForgetPasswordRequest farmerForgetPasswordRequest) {
        FarmerModel farmerModel=farmerRepository.findByFarmerId(farmerId);
        if(farmerModel==null){
            Response response=new Response();
            response.setMessage("Something went wrong please try again later");
            return response;
        }
        else{
            if(encodePassword.verifyPassword(farmerForgetPasswordRequest.getNewPassword(),farmerModel.getPassword())){
                Response response=new Response();
                response.setMessage("Password matches the old password");
                return response;
            }
            String password=encodePassword.encode(farmerForgetPasswordRequest.getNewPassword());
            farmerModel.setPassword(password);

            farmerRepository.save(farmerModel);

            FarmerLoginModel farmerLoginModel=farmerLoginRepository.findByFarmerId(farmerId);
            if(farmerLoginModel==null){
                Response response=new Response();
                response.setMessage("Something went wrong please try again later");
                return response;
            }
            else{
                if(encodePassword.verifyPassword(farmerForgetPasswordRequest.getNewPassword(),farmerLoginModel.getPassword())){
                    Response response=new Response();
                    response.setMessage("Password matches the old password");
                    return response;
                }
                String password1=encodePassword.encode(farmerForgetPasswordRequest.getNewPassword());
                farmerLoginModel.setPassword(password1);

                farmerLoginRepository.save(farmerLoginModel);

                List<Object> farmerDetails=new ArrayList<>();

                farmerDetails.add(farmerLoginModel);
                farmerDetails.add(farmerModel);
                farmerDetails.add(farmerForgetPasswordRequest.getNewPassword());

                return farmerDetails;
            }
        }
    }
}
