package farmer.in.AgriMarket.controller.admin;


import farmer.in.AgriMarket.service.admin.IdDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/deleteId")
public class IdDeleteController {

    @Autowired
    private IdDeleteService idDeleteService;

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteId(@PathVariable String id){
        return new ResponseEntity<>(idDeleteService.deleteId(id), HttpStatus.OK);
    }
}
