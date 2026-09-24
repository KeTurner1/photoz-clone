package com.keturner1.photozclone.web;

import com.keturner1.photozclone.model.Photo;
import com.keturner1.photozclone.service.PhotoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {

    private final PhotoService photoService;

    public DownloadController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id) {
        Photo photo = photoService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        byte[] data = photo.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getType()));
        ContentDisposition builder = ContentDisposition
                .builder("attachment")
                .filename(photo.getName())
                .build();
        headers.setContentDisposition(builder);
        
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
