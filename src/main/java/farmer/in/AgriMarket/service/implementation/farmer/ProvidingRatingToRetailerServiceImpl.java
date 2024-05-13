package farmer.in.AgriMarket.service.implementation.farmer;

import farmer.in.AgriMarket.dto.farmer.ProvidingRatingToRetailerRequest;
import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.model.farmer.FarmerRetailerHistory;
import farmer.in.AgriMarket.model.retailer.RetailerFarmerHistory;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.repository.retailer.RetailerFarmerHistoryRepository;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.service.farmer.ProvidingRatingToRetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvidingRatingToRetailerServiceImpl implements ProvidingRatingToRetailerService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private RetailerRepository retailerRepository;

    @Autowired
    private RetailerFarmerHistoryRepository retailerFarmerHistoryRepository;

    @Override
    public Object providingRatingToRetailer(String farmerId, ProvidingRatingToRetailerRequest providingRatingToRetailerRequest) {
        String retailerId= providingRatingToRetailerRequest.getRetailerId();
        Double retailerRating= providingRatingToRetailerRequest.getRetailerRating();

        FarmerModel farmerModel=farmerRepository.findByFarmerId(farmerId);
        if(farmerModel==null){
            Response response=new Response();
            response.setMessage("Something went wrong please try again later");
            return response;
        }
        else{
            RetailerModel retailerModel=retailerRepository.findByRetailerId(retailerId);
            if(farmerModel==null){
                Response response=new Response();
                response.setMessage("Something went wrong please try again later");
                return response;
            }
            else {
                retailerModel.setRating((retailerRating+retailerModel.getRating())/2);

                farmerRepository.save(farmerModel);

                List<RetailerFarmerHistory> farmerRetailerHistories= retailerFarmerHistoryRepository.findByFarmerId(farmerId);

                for(RetailerFarmerHistory retailerFarmerHistory:farmerRetailerHistories){
                    retailerFarmerHistory.setIsFarmerGiveRating(true);
                    retailerFarmerHistoryRepository.save(retailerFarmerHistory);
                }

                return retailerModel;
            }
        }
    }
}
