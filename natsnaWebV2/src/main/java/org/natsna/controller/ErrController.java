package org.natsna.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/error")
@Controller
public class ErrController {

	private static final Logger logger = LoggerFactory.getLogger(ErrController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "redirect:/dashboard";
	}

	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public String AuthErr() {
		return "/error/auth";
	}
	@RequestMapping(value = "/uploadErr", method = RequestMethod.GET)
	public String UploadErr() {
		return "/error/uploadErr";
	}

}
