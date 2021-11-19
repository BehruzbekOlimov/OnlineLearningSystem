package uz.tuit.onlinelearningsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.tuit.onlinelearningsystem.entity.Course;
import uz.tuit.onlinelearningsystem.payload.request.CourseRequest;
import uz.tuit.onlinelearningsystem.payload.request.PageAttributesRequest;
import uz.tuit.onlinelearningsystem.payload.response.PageableResponse;
import uz.tuit.onlinelearningsystem.service.CourseService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/course/")
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("save")
    Course saveCourse(@Valid @RequestBody CourseRequest request){
        return courseService.create(request);
    }

    @GetMapping("get/{id}")
    Course getCourse(@PathVariable UUID id){
        return courseService.getOne(id);
    }

    @GetMapping("all")
    PageableResponse<Course> getAll(@Valid @ModelAttribute PageAttributesRequest request){
        return courseService.getAll(request);
    }
}
