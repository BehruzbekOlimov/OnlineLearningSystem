package uz.tuit.onlinelearningsystem.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.tuit.onlinelearningsystem.entity.Course;
import uz.tuit.onlinelearningsystem.entity.User;
import uz.tuit.onlinelearningsystem.payload.request.CourseRequest;
import uz.tuit.onlinelearningsystem.payload.request.PageAttributesRequest;
import uz.tuit.onlinelearningsystem.payload.response.PageableResponse;
import uz.tuit.onlinelearningsystem.repository.CourseRepository;
import uz.tuit.onlinelearningsystem.utils.CommonUtils;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final AuthService authService;

    public Course create(CourseRequest request) {
        Course course = new Course();
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        User teacher = authService.getMe();
        course.setTeacher(teacher);
        course = courseRepository.save(course);
        return course;
    }

    public Course getOne(UUID id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public PageableResponse<Course> getAll(PageAttributesRequest pageRequest) {
        PageableResponse<Course> response = new PageableResponse<>();
        Page<Course> page = courseRepository.findAll(CommonUtils.getPageRequest(pageRequest));
        response.setData(page.getContent());
        response.setCountItems(page.getTotalElements());
        return response;
    }

}