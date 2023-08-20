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
    @Column(name = "cusId")
    private int cusId;

    @Column(name = "cus_member")
    private String cusMember;

    @Column(name = "cus_branch")
    private int cusBranch;

    @Column(name = "cus_prefix")
    private String cusPrefix;

    @Column(name = "cus_full_name")
    private String cusFullName;

    @Column(name = "cus_nick_name")
    private String cusNickName;

    @Column(name = "cus_telephone")
    private String cusTelephone;

    @Column(name = "cus_birthday")
    private Date cusBirthday;

    @Column(name = "cus_gender")
    private String cusGender;

    @Column(name = "cus_occupation")
    private String cusOccupation;

    @Column(name = "cus_status")
    private String cusStatus;

    @Column(name = "cus_salary")
    private String cusSalary;

    @Column(name = "cus_payment")
    private String cusPayment;

    @Column(name = "cus_house_number")
    private String cusHouseNumber;

    @Column(name = "cus_moo")
    private String cusMoo;

    @Column(name = "cus_soi")
    private String cusSoi;

    @Column(name = "cus_road")
    private String cusRoad;

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
