package farmer.in.AgriMarket.service.implementation.retailer;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.dto.retailer.ProvidingRatingToFarmerRequest;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.model.farmer.FarmerRetailerHistory;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.repository.farmer.FarmerRetailerHistoryRepository;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.service.retailer.ProvidingRatingToFarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvidingRatingToFarmerServiceImpl implements ProvidingRatingToFarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private RetailerRepository retailerRepository;

    @Autowired
    private FarmerRetailerHistoryRepository farmerRetailerHistoryRepository;

    @Override
    public Object provideRatingToFarmer(String retailerId, ProvidingRatingToFarmerRequest providingRatingToFarmerRequest) {
        String farmerId= providingRatingToFarmerRequest.getFarmerId();
        Double farmerRating= providingRatingToFarmerRequest.getFarmerRating();

        RetailerModel retailerModel=retailerRepository.findByRetailerId(retailerId);
        if(retailerModel==null){
            Response response=new Response();
            response.setMessage("Something went wrong please try again later");
            return response;
        }
        else{
            FarmerModel farmerModel=farmerRepository.findByFarmerId(farmerId);
            if(farmerModel==null){
                Response response=new Response();
                response.setMessage("Something went wrong please try again later");
                return response;
            }
            else {
                farmerModel.setRating((farmerRating+farmerModel.getRating())/2);

                farmerRepository.save(farmerModel);

                List<FarmerRetailerHistory> farmerRetailerHistories= farmerRetailerHistoryRepository.findByRetailerId(retailerId);

                for(FarmerRetailerHistory farmerRetailerHistory:farmerRetailerHistories){
                    farmerRetailerHistory.setIsRetailerGiveRating(true);
                    farmerRetailerHistoryRepository.save(farmerRetailerHistory);
                }

                return farmerModel;
            }
        }
    }
}
