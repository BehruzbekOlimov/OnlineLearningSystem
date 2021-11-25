package uz.tuit.onlinelearningsystem.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.tuit.onlinelearningsystem.config.jwt.JwtUtils;
import uz.tuit.onlinelearningsystem.entity.User;
import uz.tuit.onlinelearningsystem.payload.request.UserAuthRequest;
import uz.tuit.onlinelearningsystem.payload.request.UserRegisterRequest;
import uz.tuit.onlinelearningsystem.payload.response.UserWithJwtResponse;
import uz.tuit.onlinelearningsystem.repository.UserRepository;

import javax.swing.*;

@Service
@AllArgsConstructor
public class AuthService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final JwtUtils jwtUtils;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!")
        );
    }

    public UserWithJwtResponse register(UserRegisterRequest req) {
        User user = new User();
        user.setLastName(req.getLastName());
        user.setFirstName(req.getFirstName());
        user.setAddress(req.getAddress());
        user.setPhoneNumber(req.getPhoneNumber());
        User match = userRepository.findByUsername(req.getUsername().trim()).orElse(null);
        if (match != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Current username is already exists");
        user.setUsername(req.getUsername().trim());
        user.setPassword(passwordEncoder.encode(req.getPassword()));

        userRepository.save(user);
        String jwt = JwtUtils.TOKEN_PREFIX + jwtUtils.generateToken(user.getUsername());
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        return new UserWithJwtResponse(
                user,
                jwt
        );
    }

    public UserWithJwtResponse auth(UserAuthRequest req) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(req.getUsername().trim(), req.getPassword().trim());

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        User user = userRepository.findByUsername(req.getUsername().trim())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        String jwt = JwtUtils.TOKEN_PREFIX + jwtUtils.generateToken(user.getUsername());

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        return new UserWithJwtResponse(
                user,
                jwt
        );
    }

    public User getMe(){
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            username = ((UserDetails) principal).getUsername();
        }else {
            username = principal.toString();
        }
        return userRepository.findByUsername(username).orElse(null);
    }
}
