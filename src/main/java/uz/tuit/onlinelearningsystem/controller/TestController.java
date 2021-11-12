package uz.tuit.onlinelearningsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.*;
import uz.tuit.onlinelearningsystem.entity.Course;
import uz.tuit.onlinelearningsystem.payload.request.CourseRequest;
import uz.tuit.onlinelearningsystem.service.CourseService;
import uz.tuit.onlinelearningsystem.service.TestService;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/test/")
@AllArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("test11")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    String test(){
        return testService.test();
    }
    @GetMapping("test2")

    String test2(){
        return "Hello2!";
    }
}
