package com.ruda.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ruda.s3.model.board.QnaVO;
import com.ruda.s3.service.board.QnaService;
import com.ruda.s3.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.GET)
	public void qnaReply(int num, Model model)throws Exception{
		//부모의 num을 qnaReply페이지로 전송
		model.addAttribute("num", num);
	}
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public  ModelAndView qnaReply(QnaVO qnaVO)throws Exception{
		int result = qnaService.qnaReply(qnaVO);
		ModelAndView mv = new ModelAndView();
		String message = "Reply Fail";
		if(result>0) {
			message = "Reply Success";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/common_result");
		return mv;
	}
	
	@RequestMapping(value = "qnaList")
	public void qnaList(Model model, Pager pager)throws Exception{
		List<QnaVO> ar = qnaService.qnaList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView qnaWrite(QnaVO qnaVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.qnaWrite(qnaVO);
		String message = "Write Fail";
		if(result>0) {
			message = "Write Success";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/common_result");
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public String qnaeWrite()throws Exception{
		
		return "qna/qnaWrite";
		
	}
	@RequestMapping(value = "qnaSelect")
	public void qnaSelect(Model model, int num)throws Exception{
		QnaVO qnaVO = qnaService.qnaSelect(num);
		model.addAttribute("dto", qnaVO);
		
	}
	
	@RequestMapping(value = "qnaDelete")
	public ModelAndView qnaDelete(int num)throws Exception{
		int result = qnaService.qnaDelete(num);
		ModelAndView mv = new ModelAndView();
		String message = "Delete Fail";
		if(result>0) {
			message = "Delete Success";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.GET)
	public void qnaUpdate(Model model, int num)throws Exception{
		QnaVO qnaVO = qnaService.qnaSelect(num);
		model.addAttribute("dto", qnaVO);
	}
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public ModelAndView qnaUpdate(QnaVO qnaVO)throws Exception{
		int result = qnaService.qnaUpdate(qnaVO);
		ModelAndView mv = new ModelAndView();
		String message = "Update Fail";
		if(result>0) {
			message = "Update Success";	
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/common_result");
		return mv;
	}

}
