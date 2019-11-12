package com.ruda.s3.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ruda.s3.dao.board.QnaDAO;
import com.ruda.s3.model.board.NoticeVO;
import com.ruda.s3.model.board.QnaVO;
import com.ruda.s3.util.Pager;
import com.ruda.s3.util.RowMaker;

@Service
public class QnaService {
	@Inject
	private QnaDAO qnaDAO;
	
	public List<QnaVO> qnaList(Pager pager)throws Exception{
		RowMaker rowMaker = pager.makeRow();
		pager.makePager(qnaDAO.qnaCount(pager));
		return qnaDAO.qnaList(rowMaker);
	}
	
	public int qnaInsert(QnaVO qnaVO) throws Exception{
		return qnaDAO.qnaInsert(qnaVO);
	}

}