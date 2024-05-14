package farmer.in.AgriMarket.controller.search;


import farmer.in.AgriMarket.service.search.SearchByProductNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/search")
public class SearchByProductNameController {

    @Autowired
    private SearchByProductNameService searchByProductNameService;

    @GetMapping("/{productName}")
    ResponseEntity<Object> searchProduct(@PathVariable String productName){
        return new ResponseEntity<>(searchByProductNameService.searchByProductName(productName), HttpStatus.FOUND);
    }

}
