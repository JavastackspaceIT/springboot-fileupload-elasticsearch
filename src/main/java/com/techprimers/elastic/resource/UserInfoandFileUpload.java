package com.techprimers.elastic.resource;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.websocket.server.PathParam;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techprimers.elastic.model.UserInfo;

@RestController
@RequestMapping(value ="user")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserInfoandFileUpload {
	
	@Autowired
	private ServletContext context;
	
	@PostMapping(value ="/create")
	public String createUser(@PathParam("file") MultipartFile file, @PathParam("user") final String user) throws IOException {
		UserInfo userInfo = new ObjectMapper().readValue(user, UserInfo.class);
		System.out.println("userInfo  :"+ userInfo);
		 System.out.println(file.getOriginalFilename());
		System.out.println(file.getBytes().toString());
		System.out.println("user"+user);
		
	   boolean isExits = new File(context.getRealPath("/userprofile/")).exists();
		if(!isExits) {
			new File(context.getRealPath("/userprofile/")).mkdir();
		}
		
		String fileName = file.getOriginalFilename();
		String modifiedFileName = FilenameUtils.getBaseName(fileName)+"_"+System.currentTimeMillis()+"_"+FilenameUtils.getExtension(fileName);
	   File serverFile = new File(context.getRealPath("/userprofile/"+File.separator+modifiedFileName));
	   try {
		   FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
	   }catch (Exception e) {
		// TODO: handle exception
	}
		return "create user ";
	}
}
