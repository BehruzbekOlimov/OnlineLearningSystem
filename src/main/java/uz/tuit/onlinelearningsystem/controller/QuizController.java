package uz.tuit.onlinelearningsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.tuit.onlinelearningsystem.entity.Quiz;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/quiz/")
@AllArgsConstructor
public class QuizController {

    @PostMapping("start")
    Quiz start(@Valid @RequestBody UUID lessonId){

        return null;
    }
}
