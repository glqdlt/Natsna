package org.natsna.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.natsna.utill.MediaUtiles;
import org.natsna.utill.UploadFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@RequestMapping(value="/file")
@Controller
public class UploadController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@RequestMapping(value="/uploadForm",method=RequestMethod.GET)
	public void uploadForm(){
		
	}
	@RequestMapping(value="/uploadForm",method=RequestMethod.POST)
	public String uploadForm(MultipartFile file, Model model) throws Exception{
		
		System.out.println("origin name:"+file.getOriginalFilename());
		System.out.println("size:"+file.getSize());
		System.out.println("contentType:"+file.getContentType());
		System.out.println(uploadPath);
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
		
		model.addAttribute("savedName",savedName);
		
		return "/file/uploadResult";
	}
	
	@RequestMapping(value="/uploadAjax",method=RequestMethod.GET)
	public void uploadAjax(){
		
	}
	
	//produces="text/plain;charset=UTF-8" 인코딩설정
	@RequestMapping(value="/uploadAjax",method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception{
		System.out.println("origin name:"+file.getOriginalFilename());
		System.out.println("size:"+file.getSize());
		System.out.println("contentType:"+file.getContentType());
		
//		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
		String savedName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		
//		return new ResponseEntity<>(file.getOriginalFilename(), HttpStatus.OK);
		System.out.println(savedName);
		return new ResponseEntity<>(savedName, HttpStatus.OK);
//		return new ResponseEntity<>(savedName), HttpStatus.OK);
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
	
		InputStream in= null;
		ResponseEntity<byte[]> entity = null;
		
		try{
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			
			MediaType mType = MediaUtiles.getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(uploadPath+fileName);
			
			if(mType != null){
				headers.setContentType(mType);
			}else{
				fileName = fileName.substring(fileName.indexOf(".")+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; filename=\""+new String(fileName.getBytes("UTF-8"),"ISO-8859-1")+"\"");
				
				
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers,HttpStatus.OK);
			
			
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}finally{
			in.close();
		}
		
		
		return entity;
		
	}
	
	
	
	
	private String uploadFile(String orignName, byte[] fileData)throws Exception{
		UUID uid = UUID.randomUUID();
		
		String saveName =uid.toString()+"_"+orignName;
		
		File f = new File(uploadPath,saveName);
		
		FileCopyUtils.copy(fileData, f);
		System.out.println("done");
		return saveName;
		
	}
	
	

}
