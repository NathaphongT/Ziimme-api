package com.ziimme.websource.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "zim_txt_data_sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private int saleId;

    @Column(name = "sale_number")
    private String saleNumber;

    @Column(name = "sale_balance")
    private String saleBalance;

    @Column(name = "sale_payment")
    private String salePayment;

    @Column(name = "sale_overdue")
    private String saleOverdue;

    @Column(name = "sale_date")
    private Date saleDate;

    @Column(name = "cus_id")
    private int cusId;

    @Column(name = "record_status")
    private String recordStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "Asia/Bangkok")
    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "created_by")
    private String createdBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "Asia/Bangkok")
    @Column(name = "updated_time")
    private Date updatedTime;

    @Column(name = "updated_by")
    private String updatedBy;

}
