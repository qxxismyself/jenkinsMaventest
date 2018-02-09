package com.age123.outdoor.model;

import java.util.Date;

import javax.persistence.Table;

import com.age123.outdoor.base.model.Entity;
/**
* @Description: 银行动态
* @author xiaoxiao.qian 
* @date 2016年6月14日 上午11:01:53
* @version V1.0
 */
@Table(name = "bank_dynamics")
public class BankDynamics  extends Entity {
	/**
	 * id
	 */
    private Integer id;

    /**
     * 地址
     */
    private String location;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 电话号码
     */
    private String phoneNumber;

    /**
     * 描述
     */
    private String describeBank;

    /**
     * 优秀
     */
    private String excellence;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getDescribeBank() {
        return describeBank;
    }

    public void setDescribeBank(String describeBank) {
        this.describeBank = describeBank == null ? null : describeBank.trim();
    }

    public String getExcellence() {
        return excellence;
    }

    public void setExcellence(String excellence) {
        this.excellence = excellence == null ? null : excellence.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public void setId(Object id) {
		// TODO Auto-generated method stub
		
	}
}