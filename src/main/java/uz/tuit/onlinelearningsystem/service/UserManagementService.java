package uz.tuit.onlinelearningsystem.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tuit.onlinelearningsystem.entity.User;
import uz.tuit.onlinelearningsystem.entity.enums.Role;
import uz.tuit.onlinelearningsystem.payload.request.UserRegisterRequest;
import uz.tuit.onlinelearningsystem.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserManagementService {
    private final AuthService authService;
    private final UserRepository userRepository;

    @Transactional
    public User createModerator(UserRegisterRequest request){
        User moderator = authService.register(request).getUser();
        moderator.setRole(Role.MODERATOR);
        moderator = userRepository.save(moderator);
        return moderator;
    }

    @Transactional
    public User createTeacher(UserRegisterRequest request) {
        User teacher = authService.register(request).getUser();
        teacher.setRole(Role.TEACHER);
        teacher = userRepository.save(teacher);
        return teacher;
    }
}
