package farmer.in.AgriMarket.service.implementation.login;

import farmer.in.AgriMarket.dto.login.LoginRequest;
import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.admin.AdminModel;
import farmer.in.AgriMarket.model.farmer.FarmerLoginModel;
import farmer.in.AgriMarket.model.retailer.RetailerLoginModel;
import farmer.in.AgriMarket.password.EncodePassword;
import farmer.in.AgriMarket.repository.admin.AdminRepository;
import farmer.in.AgriMarket.repository.farmer.FarmerLoginRepository;
import farmer.in.AgriMarket.repository.retailer.RetailerLoginRepository;
import farmer.in.AgriMarket.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private EncodePassword encodePassword;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private FarmerLoginRepository farmerLoginRepository;

    @Autowired
    private RetailerLoginRepository retailerLoginRepository;

    @Override
    public Object login(LoginRequest loginRequest) {

        final String loginIdName=loginRequest.getId();

        if(loginIdName.substring(0,5).equals("admin")){
            AdminModel adminModel=adminRepository.findByAdminId(loginIdName);
            if(adminModel==null){
                Response response=new Response();
                response.setMessage("The id name: "+loginIdName+" has not registered");
                return response;
            }
            else{
                if(encodePassword.verifyPassword(loginRequest.getPassword(),adminModel.getPassword())){
                    Response response=new Response();
                    response.setMessage("Login successful");
                    return response;
                }
                else{
                    Response response=new Response();
                    response.setMessage("Entered password was wrong");
                    return response;
                }
            }
        }
        else if(loginIdName.substring(0,6).equals("farmer")){
            FarmerLoginModel farmerLoginModel=farmerLoginRepository.findByFarmerId(loginIdName);
            if(farmerLoginModel==null){
                Response response=new Response();
                response.setMessage("The id name: "+loginIdName+" has not registered");
                return response;
            }
            else{
                if(encodePassword.verifyPassword(loginRequest.getPassword(),farmerLoginModel.getPassword())){
                    Response response=new Response();
                    response.setMessage("Login successful");
                    return response;
                }
                else{
                    Response response=new Response();
                    response.setMessage("Entered password was wrong");
                    return response;
                }
            }
        }
        else if(loginIdName.substring(0,8).equals("retailer")){
            RetailerLoginModel retailerLoginModel=retailerLoginRepository.findByRetailerId(loginIdName);
            if(retailerLoginModel==null){
                Response response=new Response();
                response.setMessage("The id name: "+loginIdName+" has not registered");
                return response;
            }
            else{
                if(encodePassword.verifyPassword(loginRequest.getPassword(),retailerLoginModel.getPassword())){
                    Response response=new Response();
                    response.setMessage("Login successful");
                    return response;
                }
                else{
                    Response response=new Response();
                    response.setMessage("Entered password was wrong");
                    return response;
                }
            }
        }
        Response response=new Response();
        response.setMessage("Something went wrong please try again later");
        return response;
    }
}
