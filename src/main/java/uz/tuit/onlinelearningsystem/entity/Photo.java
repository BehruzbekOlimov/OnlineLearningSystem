package uz.tuit.onlinelearningsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uz.tuit.onlinelearningsystem.entity.template.RootEntity;

import javax.persistence.*;

@Table(name = "photo")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Photo extends RootEntity {

    private String fileName;
    @Column(length = 32)
    private String fileType;
    private Integer size;
    private String url;
    private String thumbnailUrl;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Attachment attachment;
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Attachment thumbnailAttachment;

    public String getUrl() {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(url)
                .toUriString();
    }

    public String getThumbnailUrl() {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(thumbnailUrl)
                .toUriString();
    }
}