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
	@Test
	public void test2() throws Exception {
	int t	=qnaDAO.qnaCount();
	
	assertNotNull(t);
	}
	

	@Test
	public void qnaListTest() throws Exception{
		RowMaker rowMaker = new RowMaker();
		List<QnaVO> ar = qnaDAO.qnaList(rowMaker);
		

		assertNotEquals(0, ar.size());
		
	}

}
