package farmer.in.AgriMarket.service.implementation.retailer;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.email.EmailSender;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.model.retailer.RetailerFarmerHistory;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.service.retailer.RequestToGetRatingFromFarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestToGetRatingFromFarmerServiceImpl implements RequestToGetRatingFromFarmerService {

    @Autowired
    private RetailerRepository retailerRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private EmailSender emailSender;

    @Override
    public Object getRatingFromFarmer(String retailerId) {
        RetailerModel retailerModel=retailerRepository.findByRetailerId(retailerId);
        if(retailerModel==null){
            Response response=new Response();
            response.setMessage("Something went wrong please try again later");
            return response;
        }
        else{
            List<RetailerFarmerHistory> retailerList=retailerModel.getRetailerFarmerHistory().stream()
                    .filter(history -> !history.getIsFarmerGiveRating())
                    .collect(Collectors.toList());

            for (RetailerFarmerHistory retailerFarmerHistory:retailerList){
                FarmerModel farmerModel=farmerRepository.findByFarmerId(retailerFarmerHistory.getFarmerId());
                if(farmerModel==null){
                    Response response=new Response();
                    response.setMessage("Something went wrong please try again later");
                    return response;
                }
                else{
                    emailSender.sendEmail(
                            farmerModel.getEmail(),
                            "Request for getting rating from farmer",
                            "FarmerId: "+retailerId+" is requested you to give him the rating for purchasing product from you"
                    );
                }
            }
            return retailerList;
        }
    }
}
