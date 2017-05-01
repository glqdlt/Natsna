package org.natsna.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/malware")
@Controller
public class TasksController {

	private static final Logger logger = LoggerFactory.getLogger(TasksController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "redirect:./analysis";
	}

	@RequestMapping(value = "/analysis", method = RequestMethod.GET)
	public String searchGet() throws Exception {
		
		

		return "/malware/analysis";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/analysis", method = RequestMethod.POST, produces = "text/plain; charset=UTF-8")
	public ResponseEntity<String> searchPost(MultipartFile file) throws Exception {

		logger.info("original name: "+file.getOriginalFilename());
		logger.info("original size: "+file.getSize());
		logger.info("original con: "+file.getContentType());
		
		return new ResponseEntity<String>(file.getOriginalFilename(), HttpStatus.OK);
	
	}


	@RequestMapping(value = "/archive", method = RequestMethod.GET)
	public String viewGet() {
		return "/malware/archive";
	}

}
