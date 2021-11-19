package uz.tuit.onlinelearningsystem.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseRequest {
    @Size(max = 255)
    private String description;
    @NotNull
    @Size(min = 3,max = 32)
    private String name;
}
