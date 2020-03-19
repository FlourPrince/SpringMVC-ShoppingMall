package com.shop.Tools;

import java.util.List;

public class PageResult<T> {
	private Long count;
	private Integer startRowNo;
	private Integer endRowNo;
	private List<T> result;
	private Long pageTotalIndex;
	private int pageSize;
	private int pageIndex;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the pageTotalIndex
	 */
	public Long getPageTotalIndex() {
		return pageTotalIndex;
	}

	/**
	 * @param pageTotalIndex the pageTotalIndex to set
	 */
	public void setPageTotalIndex(Long pageTotalIndex) {
		this.pageTotalIndex = pageTotalIndex;
	}

	/**
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * @param count
	 *                  the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}

	/**
	 * @return the startRowNo
	 */
	public Integer getStartRowNo() {
		return startRowNo;
	}

	/**
	 * @param startRowNo
	 *                       the startRowNo to set
	 */
	public void setStartRowNo(Integer startRowNo) {
		this.startRowNo = startRowNo;
	}

	/**
	 * @return the endRowNo
	 */
	public Integer getEndRowNo() {
		return endRowNo;
	}

	/**
	 * @param endRowNo
	 *                     the endRowNo to set
	 */
	public void setEndRowNo(Integer endRowNo) {
		this.endRowNo = endRowNo;
	}

	/**
	 * @return the result
	 */
	public List<T> getResult() {
		return result;
	}

	/**
	 * @param result
	 *                   the result to set
	 */
	public void setResult(List<T> result) {
		this.result = result;
	}

}
