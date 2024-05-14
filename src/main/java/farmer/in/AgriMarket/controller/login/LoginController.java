package farmer.in.AgriMarket.controller.login;


import farmer.in.AgriMarket.dto.login.LoginRequest;
import farmer.in.AgriMarket.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("")
    ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(loginService.login(loginRequest), HttpStatus.FOUND);
    }
}
