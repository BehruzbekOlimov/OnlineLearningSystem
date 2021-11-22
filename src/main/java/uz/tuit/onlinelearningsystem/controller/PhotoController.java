package uz.tuit.onlinelearningsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.tuit.onlinelearningsystem.entity.Photo;
import uz.tuit.onlinelearningsystem.service.PhotoService;

import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/photo/")
public class PhotoController {
    private final PhotoService photoService;

    @PostMapping("create")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(photoService.save(file));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(String.format("Could not upload the file: %s!", file.getOriginalFilename()));
        }
    }

    @GetMapping(value = "image/{id}", produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity<byte[]> getPhoto(@PathVariable UUID id) {
        Optional<Photo> photoOptional = photoService.getPhoto(id);

        if (!photoOptional.isPresent()) {
            return ResponseEntity.notFound()
                    .build();
        }

        Photo photo = photoOptional.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photo.getFileType() + "\"")
                .contentType(MediaType.valueOf(photo.getFileType()))
                .contentLength(photo.getSize())
                .body(photo.getAttachment().getData());
    }

    @GetMapping(value = "thumbnail/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getThumbnail(@PathVariable UUID id) {
        Optional<Photo> photoOptional = photoService.getPhoto(id);

        if (!photoOptional.isPresent()) {
            return ResponseEntity.notFound()
                    .build();
        }

        Photo photo = photoOptional.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photo.getFileType() + "\"")
                .contentType(MediaType.valueOf(photo.getFileType()))
                .contentLength(photo.getSize())
                .body(photo.getThumbnailAttachment().getData());
    }

}