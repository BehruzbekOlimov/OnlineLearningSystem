package uz.tuit.onlinelearningsystem.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.tuit.onlinelearningsystem.entity.Section;
import uz.tuit.onlinelearningsystem.entity.enums.TypeRate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LessonRequest {
    @NotNull
    private UUID sectionId;
    @NotNull
    @Size(min = 4, max = 128)
    private String name;
    @NotNull
    @Size(min = 128, max = 10240)
    private String content;
    @NotNull
    private TypeRate typeRate;
    @Min(0)
    private Integer orderNumber;
    @Min(0)
    private Integer countTest=0;
    @Min(1)
    private Integer maxAttempts = Integer.MAX_VALUE;
}
