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
    private int emp_id;

    @Column(name = "emp_fullname")
    private String emp_fullname;

    @Column(name = "emp_nickname")
    private String emp_nickname;

    @Column(name = "emp_birthday")
    private Date emp_birthday;

    @Column(name = "emp_telephone")
    private String emp_telephone;

    @Column(name = "emp_email")
    private String emp_email;

    @Column(name = "emp_status")
    private String emp_status;

    @Column(name = "emp_position")
    private String emp_position;

    @Column(name = "emp_branch")
    private String emp_branch;

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
