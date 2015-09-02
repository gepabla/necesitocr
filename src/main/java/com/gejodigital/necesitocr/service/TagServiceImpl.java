package com.gejodigital.necesitocr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gejodigital.necesitocr.entities.Tag;
import com.gejodigital.necesitocr.repositories.TagRepository;

@Service
public class TagServiceImpl implements TagService {
	
	@Autowired private TagRepository tagRepo;
	
	@Override
	public List<Tag> findByName(String name) {
		return tagRepo.findByName(name);
	}

}
