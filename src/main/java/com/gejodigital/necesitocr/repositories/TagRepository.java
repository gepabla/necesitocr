package com.gejodigital.necesitocr.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gejodigital.necesitocr.entities.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer>{
	public List<Tag> findByName(String name);
}
