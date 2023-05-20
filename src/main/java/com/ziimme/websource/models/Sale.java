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
    private int sale_id;

    @Column(name = "sale_consultant")
    private int sale_consultant;

    @Column(name = "sale_product")
    private int sale_product;

    @Column(name = "sale_count")
    private String sale_count;

    @Column(name = "sale_pay_balance")
    private int sale_pay_balance;

    @Column(name = "sale_pay")
    private int sale_pay;

    @Column(name = "sale_overdue")
    private int sale_overdue;

    @Column(name = "sale_cus_id")
    private int sale_cus_id;

    @Column(name = "record_status")
    private String recordStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "created_by")
    private String createdBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_time")
    private Date updatedTime;

    @Column(name = "updated_by")
    private String updatedBy;
}
