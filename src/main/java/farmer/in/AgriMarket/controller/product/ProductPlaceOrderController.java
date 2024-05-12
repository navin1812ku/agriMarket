package farmer.in.AgriMarket.controller.product;

import farmer.in.AgriMarket.dto.product.ProductPlaceOrderRequest;
import farmer.in.AgriMarket.service.product.ProductPlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/placeOrder")
public class ProductPlaceOrderController {

    @Autowired
    private ProductPlaceOrderService productPlaceOrderService;

    @PutMapping
    ResponseEntity<Object> placeOrder(@RequestBody ProductPlaceOrderRequest productPlaceOrderRequest){
        return new ResponseEntity<>(productPlaceOrderService.placeOrder(productPlaceOrderRequest), HttpStatus.CREATED);
    }
}
