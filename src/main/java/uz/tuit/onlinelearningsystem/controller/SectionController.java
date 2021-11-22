package uz.tuit.onlinelearningsystem.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.tuit.onlinelearningsystem.entity.Section;

@RestController
@RequestMapping("/api/section/")
public class SectionController {

    @PostMapping("save")
    Section create(){

        return null;
    }
}
