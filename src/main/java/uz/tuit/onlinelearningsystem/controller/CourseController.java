package uz.tuit.onlinelearningsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.tuit.onlinelearningsystem.entity.Course;
import uz.tuit.onlinelearningsystem.payload.request.CourseRequest;
import uz.tuit.onlinelearningsystem.service.CourseService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/course/")
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("save")
    @PreAuthorize("hasAnyAuthority('TEACHER')")
    Course saveCourse(@Valid @RequestBody CourseRequest request){
        return courseService.create(request);
    }
}
