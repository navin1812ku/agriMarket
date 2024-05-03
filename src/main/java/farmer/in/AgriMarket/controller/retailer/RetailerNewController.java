package farmer.in.AgriMarket.controller.retailer;


import farmer.in.AgriMarket.dto.retailer.RetailerNewRequest;
import farmer.in.AgriMarket.service.retailer.RetailerNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/retailer")
public class RetailerNewController {

    @Autowired
    private RetailerNewService retailerNewService;

    @PostMapping("/newRetailer")
    ResponseEntity<List<Object>> addRetailer(@RequestBody RetailerNewRequest retailerNewRequest){
        return new ResponseEntity<>(retailerNewService.addRetailer(retailerNewRequest), HttpStatus.CREATED);
    }
}
