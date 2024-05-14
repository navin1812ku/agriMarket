package farmer.in.AgriMarket.controller.product;


import farmer.in.AgriMarket.service.product.ProductDeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/deletion")
public class ProductDeletionController {

    @Autowired
    private ProductDeletionService productDeletionService;

    @DeleteMapping("/{productId}")
    ResponseEntity<Object> productDeletion(@PathVariable Long productId){
        return new ResponseEntity<>(productDeletionService.deleteProduct(productId), HttpStatus.OK);
    }
}
