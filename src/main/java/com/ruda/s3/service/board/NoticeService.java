package com.ruda.s3.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ruda.s3.dao.board.NoticeDAO;
import com.ruda.s3.model.board.NoticeVO;

@Service
public class NoticeService {
	@Inject
	private NoticeDAO noticeDAO;
	
	public int noticeUpdate(NoticeVO noticeVO) throws Exception{
		return noticeDAO.noticeUpdate(noticeVO);
	}
	
	public List<NoticeVO> noticeList() throws Exception{
		return noticeDAO.noticeList();
	}
	
	public NoticeVO noticeSelect(int num)throws Exception{
		return noticeDAO.noticeSelect(num);
	}
	
	public int noticeDelete(int num)throws Exception{
		return noticeDAO.noticeDelete(num);
	}
	
	public int noticeInsert(NoticeVO noticeVO) throws Exception{
		return noticeDAO.noticeInsert(noticeVO);
	}
	
	
}
