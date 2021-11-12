package uz.tuit.onlinelearningsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.tuit.onlinelearningsystem.entity.User;
import uz.tuit.onlinelearningsystem.payload.request.UserRegisterRequest;
import uz.tuit.onlinelearningsystem.service.UserManagementService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/user-management/")
@AllArgsConstructor
public class UserManagementController {
    private final UserManagementService userManagementService;

    @PostMapping("create-moderator")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    User createModerator(@Valid @RequestBody UserRegisterRequest request){
        return userManagementService.createModerator(request);
    }

    @PostMapping("create-teacher")
    @PreAuthorize("hasAnyAuthority('MODERATOR')")
    User createTeacher(@Valid @RequestBody UserRegisterRequest request){
        return userManagementService.createTeacher(request);
    }
}
