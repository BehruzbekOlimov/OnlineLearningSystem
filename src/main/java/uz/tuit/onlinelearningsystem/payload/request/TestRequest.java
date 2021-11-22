package uz.tuit.onlinelearningsystem.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.tuit.onlinelearningsystem.entity.Lesson;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestRequest {
    @NotNull
    private UUID lessonId;
    @NotNull
    @Size(min = 4, max = 1024)
    private String question;
    @NotNull
    @Size(min = 4, max = 255)
    private String answer;
    @NotNull
    @Size(min = 4, max = 255)
    private String variant_b;
    @NotNull
    @Size(min = 4, max = 255)
    private String variant_c;
    @NotNull
    @Size(min = 4, max = 255)
    private String variant_d;
}
