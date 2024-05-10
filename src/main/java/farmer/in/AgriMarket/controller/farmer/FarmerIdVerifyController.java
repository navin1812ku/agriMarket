package farmer.in.AgriMarket.controller.farmer;


import farmer.in.AgriMarket.service.farmer.FarmerIdVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farmer/farmerIdVerify")
public class FarmerIdVerifyController {

    @Autowired
    private FarmerIdVerifyService farmerIdVerifyService;

    @GetMapping("/{farmerId}")
    ResponseEntity<Object> idVerify(@PathVariable String farmerId){
        return new ResponseEntity<>(farmerIdVerifyService.idVerify(farmerId), HttpStatus.FOUND);
    }
}
