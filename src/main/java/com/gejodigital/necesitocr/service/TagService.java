package com.gejodigital.necesitocr.service;

import java.util.List;

import com.gejodigital.necesitocr.entities.Tag;

public interface TagService {
	public Tag findByName(String name);
	public List<Tag> searchByName(String tagName);
}
