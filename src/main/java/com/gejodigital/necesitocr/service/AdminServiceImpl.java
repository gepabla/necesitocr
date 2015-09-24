package com.gejodigital.necesitocr.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gejodigital.necesitocr.entities.Supplier;
import com.gejodigital.necesitocr.entities.SupplierTag;
import com.gejodigital.necesitocr.entities.Tag;
import com.gejodigital.necesitocr.entities.WordArticle;
import com.gejodigital.necesitocr.repositories.SupplierRepository;
import com.gejodigital.necesitocr.repositories.SupplierTagRepository;
import com.gejodigital.necesitocr.repositories.TagRepository;
import com.gejodigital.necesitocr.repositories.WordArticleRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	private final static int tagsIndex = 4;
	private final static int supplierAddressIndex = 3;
	private final static int supplierDescriptionIndex = 1;
	private final static int supplierNameIndex = 0;
	private final static int supplierPhoneIndex = 2;
	
	@Autowired private TagRepository tagR;
	@Autowired private SupplierRepository supR;
	@Autowired private SupplierTagRepository stR;
	@Autowired private WordArticleRepository wordArticleR;
	
	@Override
	@Transactional
	public void loadDatabase(List<List<String>> inputArr) {
		stR.deleteAll();
		tagR.deleteAll();
		supR.deleteAll();
		
		inputArr.remove(0);		
		inputArr.forEach(supplierArrTmp -> {
			System.out.println("Procesando este raw " + supplierArrTmp.stream().collect(Collectors.joining(";")));
			
			List<String> supplierArr = supplierArrTmp.stream().map(s -> s.replaceAll("~", ",").trim()).collect(Collectors.toList());
			
			System.out.println("Procesando este parseado " + supplierArr.stream().collect(Collectors.joining(";")));
			
			Supplier supTmp = new Supplier();
			supTmp.setAddress(supplierArr.get(supplierAddressIndex));			
			supTmp.setDescription(supplierArr.get(supplierDescriptionIndex));						
			supTmp.setName(supplierArr.get(supplierNameIndex));
			supTmp.setPhone(supplierArr.get(supplierPhoneIndex));			
			supTmp.setSupplierId(null);
			
			Supplier supTmpClone = supR.save(supTmp);
			
			System.out.println("salvado " + supTmpClone.getSupplierId() + " " + supTmpClone.getName());
			
			List<String> tagNames = Arrays.asList(supplierArr.get(tagsIndex).split(","));
			tagNames.forEach(tagName -> {
				System.out.println("Procesando este tag name: " + tagName);
				Tag tagTmp = tagR.findFirstByName(tagName);
				SupplierTag spTmp = new SupplierTag();
				if(tagTmp == null){
					tagTmp = new Tag();
					tagTmp.setName(tagName);
					tagTmp.setTagId(null);
					tagTmp = tagR.save(tagTmp);
					System.out.println("Tag name no existe, fue creado " + tagName);
				}
				
				spTmp.setSupplier(supTmpClone);
				spTmp.setTag(tagTmp);
				spTmp.setSupplierTagsId(null);
				spTmp = stR.save(spTmp);
				System.out.println("Creando sup tag para este tag: " + tagTmp.getName() + " para este sup: " + supTmpClone.getName());
			});
		});
		
	}

	@Override
	@Transactional
	public void loadWordArticles(List<List<String>> inputArr) {
		wordArticleR.deleteAll();
		inputArr.forEach(inputArtArr ->{			
			WordArticle art = new WordArticle();
			art.setWordArticle(inputArtArr.get(0));
			System.out.println(art);
			wordArticleR.save(art);
		});
	}

}
