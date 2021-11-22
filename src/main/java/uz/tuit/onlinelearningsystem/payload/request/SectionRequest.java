package uz.tuit.onlinelearningsystem.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SectionRequest {
    @NotNull
    private UUID courseId;
    @Size(min = 4,max = 128)
    private String name;
    @Min(0)
    private Integer orderNumber;
}
