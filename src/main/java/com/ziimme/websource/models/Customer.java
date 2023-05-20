package com.ziimme.websource.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "zim_txt_data_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cus_id")
    private int cus_id;

    @Column(name = "cus_member")
    private String cus_member;

    @Column(name = "cus_prefix")
    private String cus_prefix;

    @Column(name = "cus_full_name")
    private String cus_full_name;

    @Column(name = "cus_nick_name")
    private String cus_nick_name;

    @Column(name = "cus_telephone")
    private String cus_telephone;

    @Column(name = "cus_birthday")
    private Date cus_birthday;

    @Column(name = "cus_gender")
    private String cus_gender;

    @Column(name = "cus_occupation")
    private String cus_occupation;

    @Column(name = "cus_status")
    private String cus_status;

    @Column(name = "cus_salary")
    private String cus_salary;

    @Column(name = "cus_payment")
    private String cus_payment;

    @Column(name = "cus_house_number")
    private String cus_house_number;

    @Column(name = "cus_moo")
    private String cus_moo;

    @Column(name = "cus_soi")
    private String cus_soi;

    @Column(name = "cus_road")
    private String cus_road;

    @Column(name = "provinceID")
    private int provinceID;

    @Column(name = "districtID")
    private int districtID;

    @Column(name = "sub_districtID")
    private int sub_districtID;

    @Column(name = "postcodeID")
    private int postcodeID;

    @Column(name = "congenital_disease")
    private String congenital_disease;

    @Column(name = "drug_allergy")
    private String drug_allergy;

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
