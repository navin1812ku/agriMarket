package farmer.in.AgriMarket.controller.product;


import farmer.in.AgriMarket.dto.product.AddProductRequest;
import farmer.in.AgriMarket.service.product.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class AddProductController {

    @Autowired
    private AddProductService addProductService;

    @PostMapping("/newOne")
    ResponseEntity<Object> addProduct(@RequestBody AddProductRequest addProductRequest){
        return new ResponseEntity<>(addProductService.addProduct(addProductRequest), HttpStatus.CREATED);
    }
}
