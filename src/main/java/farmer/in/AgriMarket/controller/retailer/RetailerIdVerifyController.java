package farmer.in.AgriMarket.controller.retailer;


import farmer.in.AgriMarket.service.retailer.RetailerIdVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retailerIdVerify")
public class RetailerIdVerifyController {

    @Autowired
    private RetailerIdVerifyService retailerIdVerifyService;

    @GetMapping("/{retailerId}")
    ResponseEntity<Object> idVerify(@PathVariable String retailerId){
        return new ResponseEntity<>(retailerIdVerifyService.idVerify(retailerId), HttpStatus.FOUND);
    }
}
