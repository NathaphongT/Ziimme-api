package com.ziimme.websource.models;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "zim_mdm_data_districts")
public class Districts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "districts_id")
    private int districts_id;

    @Column(name = "districts_name_th")
    private String districts_name_th;

    @Column(name = "record_status")
    private String record_status;

    @Column(name = "created_time")
    private Date created_time;

    @Column(name = "updated_time")
    private Date updated_time;

    @Column(name = "province_id")
    private int province_id;
}
