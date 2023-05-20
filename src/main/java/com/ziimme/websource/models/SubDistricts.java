package com.ziimme.websource.models;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "zim_mdm_data_sub_districts")
public class SubDistricts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_districts_id")
    private int sub_districts_id;

    @Column(name = "sub_districts_name_th")
    private String sub_districts_name_th;

    @Column(name = "record_status")
    private String record_status;

    @Column(name = "created_time")
    private Date created_time;

    @Column(name = "updated_time")
    private Date updated_time;

    @Column(name = "districts_id")
    private int districts_id;
}
