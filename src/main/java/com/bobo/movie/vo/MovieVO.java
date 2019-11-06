package com.bobo.movie.vo;

import com.bobo.movie.domain.Movie;

public class MovieVO extends Movie {
	
	private String startDate;
	private String endDate;
	private Double startPrice;
	private Double endPrice;
	private Integer startLongtime;
	private Integer endLongtime;
	
	
	private String orderField;//排序字段 :年代|时长|
	private String orderMethod;//排序方法 : asc |desc
	
	
	public String getOrderField() {
		return orderField;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public String getOrderMethod() {
		return orderMethod;
	}
	public void setOrderMethod(String orderMethod) {
		this.orderMethod = orderMethod;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Double getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(Double startPrice) {
		this.startPrice = startPrice;
	}
	public Double getEndPrice() {
		return endPrice;
	}
	public void setEndPrice(Double endPrice) {
		this.endPrice = endPrice;
	}
	public Integer getStartLongtime() {
		return startLongtime;
	}
	public void setStartLongtime(Integer startLongtime) {
		this.startLongtime = startLongtime;
	}
	public Integer getEndLongtime() {
		return endLongtime;
	}
	public void setEndLongtime(Integer endLongtime) {
		this.endLongtime = endLongtime;
	}
	

}
