package com.ziimme.websource.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "zim_txt_data_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "emp_fullname")
    private String empFullname;

    @Column(name = "emp_nickname")
    private String empNickname;

    @Column(name = "emp_birthday")
    private Date empBirthday;

    @Column(name = "emp_telephone")
    private String empTelephone;

    @Column(name = "emp_email")
    private String empEmail;

    @Column(name = "emp_status")
    private String empStatus;

    @Column(name = "emp_position")
    private int empPosition;

    @Column(name = "emp_branch")
    private int empBranch;

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
