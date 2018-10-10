package com.luchao.entity;

import java.io.Serializable;

public class Page implements Serializable{
    private static final long serialVersionUID=1L;

    private int pageNow=1;      //当前页数

    private int pageSize=8;     //每页显示的数量

    private int Allcounts;     //总记录数

    private int Allpages;      //总页数

    private int startPos;        //开始位置，从0开始

    private boolean hasFrist;      //是否有首页

    private boolean hasPre;     //是否有前一页

    private boolean hasNext;     //是否有后一页

    private boolean hasLast;     //是否有尾页

    public int getAllcounts() {
		return Allcounts;
	}
	@Override
	public String toString() {
		return "Page [pageNow=" + pageNow + ", pageSize=" + pageSize + ", Allcounts=" + Allcounts + ", Allpages="
				+ Allpages + ", startPos=" + startPos + ", hasFrist=" + hasFrist + ", hasPre=" + hasPre + ", hasNext="
				+ hasNext + ", hasLast=" + hasLast + "]";
	}
	public void setAllcounts(int allcounts) {
		Allcounts = allcounts;
	}
	public int getAllpages() {
		return Allpages;
	}
	public void setAllpages(int allpages) {
		Allpages = allpages;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
     * 通过构造函数，传入总记录数和当前页
     * @param pageNow
     * @param totalCount
     */
    public Page(int pageNow, int totalCount) {
        super();
        this.pageNow = pageNow;
        this.Allcounts = totalCount;
    }
    //获取总页数
    public int getTotalPageCount() {
        Allpages=getTotalCount()/getPageSize();
        return (Allcounts/pageSize==0) ? Allpages:Allpages+1;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.Allpages = totalPageCount;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return Allcounts;
    }

    public void setTotalCount(int totalCount) {
        this.Allcounts = totalCount;
    }
    //取得选择记录的初始位置
    public int getStartPos() {
        return (pageNow-1)*pageSize;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }
    //判断是否有第一页
    public boolean isHasFrist() {
        return (pageNow==1) ? false:true;
    }

    public void setHasFrist(boolean hasFrist) {
        this.hasFrist = hasFrist;
    }
    //如果有首页就有前一页
    public boolean isHasPre() {
        return isHasFrist() ? true:false;
    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }
    //如果有尾页就有下一页
    public boolean isHasNext() {
        return isHasNext() ? true:false;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
    //判断是否有尾页
    public boolean isHasLast() {
        return (pageNow==getTotalCount()) ? false:true;
    }

    public void setHasLast(boolean hasLast) {
        this.hasLast = hasLast;
    }


}