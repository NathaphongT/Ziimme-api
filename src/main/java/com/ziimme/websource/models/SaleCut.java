package com.ziimme.websource.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "zim_txt_data_sale_cut")
public class SaleCut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_cut_id")
    private int sale_cut_id;

    @Column(name = "sale_cut_count")
    private int sale_cut_count;

    @Column(name = "sale_cut_vitamin")
    private String sale_cut_vitamin;

    @Column(name = "sale_cut_mark")
    private String sale_cut_mark;

    @Column(name = "sale_cut_therapist")
    private int sale_cut_therapist;

    @Column(name = "sale_cut_doctor")
    private String sale_cut_doctor;

    @Column(name = "sale_cut_detail")
    private String sale_cut_detail;

    @Column(name = "sale_cut_pay_balance")
    private int sale_cut_pay_balance;

    @Column(name = "sale_cut_pay")
    private int sale_cut_pay;

    @Column(name = "sale_cut_overdue")
    private int sale_cut_overdue;

    @Column(name = "sale_id")
    private int sale_id;

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
