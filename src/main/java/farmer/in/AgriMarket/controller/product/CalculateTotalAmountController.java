package farmer.in.AgriMarket.controller.product;


import farmer.in.AgriMarket.dto.product.CalculateTotalAmountRequest;
import farmer.in.AgriMarket.service.product.CalculateTotalAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class CalculateTotalAmountController {

    @Autowired
    private CalculateTotalAmountService calculateTotalAmountService;

    @PutMapping("/update")
    public ResponseEntity<Object> updateProductByQuantity(@RequestBody CalculateTotalAmountRequest calculateTotalAmountRequest){
        return new ResponseEntity<>(calculateTotalAmountService.updateProductByQuantity(calculateTotalAmountRequest), HttpStatus.ACCEPTED);
    }
}
