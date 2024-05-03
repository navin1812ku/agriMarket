package farmer.in.AgriMarket.controller.search;


import farmer.in.AgriMarket.service.search.IdProfileSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class IdProfileSearchController {

    @Autowired
    private IdProfileSearchService idProfileSearchService;

    @GetMapping("/{id}")
    ResponseEntity<Object> search(@PathVariable String id){
        return new ResponseEntity<>(idProfileSearchService.search(id), HttpStatus.FOUND);
    }
}
