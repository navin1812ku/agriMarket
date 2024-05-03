package farmer.in.AgriMarket.controller.search;


import farmer.in.AgriMarket.service.search.RetailerIdProfileSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retailerIdProfileSearch")
public class RetailerIdProfileSearchController {

    @Autowired
    private RetailerIdProfileSearchService retailerIdProfileSearchService;

    @GetMapping("/{retailerId}")
    ResponseEntity<Object> retailerIdSearch(@PathVariable String retailerId){
        return new ResponseEntity<>(retailerIdProfileSearchService.retailerIdSearch(retailerId), HttpStatus.FOUND);
    }
}
