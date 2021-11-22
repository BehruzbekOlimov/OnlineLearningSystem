package uz.tuit.onlinelearningsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.tuit.onlinelearningsystem.entity.Test;
import uz.tuit.onlinelearningsystem.payload.request.TestRequest;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/test/")
@AllArgsConstructor
public class TestController {

    @PostMapping("save")
    Test create(@Valid @RequestBody TestRequest request){

        return null;
    }
    @GetMapping("{id}")
    Test getOne(@PathVariable UUID id){

        return null;
    }

}
