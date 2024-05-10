package farmer.in.AgriMarket.controller.retailer;

import farmer.in.AgriMarket.dto.retailer.RetailerAddressUpdateRequest;
import farmer.in.AgriMarket.service.retailer.RetailerAddressUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/retailer/retailerAddressUpdate")
public class RetailerAddressUpdateController {

    @Autowired
    private RetailerAddressUpdateService retailerAddressUpdateService;

    @PutMapping("/{retailerId}")
    ResponseEntity<Object> addressUpdate(@PathVariable String retailerId, @RequestBody RetailerAddressUpdateRequest retailerAddressUpdateRequest){
        return new ResponseEntity<>(retailerAddressUpdateService.addressUpdate(retailerId, retailerAddressUpdateRequest), HttpStatus.ACCEPTED);
    }
}
