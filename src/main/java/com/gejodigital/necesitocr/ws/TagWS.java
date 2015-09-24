package com.gejodigital.necesitocr.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gejodigital.necesitocr.dto.TagDTO;
import com.gejodigital.necesitocr.entities.Tag;
import com.gejodigital.necesitocr.response.TagResponse;
import com.gejodigital.necesitocr.service.TagService;

@RestController
@RequestMapping(value="/api/tag")
public class TagWS {
	
	@Autowired private TagService service;
	
	@RequestMapping(value="/getByName", method = RequestMethod.POST)
	public TagResponse getByName(@RequestBody String tagName,HttpServletResponse httpResponse){
		TagResponse response = new TagResponse();
		try {
			List<Tag> tags = new ArrayList<Tag>(); 
			tags.add(service.findByName(tagName));
			List<TagDTO> dtos = tags.stream().map(tag -> {
				TagDTO tmp = new TagDTO();
				tmp.setName(tag.getName());
				return tmp;
			}).collect(Collectors.toList());
			response.setTags(dtos);			
			response.setMessage(HttpStatus.OK.getReasonPhrase());
			response.setStatusCode(HttpStatus.OK.value());
		} catch (Exception e) {
			response.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			httpResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());			
		}
		
		return response;
	}
	
	@RequestMapping(value="/searchByName", method = RequestMethod.GET)
	public TagResponse searchByName(@RequestParam String tagName,HttpServletResponse httpResponse){
		TagResponse response = new TagResponse();
		try {
			List<Tag> tags = service.searchByName("%"+tagName+"%"); 			
			List<TagDTO> dtos = tags.stream().map(tag -> {
				TagDTO tmp = new TagDTO();
				tmp.setName(tag.getName());
				return tmp;
			}).collect(Collectors.toList());
			response.setTags(dtos);			
			response.setMessage(HttpStatus.OK.getReasonPhrase());
			response.setStatusCode(HttpStatus.OK.value());
		} catch (Exception e) {
			response.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			httpResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());			
		}
		
		return response;
	}
	
}
