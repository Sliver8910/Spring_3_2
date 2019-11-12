package com.ruda.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ruda.s3.model.board.NoticeVO;
import com.ruda.s3.model.board.QnaVO;
import com.ruda.s3.service.board.QnaService;
import com.ruda.s3.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value = "qnaList")
	public void qnaList(Model model, Pager pager)throws Exception{
		List<QnaVO> ar = qnaService.qnaList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView qnaWrite(QnaVO qnaVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.qnaInsert(qnaVO);
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

}
