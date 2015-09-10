package com.gejodigital.necesitocr.ws;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gejodigital.necesitocr.response.BaseResponse;
import com.gejodigital.necesitocr.service.AdminService;
import com.gejodigital.necesitocr.util.CsvReader;
import com.google.common.io.Files;

@RestController
@RequestMapping(value="/api/admin")
public class AdminWS {
	
	@Autowired AdminService service;
	
	@RequestMapping(value="/loadDbProcess", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {		
        return "You can upload a file by posting to this same URL.";
    }
	
	@RequestMapping(value="/loadDbProcess", method = RequestMethod.POST)
	public @ResponseBody BaseResponse loadDbProcess(@RequestParam("file") MultipartFile file,HttpServletResponse httpResponse){
		BaseResponse response = new BaseResponse();
		try {
			
			if (!file.isEmpty()) {
	            try {
	            	File newFile = new File("file.csv");
	                byte[] bytes = file.getBytes();
	                BufferedOutputStream stream =
	                        new BufferedOutputStream(new FileOutputStream(newFile));
	                stream.write(bytes);
	                stream.close();
	                
	                CsvReader reader = createCsvReader(newFile);
	    			
	                service.loadDatabase(reader.readRecords());
	                
	    			response.setMessage(HttpStatus.OK.getReasonPhrase());
	    			response.setStatusCode(HttpStatus.OK.value());
	            } catch (Exception e) {
	            	e.printStackTrace();
	            	response.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
	    			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    			httpResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());	
	            }
	        } else {
	        	response.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
				response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
				httpResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());	
	        }						
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			httpResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());			
		}
		
		return response;
	}
	private CsvReader createCsvReader(File file) {
        try {           
            Reader reader = Files.newReader(file, Charset.forName("UTF-8"));
            return new CsvReader(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
