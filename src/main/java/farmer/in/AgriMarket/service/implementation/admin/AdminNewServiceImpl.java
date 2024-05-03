package farmer.in.AgriMarket.service.implementation.admin;

import farmer.in.AgriMarket.dto.admin.AdminNewRequest;
import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.admin.AdminModel;
import farmer.in.AgriMarket.password.EncodePassword;
import farmer.in.AgriMarket.repository.admin.AdminRepository;
import farmer.in.AgriMarket.repository.randomNumber.RandomNumberRepository;
import farmer.in.AgriMarket.service.admin.AdminNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminNewServiceImpl implements AdminNewService {

    @Autowired
    private AdminRepository  adminRepository;

    @Autowired
    private RandomNumberRepository randomNumberRepository;

    @Autowired
    private EncodePassword encodePassword;

    @Override
    public Object addAdmin(AdminNewRequest adminNewRequest) {
        AdminModel model=adminRepository.findByAdminId(adminNewRequest.getAdminId());
        if(model==null){
            AdminModel adminModel=new AdminModel();
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
            String adminID=adminNewRequest.getAdminId()+"@"+randomNumber;
            adminModel.setAdminId(adminID);
            String encodedPassword = encodePassword.encode(adminNewRequest.getPassword());
            adminModel.setPassword(encodedPassword);
            adminModel.setEmail(adminNewRequest.getEmail());
            adminModel.setRole(adminNewRequest.getRole());

            System.out.println(adminModel);

            adminRepository.save(adminModel);

            AdminModel adminModel1=adminRepository.findByAdminId(adminID);
            System.out.println(adminModel1);
            if(adminModel1==null){
                Response response=new Response();
                response.setMessage("Something went wrong please try again later");
                return response;
            }
            else{
                return adminModel1;
            }
        }
        else {
            Response response=new Response();
            response.setMessage("The admin Id: "+adminNewRequest.getAdminId()+" has already registered");
            return response;
        }
    }
}
