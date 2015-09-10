package com.gejodigital.necesitocr.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gejodigital.necesitocr.entities.SupplierTag;

@Repository
public interface SupplierTagRepository extends CrudRepository<SupplierTag, Integer>{

}
