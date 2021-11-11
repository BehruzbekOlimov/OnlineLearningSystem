package uz.tuit.onlinelearningsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.tuit.onlinelearningsystem.payload.request.UserAuthRequest;
import uz.tuit.onlinelearningsystem.payload.request.UserRegisterRequest;
import uz.tuit.onlinelearningsystem.payload.response.UserWithJwtResponse;
import uz.tuit.onlinelearningsystem.service.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("register")
    @PreAuthorize("permitAll()")
    UserWithJwtResponse register(@Valid @RequestBody UserRegisterRequest req) {
        return authService.register(req);
    }

    @PostMapping("signIn")
    @PreAuthorize("permitAll()")
    UserWithJwtResponse signIn(@Valid @RequestBody UserAuthRequest req) {
        return authService.auth(req);
    }

}
