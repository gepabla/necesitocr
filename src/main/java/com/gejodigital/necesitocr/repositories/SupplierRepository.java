package com.gejodigital.necesitocr.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gejodigital.necesitocr.entities.Supplier;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Integer>{
	public List<Supplier> findBySupplierTags_Tag_NameLike(String tagName);	
}
