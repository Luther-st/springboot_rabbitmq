package com.tongke.rabbitmq.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "broker_message_log", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class BrokerMessageLog implements java.io.Serializable {

    private String messageId;
    private String message;
    private int tryCount = 0;
    private String status;
    private Date nextRetry;
    private Date createTime;
    private Date updateTime;

    @Id
    @Column(name ="MESSAGE_ID",nullable=false)
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Column(name ="MESSAGE",nullable=false)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Column(name ="TRY_COUNT",nullable=false)
    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    @Column(name ="STATUS",nullable=false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name ="NEXT_RETRY",nullable=false)
    public Date getNextRetry() {
        return nextRetry;
    }

    public void setNextRetry(Date nextRetry) {
        this.nextRetry = nextRetry;
    }

    @Column(name ="CREATE_TIME",nullable=false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name ="UPDATE_TIME",nullable=false)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BrokerMessageLog(){

    }
    public BrokerMessageLog(String messageId, String message, int tryCount,String status,Date nextRetry,Date updateTime,Date createTime){
        this.messageId = messageId;
        this.message = message;
        this.tryCount = tryCount;
        this.status = status;
        this.nextRetry = nextRetry;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

}
