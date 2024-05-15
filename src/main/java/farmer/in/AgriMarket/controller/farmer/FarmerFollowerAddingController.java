package farmer.in.AgriMarket.controller.farmer;


import farmer.in.AgriMarket.dto.farmer.FarmerFollowerRequest;
import farmer.in.AgriMarket.service.farmer.FarmerFollowerAddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farmer/followerAdding")
public class FarmerFollowerAddingController {

    @Autowired
    private FarmerFollowerAddingService farmerFollowerAddingService;

    @PostMapping("")
    ResponseEntity<Object> addingFollower(@RequestBody FarmerFollowerRequest farmerFollowerRequest){
        return new ResponseEntity<>(farmerFollowerAddingService.addFollowerToFarmer(farmerFollowerRequest), HttpStatus.CREATED);
    }
}
