package com.gejodigital.necesitocr.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gejodigital.necesitocr.entities.WordArticle;

@Repository
public interface WordArticleRepository extends CrudRepository<WordArticle, Integer>{

}
