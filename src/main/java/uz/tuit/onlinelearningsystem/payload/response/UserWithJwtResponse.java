package uz.tuit.onlinelearningsystem.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.tuit.onlinelearningsystem.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithJwtResponse {
    private User user;
    private String jwt;
}
