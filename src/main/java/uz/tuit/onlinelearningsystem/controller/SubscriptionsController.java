package uz.tuit.onlinelearningsystem.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.tuit.onlinelearningsystem.entity.Subscriptions;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/subscriptions/")
public class SubscriptionsController {

    @PostMapping("save")
    Subscriptions create(@Valid @RequestBody UUID courseId) {

        return null;
    }
}
