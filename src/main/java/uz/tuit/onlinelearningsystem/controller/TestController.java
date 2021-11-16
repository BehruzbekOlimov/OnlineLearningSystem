package uz.tuit.onlinelearningsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.tuit.onlinelearningsystem.payload.request.PageAttributesRequest;
import uz.tuit.onlinelearningsystem.payload.request.UserAuthRequest;
import uz.tuit.onlinelearningsystem.payload.response.UserWithJwtResponse;
import uz.tuit.onlinelearningsystem.service.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/test/")
@AllArgsConstructor
public class TestController {

    private final AuthService authService;

    @GetMapping("test1")
    @PreAuthorize("permitAll()")
    ResponseEntity<PageAttributesRequest> test1(@Valid @RequestAttribute PageAttributesRequest req) {
        return ResponseEntity.ok(req);
    }

    @PostMapping("test2")
    @PreAuthorize("permitAll()")
    UserWithJwtResponse signIn(@Valid @RequestBody UserAuthRequest req) {
        return authService.auth(req);
    }
}
