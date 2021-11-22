package uz.tuit.onlinelearningsystem.controller;

import org.springframework.web.bind.annotation.*;
import uz.tuit.onlinelearningsystem.entity.Lesson;
import uz.tuit.onlinelearningsystem.payload.request.LessonRequest;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/lesson/")
public class LessonController {

    @PostMapping("save")
    Lesson create(@Valid @RequestBody LessonRequest request){

        return null;
    }
    @GetMapping("{id}")
    Lesson getOne(@PathVariable UUID id){

        return null;
    }
}