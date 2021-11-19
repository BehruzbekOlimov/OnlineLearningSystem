package uz.tuit.onlinelearningsystem.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import uz.tuit.onlinelearningsystem.payload.request.PageAttributesRequest;

public class CommonUtils {
    public static PageRequest getPageRequest(PageAttributesRequest pageRequest){
        return PageRequest.of(pageRequest.getPage(), pageRequest.getSize(),
                Sort.by(pageRequest.getAscending()?Sort.Direction.ASC: Sort.Direction.DESC,pageRequest.getSortBy()));
    }
}
