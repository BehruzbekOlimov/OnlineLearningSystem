package uz.tuit.onlinelearningsystem.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import uz.tuit.onlinelearningsystem.entity.enums.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {
    @NotBlank
    @Size(min = 2, max = 32, message = "firstName size must be between 2 and 32")
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 32, message = "lastName size must be between 2 and 32")
    private String lastName;

    @Size(min = 2, max = 255, message = "address size must be between 2 and 255")
    private String address;

    @Size(min = 2, max = 16, message = "phoneNumber size must be between 2 and 16")
    private String phoneNumber;

    @NotBlank
    @Size(min = 4, max = 64, message = "Username size must be between 4 and 64")
    private String username;

    @NotBlank
    @Size(min = 6, message = "Password min size 6")
    private String password;
}
