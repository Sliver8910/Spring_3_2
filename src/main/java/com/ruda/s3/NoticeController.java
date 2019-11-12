package com.ruda.s3;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ruda.s3.model.board.NoticeVO;
import com.ruda.s3.service.board.NoticeService;
import com.ruda.s3.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	@Inject
	private NoticeService noticeService;
	
	//List : /notice/noticeList GET
	//view : /WEB-INF/view/notice/noticeList.jsp
	
	@RequestMapping(value = "noticeList")
	public void noticeList(Model model, Pager pager)throws Exception{
		List<NoticeVO> ar = noticeService.noticeList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
	}
	
	@RequestMapping(value = "noticeSelect")
	public void noitceSelect(Model model, int num)throws Exception{
		NoticeVO noticeVO = noticeService.noticeSelect(num);
		model.addAttribute("dto", noticeVO);
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public String noticeWrite()throws Exception{
		
		return "notice/noticeWrite";
		
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView noticeWrite(NoticeVO noticeVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.noticeInsert(noticeVO);
		String message = "Write Fail";
		if(result>0) {
			message = "Write Success";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/common_result");
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public void noticeUpdate(Model model, int num)throws Exception{
		NoticeVO noticeVO = noticeService.noticeSelect(num);
		model.addAttribute("dto", noticeVO);
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView noticeUpdate(NoticeVO noticeVO)throws Exception{
		int result = noticeService.noticeUpdate(noticeVO);
		ModelAndView mv = new ModelAndView();
		String message = "Update Fail";
		if(result>0) {
			message = "Update Success";	
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/common_result");
		return mv;
	}
	
	@RequestMapping(value = "noticeDelete")
	public ModelAndView noticeDelete(int num)throws Exception{
		int result = noticeService.noticeDelete(num);
		ModelAndView mv = new ModelAndView();
		String message = "Delete Fail";
		if(result>0) {
			message = "Delete Success";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
}
