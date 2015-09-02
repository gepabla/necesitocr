package com.gejodigital.necesitocr.service;

import java.util.List;

import com.gejodigital.necesitocr.entities.Tag;

public interface TagService {
	public List<Tag> findByName(String name);
}
