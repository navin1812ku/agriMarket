package farmer.in.AgriMarket.controller.search;


import farmer.in.AgriMarket.dto.search.SearchProductByPriceRequest;
import farmer.in.AgriMarket.service.search.SearchProductByPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/searchByPrice")
public class SearchProductByPriceController {

    @Autowired
    private SearchProductByPriceService searchProductByPriceService;

    @GetMapping("")
    ResponseEntity<Object> searchByPrice(@RequestBody SearchProductByPriceRequest searchProductByPriceRequest){
        return new ResponseEntity<>(searchProductByPriceService.searchProductByPrice(searchProductByPriceRequest), HttpStatus.FOUND);
    }
}
