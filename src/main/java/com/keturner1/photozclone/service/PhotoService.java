package com.keturner1.photozclone.service;

import com.keturner1.photozclone.model.Photo;
import com.keturner1.photozclone.repository.PhotoRepository;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Iterable<Photo> get() {
        return photoRepository.findAll();
    }

    public Photo get(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photoRepository.deleteById(id);
    }

    public Photo save(String name, String type, byte[] data) {
        Photo photo = new Photo();
        photo.setName(name);
        photo.setType(type);
        photo.setData(data);
        photoRepository.save(photo);
        return photo;
    }
}
