package com.ziimme.websource.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "zim_mdm_data_position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private int positionId;

    @Column(name = "position_name_th")
    private String positionNameTh;

    @Column(name = "position_name_eng")
    private String positionNameEng;

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
