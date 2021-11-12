package uz.tuit.onlinelearningsystem.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.tuit.onlinelearningsystem.entity.Course;
import uz.tuit.onlinelearningsystem.entity.User;
import uz.tuit.onlinelearningsystem.payload.request.CourseRequest;
import uz.tuit.onlinelearningsystem.payload.response.PageableResponse;
import uz.tuit.onlinelearningsystem.repository.CourseRepository;

import javax.annotation.security.RolesAllowed;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TestService {

    public String test() {
        return "Hello !";
    }

}