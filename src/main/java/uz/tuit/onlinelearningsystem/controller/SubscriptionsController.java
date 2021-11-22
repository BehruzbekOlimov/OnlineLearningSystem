package uz.tuit.onlinelearningsystem.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.tuit.onlinelearningsystem.entity.Subscriptions;

@RestController
@RequestMapping("/api/subscriptions/")
public class SubscriptionsController {
    @PostMapping("save")
    Subscriptions create() {

        return null;
    }
}
