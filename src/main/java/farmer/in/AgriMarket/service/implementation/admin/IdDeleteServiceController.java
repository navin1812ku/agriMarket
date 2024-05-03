package farmer.in.AgriMarket.service.implementation.admin;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.farmer.FarmerLoginModel;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.model.retailer.RetailerLoginModel;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import farmer.in.AgriMarket.repository.farmer.FarmerLoginRepository;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.repository.retailer.RetailerLoginRepository;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.service.admin.IdDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdDeleteServiceController implements IdDeleteService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private RetailerRepository retailerRepository;

    @Autowired
    private FarmerLoginRepository farmerLoginRepository;

    @Autowired
    private RetailerLoginRepository retailerLoginRepository;

    @Override
    public Object deleteId(String id) {
        if(id.substring(0,6).equals("farmer")){
            farmerRepository.deleteById(id);
            farmerLoginRepository.deleteById(id);
            FarmerModel farmerModel=farmerRepository.findByFarmerId(id);
            FarmerLoginModel farmerLoginModel=farmerLoginRepository.findByFarmerId(id);
            if(farmerModel==null && farmerLoginModel==null){
                Response response=new Response();
                response.setMessage("Given ID: "+id+" account deleted successfully");
                return response;
            }
            else {
                return farmerModel;
            }
        }
        else if(id.substring(0,8).equals("retailer")) {
            retailerRepository.deleteById(id);
            retailerLoginRepository.deleteById(id);
            RetailerModel retailerModel=retailerRepository.findByRetailerId(id);
            RetailerLoginModel retailerLoginModel=retailerLoginRepository.findByRetailerId(id);
            if(retailerModel==null && retailerLoginModel==null){
                Response response=new Response();
                response.setMessage("Given ID: "+id+" account deleted successfully");
                return response;
            }
            else {
                return retailerModel;
            }
        }
        else{
            Response response=new Response();
            response.setMessage("Use the proper id of farmer or retailer");
            return response;
        }
    }
}
