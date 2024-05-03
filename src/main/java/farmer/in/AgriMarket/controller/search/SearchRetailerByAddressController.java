package farmer.in.AgriMarket.controller.search;


import farmer.in.AgriMarket.service.search.SearchRetailerByAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/searchRetailerByAddress")
public class SearchRetailerByAddressController {

    @Autowired
    private SearchRetailerByAddressService searchRetailerByAddressService;

    @GetMapping("/{location}")
    ResponseEntity<Object> searchRetailerByAddress(@PathVariable String location){
        return new ResponseEntity<>(searchRetailerByAddressService.searchRetailerByAddress(location), HttpStatus.FOUND);
    }
}
