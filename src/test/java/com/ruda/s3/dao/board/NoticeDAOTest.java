package com.ruda.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.ruda.s3.TestAbstractCase;
import com.ruda.s3.model.board.NoticeVO;

public class NoticeDAOTest extends TestAbstractCase {

	@Inject
	private NoticeDAO noticeDAO;
	
	//@Test
	public void checkDAO() throws Exception {
		assertNotNull(noticeDAO);
	}
	//@Test
	public void noticeInsertTest() throws Exception{
		//위임했으므로 new noticeDAO 하지 말것!!
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("test4");
		noticeVO.setWriter("writer4");
		noticeVO.setContents("contents4");
		int result = noticeDAO.noticeInsert(noticeVO);
		assertEquals(1, result);
	}
	
	//@Test 
	public void noticeDeleteTest() throws Exception{
		int num = 3;
		int result = noticeDAO.noticeDelete(num);
		assertEquals(1, result);
	}
	
	//@Test
	public void noticeSelectTest()throws Exception{
		NoticeVO noticeVO = noticeDAO.noticeSelect(2);
		assertNotNull(noticeVO);
	}
	/*
	 * @Test public void noticeListTest() throws Exception{ List<NoticeVO> ar =
	 * noticeDAO.noticeList(); assertEquals(3, ar.size()); }
	 */
	
	//@Test
	public void noticeUpdate() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("ut1");
		noticeVO.setWriter("uw1");
		noticeVO.setContents("uc1");
		noticeVO.setNum(5);
		int result = noticeDAO.noticeUpdate(noticeVO);
		
		assertEquals(1, result);
	}
		@Test
		public void noticeCountTest() throws Exception{
			int count = noticeDAO.noticeCount();
			assertEquals(71, count);
		}
	
}
