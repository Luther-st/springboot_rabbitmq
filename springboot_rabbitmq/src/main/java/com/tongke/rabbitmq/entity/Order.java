package com.tongke.rabbitmq.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;

@Entity
@Table(name = "t_order", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class Order implements java.io.Serializable {

    /**id*/
    private String id;
    /**名称*/
    private String name;
    /**存储消息发送的唯一标识*/
    private String messageId;

    public Order(){

    }
    public Order(String id,String name,String messageId){
        this.id = id;
        this.name = name;
        this.messageId = messageId;
    }

    @Id
    @Column(name ="ID",nullable=false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name ="NAME",nullable=false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name ="MESSAGE_ID",nullable=false)
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
