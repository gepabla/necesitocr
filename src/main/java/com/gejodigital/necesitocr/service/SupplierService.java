package com.gejodigital.necesitocr.service;

import java.util.List;

import com.gejodigital.necesitocr.entities.Supplier;

public interface SupplierService {
	public List<Supplier> findBySupplierTags_Tag_NameLike(String tagNames);
}
