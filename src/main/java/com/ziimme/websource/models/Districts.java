package com.ziimme.websource.models;

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

    @Column(name = "districts_name_eng")
    private String districts_name_eng;

    @Column(name = "province_code")
    private int province_code;
}
