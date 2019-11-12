package com.ruda.s3.util;

public class Pager {

	private Integer curPage;
	private Integer perPage;
	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer totalBlock;
	
	private String kind;
	private String search;

	public Integer getTotalBlock() {
		return totalBlock;
	}

	public Integer getCurBlock() {
		return curBlock;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public Pager() {
		perPage = 10;
	}

	public Integer getCurPage() {
		if(curPage ==null) {
			this.curPage=1;
		}
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	
	

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(search == null) {
			this.search="";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public void makePager(int totalCount) {
		//1. 전체 글의 갯수
		
		//2. 전체 페이지긔 갯수
		int totalPage = totalCount/perPage;
		if(totalCount%perPage !=0) {
			totalPage++;
		}

		//3. 전체 블럭의 갯수
		int perBlock = 5;
		totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			totalBlock++;
		}

		//4. curPage를 이용해서 현재 블럭(curBlock)구하기
		curBlock = curPage/perBlock;
		if(curPage%perBlock !=0) {
			curBlock++;
		}
		
		//5. curBlock으로 StartNum과 lastNum 구하기
		startNum= (curBlock-1)*perBlock+1;
		lastNum=curBlock*perBlock;
		
		if(curBlock == getTotalBlock()) {
			lastNum = totalPage;
		}


	}

	public RowMaker makeRow() {
		//rownum계산
		int startRow = (this.getCurPage()-1)*perPage+1; //꺼낼때 null이라면 에러가 생김
		int lastRow = curPage*perPage;
		RowMaker rowMaker = new RowMaker();
		rowMaker.setStartRow(startRow);
		rowMaker.setLastRow(lastRow);
		rowMaker.setKind(getKind());
		rowMaker.setSearch(getSearch());
		return rowMaker;
	}

}
