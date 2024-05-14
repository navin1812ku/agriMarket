package farmer.in.AgriMarket.controller.product;


import farmer.in.AgriMarket.dto.product.ProductUpdateRequest;
import farmer.in.AgriMarket.service.product.ProductUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product/update")
public class ProductUpdateController {

    @Autowired
    private ProductUpdateService productUpdateService;

    @PutMapping("/{productId}")
    ResponseEntity<Object> productUpdate(@PathVariable Long productId, @RequestBody ProductUpdateRequest productUpdateRequest){
        return new ResponseEntity<>(productUpdateService.updateProduct(productId, productUpdateRequest), HttpStatus.ACCEPTED);
    }
}
