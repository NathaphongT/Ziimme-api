package com.ziimme.websource.models;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "zim_mdm_data_province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "province_id")
    private int province_id;

    @Column(name = "province_name_th")
    private String province_name_th;

    @Column(name = "province_name_eng")
    private String province_name_eng;
}
