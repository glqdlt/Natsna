package org.natsna.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.natsna.common.CommonProps;
import org.natsna.domain.BoardVO;
import org.natsna.domain.Criteria;
import org.natsna.domain.PageMaker;
import org.natsna.domain.SearchCriteria;
import org.natsna.domain.UserVO;
import org.natsna.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoaardController {

	private static final Logger logger = LoggerFactory.getLogger(SearchBoaardController.class);

	@Inject
	private BoardService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info(cri.toString());

		// model.addAttribute("list", service.listCriteria(cri));
		model.addAttribute("list", service.listSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		// pageMaker.setTotalCount(service.listCountCriteria(cri));
		pageMaker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {

		model.addAttribute(service.read(bno));
	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, SearchCriteria cri, RedirectAttributes rttr, HttpSession session)
			throws Exception {

		BoardVO vo = service.read(bno);
		vo.getWriter();
		UserVO uvo = (UserVO) session.getAttribute(CommonProps.login);
		if (!(uvo.getUserid().equals(vo.getWriter()))) {
			logger.info("잘못된 접근");
			return "redirect:/error/auth";
		}

		service.remove(bno);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "success");

		return "redirect:/sboard/list";

	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public String modifyPagingGET(int bno, @ModelAttribute("cri") SearchCriteria cri, Model model, HttpSession session)
			throws Exception {

		BoardVO vo = service.read(bno);
		vo.getWriter();
		UserVO uvo = (UserVO) session.getAttribute(CommonProps.login);
		if (!(uvo.getUserid().equals(vo.getWriter()))) {
			logger.info("잘못된 접근");
			return "redirect:/error/auth";
		}

		model.addAttribute(vo);
		return "/sboard/modifyPage";

	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagingPOST(BoardVO board, SearchCriteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("mod post..");
		System.out.println("mod post..");

		service.modify(board);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "success");

		return "redirect:/sboard/list";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("register post...");

		service.regist(board);

		rttr.addFlashAttribute("msg", "success");
		System.out.println("post");

		return "redirect:/sboard/list";

	}
}
