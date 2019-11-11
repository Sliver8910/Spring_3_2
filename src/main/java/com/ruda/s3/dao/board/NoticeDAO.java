package com.ruda.s3.dao.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ruda.s3.model.board.NoticeVO;

@Repository
public class NoticeDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "noticeMapper."; 
	
	 public int noticeInsert(NoticeVO noticeVO) throws Exception {
		 int result = sqlSession.insert(NAMESPACE + "noticeInsert", noticeVO);
		 
		 return result;
	 }
	 
	 public int noticeDelete(int num)throws Exception{
		int result= sqlSession.delete(NAMESPACE+ "noticeDelete", num);
		 
		return result;
	 }
	 
	 public NoticeVO noticeSelect(int num) throws Exception{
		 Map<String, Integer> map = new HashMap<String, Integer>();
		 map.put("num", num);
		return sqlSession.selectOne(NAMESPACE+ "noticeSelect", map);
		
	 }
	 
	 public int noticeCount()throws Exception{
		 return sqlSession.selectOne(NAMESPACE+"noticeCount");
	 }
	 
	 public List<NoticeVO> noticeList(Map<String, Integer> map) throws Exception{
		return sqlSession.selectList(NAMESPACE+"noticeList", map);
		 
	 }
	 
	 public int noticeUpdate(NoticeVO noticeVO) throws Exception{
		 int result = sqlSession.update(NAMESPACE + "noticeUpdate", noticeVO);
		 return result;
	 }

}
