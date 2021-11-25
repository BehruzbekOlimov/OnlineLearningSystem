package uz.tuit.onlinelearningsystem.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.imgscalr.Scalr;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uz.tuit.onlinelearningsystem.entity.Attachment;
import uz.tuit.onlinelearningsystem.entity.Photo;
import uz.tuit.onlinelearningsystem.repository.AttachmentRepository;
import uz.tuit.onlinelearningsystem.repository.PhotoRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PhotoService {
    private final PhotoRepository photoRepository;
    private final AttachmentRepository attachmentRepository;

    @SneakyThrows
    @Transactional
    public Photo save(MultipartFile file) {
        Photo photo = new Photo();
        photo.setFileName(file.getOriginalFilename());
        photo.setFileType(file.getContentType());
        photo.setSize((int) file.getSize());
        Attachment attachment = new Attachment(file.getBytes());
        attachment = attachmentRepository.save(attachment);
        photo.setAttachment(attachment);
        photo.setUrl(
                ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/photo/image/")
                .path(String.valueOf(photo.getId()))
                .toUriString()
        );
        InputStream inputStream = new ByteArrayInputStream(file.getBytes());
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        bufferedImage = Scalr.resize(bufferedImage, 400);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (Objects.equals(file.getContentType(), "image/png"))
            ImageIO.write(bufferedImage, "png", baos);
        else if (Objects.equals(file.getContentType(), "image/jpeg"))
            ImageIO.write(bufferedImage, "jpg", baos);
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"File type not supported");
        Attachment thumbnailAttachment = new Attachment(baos.toByteArray());
        thumbnailAttachment = attachmentRepository.save(thumbnailAttachment);
        photo.setThumbnailAttachment(thumbnailAttachment);
        photo.setUrl(
                ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/api/photo/thumbnail/")
                        .path(String.valueOf(photo.getId()))
                        .toUriString()
        );
        photo = photoRepository.save(photo);
        return photo;
    }

    public Optional<Photo> getPhoto(UUID id) {
        return photoRepository.findById(id);
    }
}
