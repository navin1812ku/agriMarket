package farmer.in.AgriMarket.controller.admin;


import farmer.in.AgriMarket.dto.admin.AdminNewRequest;
import farmer.in.AgriMarket.service.admin.AdminNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminNewController {

    @Autowired
    private AdminNewService adminNewService;

    @PostMapping("/newAdmin")
    ResponseEntity<Object> addAdmin(@RequestBody AdminNewRequest adminNewRequest){
        return new ResponseEntity<>(adminNewService.addAdmin(adminNewRequest), HttpStatus.CREATED);
    }
}
