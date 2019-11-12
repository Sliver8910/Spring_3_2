package com.ruda.s3.util;

public class Pager {
	
	private String kind;	//검색 종류
	private String search; //검색어
	
	private Integer curPage; //현재 페이저번호
	private Integer perPage;
	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer totalBlock;
	public Integer getCurPage() {
		if(curPage ==null) {
			this.curPage=1;
		}
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getCurBlock() {
		
		return curBlock;
	}
	
	public Integer getPerPage() {
		return perPage;
	}
	public Integer getStartNum() {
		return startNum;
	}
	public Integer getLastNum() {
		return lastNum;
	}
	public Integer getTotalBlock() {
		return totalBlock;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(this.search == null)
			this.search="";
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	
	public Pager() {
		perPage = 10;
		// TODO Auto-generated constructor stub
	}
	
	public RowMaker makeRow() {
		
		int startRow = (this.getCurPage()-1)*perPage+1; //꺼낼때 null이라면 에러가 생김
		int lastRow = curPage*perPage;
		RowMaker rowMaker = new RowMaker();
		rowMaker.setStartRow(startRow);
		rowMaker.setLastRow(lastRow);
		rowMaker.setKind(getKind());
		rowMaker.setSearch(getSearch());
		return rowMaker;
	}
	
	public void makePager(int totalCount) {
		int totalPage = totalCount/perPage;
		if(totalCount%perPage !=0) {
			totalPage++;
		}
		
		int perBlock = 5;
		totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			totalBlock++;
		}
		
		curBlock = curPage/perBlock;
		if(curPage%perBlock !=0) {
			curBlock++;
		}
		
		startNum=(curBlock-1)*perBlock+1;
		lastNum=curBlock*perBlock;
		
		if(curBlock == getTotalBlock()) {
			lastNum = totalPage;
		}
		
	}

}
