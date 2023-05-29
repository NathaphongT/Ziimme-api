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

    @Column(name = "zip_code")
    private String zip_code;

    @Column(name = "sub_districts_name_th")
    private String sub_districts_name_th;

    @Column(name = "sub_districts_name_eng")
    private String sub_districts_name_eng;

    @Column(name = "districts_code")
    private int districts_code;
}
