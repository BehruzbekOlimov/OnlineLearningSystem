package uz.tuit.onlinelearningsystem.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageableResponse<E> {
    private List<E> data;
    private Long countItems;
}
