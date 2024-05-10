package farmer.in.AgriMarket.controller.product;


import farmer.in.AgriMarket.service.product.GetAllProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product/set")
public class GetAllProductsController {

    @Autowired
    private GetAllProductsService getAllProductsService;

    @GetMapping("/")
    public ResponseEntity<Object> getAllProducts(){
        return new ResponseEntity<>(getAllProductsService.getAllProducts(), HttpStatus.FOUND);
    }
}
