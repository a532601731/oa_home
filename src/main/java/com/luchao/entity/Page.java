package com.luchao.entity;



public class Page {
	

    private Integer pageNow;      //当前页数

    private Integer pageSize;     //每页显示的数量

    private Integer allCount;     //总记录数

    private Integer allpages;      //总页数

   

    private Integer hasFirst;      //是否有首页

    private Integer hasPre;     //是否有前一页

    private Integer hasNext;     //是否有后一页

    private Integer hasLast;     //是否有尾页

    /**
     * 通过构造函数，传入总记录数和当前页,还有每页显示的数量
     * @param 当前页
     * @param 总记录数
     * @param 每页显示数量
     */
    public Page(Integer pageNow, Integer allCount,Integer pageSize) {
        super();
        this.pageNow = pageNow;
        this.allCount = allCount;
        this.pageSize=pageSize;
        this.hasFirst=(pageNow==1) ? 1:0;//1为false 0为True
        
        this.allpages=(int) Math.ceil(allCount*1.0/pageSize) ;
        this.hasLast=(pageNow==this.allpages) ? 1:0;
    }

	public Integer getPageNow() {
		return pageNow;
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getAllCount() {
		return allCount;
	}

	public void setAllCount(Integer allCount) {
		this.allCount = allCount;
	}

	public Integer getAllpages() {
		return allpages;
	}

	public void setAllpages(Integer allpages) {
		this.allpages = allpages;
	}

	
	public Integer getHasFirst() {
		return hasFirst;
	}

	public void setHasFirst(Integer hasFrist) {
		this.hasFirst = hasFrist;
	}

	public Integer getHasPre() {
		return hasPre;
	}

	public void setHasPre(Integer hasPre) {
		this.hasPre = hasPre;
	}

	public Integer getHasNext() {
		return hasNext;
	}

	public void setHasNext(Integer hasNext) {
		this.hasNext = hasNext;
	}

	public Integer getHasLast() {
		return hasLast;
	}

	public void setHasLast(Integer hasLast) {
		this.hasLast = hasLast;
	}

	
    
  
    
   
  
 


}