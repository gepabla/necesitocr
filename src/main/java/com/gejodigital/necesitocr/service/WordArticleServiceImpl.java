package com.gejodigital.necesitocr.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gejodigital.necesitocr.repositories.WordArticleRepository;

@Service
public class WordArticleServiceImpl implements WordArticleService {

	@Autowired private WordArticleRepository wordArtRepo;	
	
	@Override
	public String cleanSearchTerm(String searchTerm) {
		List<String> searchTermArr = Arrays.asList(searchTerm.toUpperCase().split("\\s+"));
		List<String> result = new ArrayList<String>();
		List<Integer> indexes = new ArrayList<Integer>();
		System.out.println(searchTermArr);
		wordArtRepo.findAll().forEach(art -> {
			int searchArt = searchTermArr.indexOf(art.getWordArticle());				
			if(searchArt > -1){
				indexes.add(searchArt);
			}
		});
		
		for(String str : searchTermArr){
			if(!indexes.contains(searchTermArr.indexOf(str))){
				result.add(str.trim());
			}
		}
		
		return result.stream().collect(Collectors.joining(" "));		
	}

}
