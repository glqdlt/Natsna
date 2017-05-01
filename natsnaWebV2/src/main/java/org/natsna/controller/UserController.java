package org.natsna.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.natsna.common.CommonProps;
import org.natsna.domain.UserVO;
import org.natsna.dto.LoginDTO;
import org.natsna.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/user")
@Controller
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("dto") LoginDTO dto) throws Exception {

		return "/user/login";
	}

	@RequestMapping(value = "/loginAuth", method = RequestMethod.POST)
	public void loginAuth(@ModelAttribute("dto") LoginDTO dto, HttpSession session, Model model) throws Exception {

		UserVO vo = service.login(dto);

		if (vo == null) {
			logger.info("인증되지 않은 사용자.");
			return;
		}

		logger.info("userId: " + vo.getUserid());

		model.addAttribute(CommonProps.userVO, vo);

	}

	@RequestMapping(value = "/logout")
	public String logout() {

		return "/user/logout";
	}

	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public String userConfigGet() {

		return "/user/config";
	}

	@RequestMapping(value = "/config", method = RequestMethod.POST)
	public String userConfigPost() {

		return "/user/config";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGet() {

		return "/user/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(@ModelAttribute("vo") UserVO vo, RedirectAttributes rttr) throws Exception {

		service.signInMemeber(vo);
		rttr.addFlashAttribute("msg", CommonProps.signIn);

		return "redirect:/user/login";

	}
	
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String registerSuccess() {
		
		return "redirect:/";
	}
	

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profileGet() {

		return "/user/profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String profilePost() {

		return "/user/profile";
	}
}
