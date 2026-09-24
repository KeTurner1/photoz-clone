package com.keturner1.photozclone.service;

import com.keturner1.photozclone.model.Photo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotoService {

    private Map<String, Photo> db = new HashMap<>() {
        {
            put("1", new Photo("1", "Photo 1"));
            put("2", new Photo("2", "Photo 2"));
            put("3", new Photo("3", "Photo 3"));
        }
    };

    public Collection<Photo> findAll() {
        return db.values();
    }

    public Photo get(String id) {
        return db.get(id);
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo save(String name, String type, byte[] data) throws IOException {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setName(name);
        photo.setType(type);
        photo.setData(data);
        db.put(photo.getId(), photo);
        return photo;
    }
}
