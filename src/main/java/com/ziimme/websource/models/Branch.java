package com.ziimme.websource.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "zim_mdm_data_branch_service")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private int branchId;

    @Column(name = "branch_code")
    private String branchCode;

    @Column(name = "branch_name_th")
    private String branchNameTh;

    @Column(name = "branch_name_eng")
    private String branchNameEng;

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
