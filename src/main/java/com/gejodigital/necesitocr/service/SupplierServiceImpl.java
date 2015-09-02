package com.gejodigital.necesitocr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gejodigital.necesitocr.entities.Supplier;
import com.gejodigital.necesitocr.repositories.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired private SupplierRepository repo;
	@Override
	public List<Supplier> findBySupplierTags_Tag_NameLike(String tagName) {
		return repo.findBySupplierTags_Tag_NameLike(tagName);
	}

}
