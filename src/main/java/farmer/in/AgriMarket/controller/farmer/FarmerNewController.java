package farmer.in.AgriMarket.controller.farmer;


import farmer.in.AgriMarket.dto.farmer.FarmerNewRequest;
import farmer.in.AgriMarket.service.farmer.FarmerNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/farmer")
public class FarmerNewController {

    @Autowired
    private FarmerNewService farmerNewService;

    @PostMapping("/newFarmer")
    ResponseEntity<List<Object>> addFarmer(@RequestBody FarmerNewRequest farmerNewRequest){
        return new ResponseEntity<>(farmerNewService.addFarmer(farmerNewRequest), HttpStatus.CREATED);
    }
}
