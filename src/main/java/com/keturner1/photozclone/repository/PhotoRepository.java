package com.keturner1.photozclone.repository;

import com.keturner1.photozclone.model.Photo;
import org.springframework.data.repository.CrudRepository;


public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
