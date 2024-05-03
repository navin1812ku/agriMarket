package farmer.in.AgriMarket.controller.search;


import farmer.in.AgriMarket.service.search.FarmerIdProfileSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farmerIdProfileSearch")
public class FarmerIdProfileSearchController {

    @Autowired
    private FarmerIdProfileSearchService farmerIdProfileSearchService;

    @GetMapping("/{farmerId}")
    ResponseEntity<Object> farmerIdSearch(@PathVariable String farmerId){
        return new ResponseEntity<>(farmerIdProfileSearchService.farmerIdSearch(farmerId), HttpStatus.FOUND);
    }
}
