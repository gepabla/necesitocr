package com.gejodigital.necesitocr.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gejodigital.necesitocr.dto.SupplierDTO;
import com.gejodigital.necesitocr.entities.Supplier;
import com.gejodigital.necesitocr.response.SupplierResponse;
import com.gejodigital.necesitocr.service.SupplierService;

@RestController
@RequestMapping(value="/api/supplier")
public class SupplierWS {
	
	@Autowired private SupplierService supplierService;
	
	@Autowired private EntityManagerFactory emf;
	
	@RequestMapping(value="/getByTags", method = RequestMethod.POST)
	public SupplierResponse getByTags(@RequestBody List<String> tagNames,HttpServletResponse httpResponse){
		SupplierResponse response = new SupplierResponse();
		try {			
			
			List<Supplier> suppliers = new ArrayList<Supplier>();
			
			tagNames.forEach(name -> {
				List<Supplier> tmp = supplierService.findBySupplierTags_Tag_NameLike("%"+name+"%");
				if(tmp != null && tmp.size() > 0){
					suppliers.addAll(tmp);
				}
			});
			
			List<SupplierDTO> dtos = suppliers.stream().distinct().map(sup -> {
				SupplierDTO tmp = new SupplierDTO();
				BeanUtils.copyProperties(sup, tmp);
				return tmp;
			}).collect(Collectors.toList());
			
			response.setSuppliers(dtos);			
			response.setMessage(HttpStatus.OK.getReasonPhrase());
			response.setStatusCode(HttpStatus.OK.value());
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			httpResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());			
		}
		
		return response;
	}
}
