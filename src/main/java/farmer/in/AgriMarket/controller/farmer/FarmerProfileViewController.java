package farmer.in.AgriMarket.controller.farmer;


import farmer.in.AgriMarket.service.farmer.FarmerProfileViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farmer/farmerProfile")
public class FarmerProfileViewController {

    @Autowired
    private FarmerProfileViewService farmerProfileViewService;

    @GetMapping("/{farmerId}")
    ResponseEntity<Object> getProfile(@PathVariable String farmerId){
        return new ResponseEntity<>(farmerProfileViewService.getProfile(farmerId), HttpStatus.FOUND);
    }
}
