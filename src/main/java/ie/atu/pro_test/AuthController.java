package ie.atu.pro_test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;


    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Person person){
        return ResponseEntity.ok(authService.signUp(person));
    }

    @PostMapping("/login/{userId}")
    public ResponseEntity<String> login(@PathVariable String userId, @RequestBody String password){
        System.out.println("Login Request - userId: " + userId + ", password: " + password);
        return ResponseEntity.ok(authService.login(userId,password.replaceAll("\"", "").trim()));
    }

}
