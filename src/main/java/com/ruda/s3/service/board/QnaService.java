package com.ruda.s3.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ruda.s3.dao.board.QnaDAO;
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
	
	public int qnaWrite(QnaVO qnaVO) throws Exception{
		return qnaDAO.qnaWrite(qnaVO);
	}
	
	public QnaVO qnaSelect(int num)throws Exception{
		return qnaDAO.qnaSelect(num);
	}
	
	public int qnaDelete(int num)throws Exception{
		return qnaDAO.qnaDelete(num);
	}
	
	public int qnaUpdate(QnaVO qnaVO)throws Exception{
		return qnaDAO.qnaUpdate(qnaVO);
	}
	
	public int qnaReply(QnaVO qnaVO)throws Exception{
	//부모의 정보(전송받은 부모의 num으로 부모의 ref, step, depth를 qnavo를 새롭게 선언해서 가져옴)
		QnaVO parent = qnaDAO.qnaSelect(qnaVO.getNum());
		int result = qnaDAO.qnaReplyUpdate(parent);
	//업데이트
		qnaVO.setRef(parent.getRef());
		qnaVO.setStep(parent.getStep()+1);
		qnaVO.setDepth(parent.getDepth()+1);
	//인서트
		result = qnaDAO.qnaReply(qnaVO);
		return result;
		}
}
