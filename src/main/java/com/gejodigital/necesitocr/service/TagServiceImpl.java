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
	public Tag findByName(String name) {
		return tagRepo.findFirstByName(name);
	}

	@Override
	public List<Tag> searchByName(String tagName, Boolean isGeo) {
		return tagRepo.findByNameLikeAndIsGeo(tagName,isGeo);
	}

}
