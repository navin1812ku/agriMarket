package farmer.in.AgriMarket.controller.search;


import farmer.in.AgriMarket.service.search.SearchFarmerByAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/searchFarmerByAddress")
public class SearchFarmerByAddressController {

    @Autowired
    private SearchFarmerByAddressService searchFarmerByAddressService;

    @GetMapping("/{location}")
    ResponseEntity<Object> searchFarmerByAddress(@PathVariable String location){
        return new ResponseEntity<>(searchFarmerByAddressService.searchFarmerByAddress(location), HttpStatus.FOUND);
    }
}
