package uz.tuit.onlinelearningsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.tuit.onlinelearningsystem.entity.User;
import uz.tuit.onlinelearningsystem.payload.request.UserAuthRequest;
import uz.tuit.onlinelearningsystem.payload.request.UserRegisterRequest;
import uz.tuit.onlinelearningsystem.payload.response.UserWithJwtResponse;
import uz.tuit.onlinelearningsystem.service.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("register")
    UserWithJwtResponse register(@Valid @RequestBody UserRegisterRequest req) {
        return authService.register(req);
    }

    @PostMapping("sign-in")
    UserWithJwtResponse signIn(@Valid @RequestBody UserAuthRequest req) {
        return authService.auth(req);
    }

    @GetMapping("get-me")
    User getMe(){
        return authService.getMe();
    }

}
