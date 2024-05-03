package farmer.in.AgriMarket.service.implementation.farmer;

import farmer.in.AgriMarket.dto.farmer.FarmerAddressUpdateRequest;
import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.model.farmer.FarmerAddress;
import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.repository.farmer.FarmerAddressRepository;
import farmer.in.AgriMarket.repository.farmer.FarmerRepository;
import farmer.in.AgriMarket.service.farmer.FarmerAddressUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerAddressUpdateServiceImpl implements FarmerAddressUpdateService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private FarmerAddressRepository farmerAddressRepository;

    @Override
    public Object addressUpdate(String farmerId, FarmerAddressUpdateRequest farmerAddressUpdateRequest) {
        FarmerModel farmerModel=farmerRepository.findByFarmerId(farmerId);
        if(farmerModel==null){
            Response response=new Response();
            response.setMessage("Something went wrong please try again later");
            return response;
        }
        else {
            FarmerAddress farmerAddress=new FarmerAddress();

            farmerAddress.setFarmerId(farmerId);

            String houseNumber=farmerAddressUpdateRequest.getHouseNumber();
            farmerAddress.setHouseNumber(houseNumber!=null ? houseNumber:farmerAddress.getHouseNumber());


            String street=farmerAddressUpdateRequest.getStreet();
            farmerAddress.setStreet(street!=null ? street:farmerAddress.getStreet());

            String landMark=farmerAddressUpdateRequest.getLandMark();
            farmerAddress.setLandMark(landMark!=null ? landMark:farmerAddress.getLandMark());

            String pinCode=farmerAddressUpdateRequest.getPinCode();
            farmerAddress.setPinCode(pinCode!=null ? pinCode:farmerAddress.getPinCode());

            String town=farmerAddressUpdateRequest.getTown();
            farmerAddress.setTown(town!=null ? town:farmerAddress.getTown());

            String state=farmerAddressUpdateRequest.getState();
            farmerAddress.setState(state!=null ? state:farmerAddress.getState());

            String country=farmerAddressUpdateRequest.getCountry();
            farmerAddress.setCountry(country!=null ? country:farmerAddress.getCountry());

            farmerAddressRepository.save(farmerAddress);

            farmerModel.setFarmerAddress(farmerAddressRepository.findByFarmerId(farmerId));

            farmerRepository.save(farmerModel);

            return farmerRepository.findByFarmerId(farmerId);
        }
    }
}
