package uz.tuit.onlinelearningsystem.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.tuit.onlinelearningsystem.entity.Lesson;

@RestController
@RequestMapping("/api/lesson/")
public class LessonController {

    @PostMapping("save")
    Lesson create(){

        return null;
    }
}