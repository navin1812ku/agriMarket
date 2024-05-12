package farmer.in.AgriMarket.service.implementation.farmer;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.email.EmailSender;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.model.farmer.FarmerRetailerHistory;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.service.farmer.RequestToGetRatingFromRetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RequestToGetRatingFromRetailerServiceImpl implements RequestToGetRatingFromRetailerService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private RetailerRepository retailerRepository;

    @Autowired
    private EmailSender emailSender;

    @Override
    public Object getRatingFromRetailer(String farmerId) {
        FarmerModel farmerModel=farmerRepository.findByFarmerId(farmerId);
        if(farmerModel==null){
            Response response=new Response();
            response.setMessage("Something went wrong please try again later");
            return response;
        }
        else{
            List<FarmerRetailerHistory> retailerList=farmerModel.getFarmerRetailerHistory().stream()
                    .filter(history -> !history.getIsRetailerGiveRating())
                    .collect(Collectors.toList());

            for(FarmerRetailerHistory farmerRetailerHistory: retailerList){
                RetailerModel retailerModel=retailerRepository.findByRetailerId(farmerRetailerHistory.getRetailerId());
                if(retailerModel==null){
                    Response response=new Response();
                    response.setMessage("Something went wrong please try again later");
                    return response;
                }
                else{
                    emailSender.sendEmail(
                            retailerModel.getEmail(),
                            "Request for getting rating from retailer",
                            "FarmerId: "+farmerId+" is requested you to give him the rating for the product you purchased from him"
                    );
                }
            }
            return retailerList;
        }
    }
}
