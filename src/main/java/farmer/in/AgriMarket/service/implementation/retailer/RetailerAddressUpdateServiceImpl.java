package farmer.in.AgriMarket.service.implementation.retailer;

import farmer.in.AgriMarket.dto.response.Response;
import farmer.in.AgriMarket.dto.retailer.RetailerAddressUpdateRequest;
import farmer.in.AgriMarket.model.retailer.RetailerAddress;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import farmer.in.AgriMarket.repository.retailer.RetailerAddressRepository;
import farmer.in.AgriMarket.repository.retailer.RetailerRepository;
import farmer.in.AgriMarket.service.retailer.RetailerAddressUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetailerAddressUpdateServiceImpl implements RetailerAddressUpdateService {

    @Autowired
    private RetailerRepository retailerRepository;

    @Autowired
    private RetailerAddressRepository retailerAddressRepository;

    @Override
    public Object addressUpdate(String retailerId, RetailerAddressUpdateRequest retailerAddressUpdateRequest) {
        RetailerModel retailerModel=retailerRepository.findByRetailerId(retailerId);
        if(retailerModel==null){
            Response response=new Response();
            response.setMessage("Something went wrong please try again later");
            return response;
        }
        else {
            RetailerAddress retailerAddress=new RetailerAddress();
            retailerAddress.setRetailerId(retailerId);

            String houseNumber=retailerAddressUpdateRequest.getHouseNumber();
            retailerAddress.setHouseNumber(houseNumber!=null ? houseNumber:retailerAddress.getHouseNumber());


            String street=retailerAddressUpdateRequest.getStreet();
            retailerAddress.setStreet(street!=null ? street:retailerAddress.getStreet());

            String landMark=retailerAddressUpdateRequest.getLandMark();
            retailerAddress.setLandMark(landMark!=null ? landMark:retailerAddress.getLandMark());

            String pinCode=retailerAddressUpdateRequest.getPinCode();
            retailerAddress.setPinCode(pinCode!=null ? pinCode:retailerAddress.getPinCode());

            String town=retailerAddressUpdateRequest.getTown();
            retailerAddress.setTown(town!=null ? town:retailerAddress.getTown());

            String state=retailerAddressUpdateRequest.getState();
            retailerAddress.setState(state!=null ? state:retailerAddress.getState());

            String country=retailerAddressUpdateRequest.getCountry();
            retailerAddress.setCountry(country!=null ? country:retailerAddress.getCountry());

            retailerAddressRepository.save(retailerAddress);

            retailerModel.setRetailerAddress(retailerAddressRepository.findByRetailerId(retailerId));
            retailerRepository.save(retailerModel);

            return retailerRepository.findByRetailerId(retailerId);
        }
    }
}
