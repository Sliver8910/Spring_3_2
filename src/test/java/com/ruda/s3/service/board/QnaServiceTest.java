package com.ruda.s3.service.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.ruda.s3.TestAbstractCase;
import com.ruda.s3.model.board.QnaVO;
import com.ruda.s3.util.Pager;

public class QnaServiceTest extends TestAbstractCase {
	@Inject
	private QnaService qnaservice;
	
	@Test
	public void qnaListTest() throws Exception {
		Pager pager = new Pager();
		List<QnaVO> ar = qnaservice.qnaList(pager);
		assertNotNull(ar.size());
	}

}
