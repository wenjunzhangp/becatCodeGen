package com.xilin.model;
/**   
 * @Title: BaseModel.java 
 * @Package com.fendo.bean 
 * @Description: 实体基类
 * @author fendo
 * @date 2017年12月2日 下午5:32:40 
 * @version V1.0   
*/
public class BaseModel {
	

	private String createDate;
	private String createName;
	private String updateDate;
	private String updateName;
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateName() {
		return updateName;
	}
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	
}
