package com.ruda.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.ruda.s3.TestAbstractCase;
import com.ruda.s3.model.board.QnaVO;
import com.ruda.s3.util.RowMaker;

public class QnaDAOTest extends TestAbstractCase{
	@Inject
	private QnaDAO qnaDAO;
	
	@Inject
	private SqlSession sqlsession;
	
	@Test
	public void sqlTest() {
		assertNotNull(sqlsession);
	}
	
	
	//@Test
	public void qnaInsertTest()throws Exception{
		for(int i=0;i<56;i++) {
			QnaVO qnaVO = new QnaVO();
			qnaVO.setTitle("qt"+i);
			qnaVO.setWriter("qw"+i);
			qnaVO.setContents("qc"+i);
			int result = qnaDAO.qnaInsert(qnaVO);
			assertEquals(1, result);
		}
		
		
	}

	@Test
	public void qnaListTest() throws Exception{
		RowMaker rowMaker = new RowMaker();
		List<QnaVO> ar = qnaDAO.qnaList(rowMaker);
		

		assertNotEquals(0, ar.size());
		
	}

}
