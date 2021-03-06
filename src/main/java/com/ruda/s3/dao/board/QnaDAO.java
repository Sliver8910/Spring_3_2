package com.ruda.s3.dao.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ruda.s3.model.board.QnaVO;
import com.ruda.s3.util.Pager;
import com.ruda.s3.util.RowMaker;

@Repository
public class QnaDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "qnaMapper.";
	
	public int qnaCount(Pager pager)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"qnaCount", pager);
	}
	
	public List<QnaVO> qnaList(RowMaker rowMaker)throws Exception{
		
		return sqlSession.selectList(NAMESPACE+"qnaList", rowMaker);
	}
	
	public int qnaWrite(QnaVO qnaVO) throws Exception {
		 int result = sqlSession.insert(NAMESPACE + "qnaWrite", qnaVO);
		 
		 return result;
	 }
	
	public QnaVO qnaSelect(int num) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"qnaSelect", num);
		
	}
	
	public int qnaDelete(int num) throws Exception{
		return sqlSession.delete(NAMESPACE+"qnaDelete", num);
	}
	
	public int qnaUpdate(QnaVO qnaVO)throws Exception{
		return sqlSession.update(NAMESPACE+"qnaUpdate", qnaVO);
		
	}
	
	public int qnaReply(QnaVO qnaVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"qnaReply", qnaVO);
	}
	public int qnaReplyUpdate(QnaVO qnaVO)throws Exception{
		return sqlSession.update(NAMESPACE+"qnaReplyUpdate", qnaVO);
	}
}
