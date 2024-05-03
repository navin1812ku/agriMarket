package farmer.in.AgriMarket.service.implementation.search;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.service.search.IdProfileSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdProfileSearchServiceImpl implements IdProfileSearchService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private RetailerRepository retailerRepository;


    @Override
    public Object search(String id) {
        if(id.substring(0,6).equals("farmer")){
            FarmerModel farmerModel=farmerRepository.findByFarmerId(id);
            if(farmerModel==null){
                Response response=new Response();
                response.setMessage("Given ID: "+id+" has no account");
                return response;
            }
            else {
                return farmerModel;
            }
        }
        else if(id.substring(0,8).equals("retailer")) {
            RetailerModel retailerModel=retailerRepository.findByRetailerId(id);
            if(retailerModel==null){
                Response response=new Response();
                response.setMessage("Given ID: "+id+" has no account");
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
