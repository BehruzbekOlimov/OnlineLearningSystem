package uz.tuit.onlinelearningsystem.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageAttributesRequest {
    @Min(value = 0)
    private Integer page=0;
    @Min(value = 1)
    @Max(value = 200)
    private Integer size=10;
}