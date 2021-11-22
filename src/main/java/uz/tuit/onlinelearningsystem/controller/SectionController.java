package uz.tuit.onlinelearningsystem.controller;

import org.springframework.web.bind.annotation.*;
import uz.tuit.onlinelearningsystem.entity.Section;
import uz.tuit.onlinelearningsystem.payload.request.SectionRequest;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/section/")
public class SectionController {

    @PostMapping("save")
    Section create(@Valid @RequestBody SectionRequest request){

        return null;
    }

    @GetMapping("{id}")
    Section getOne(@PathVariable UUID id){

        return null;
    }
}
