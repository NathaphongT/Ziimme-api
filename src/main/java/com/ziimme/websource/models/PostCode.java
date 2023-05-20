package com.ziimme.websource.models;

import javax.persistence.*;

import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "zim_mdm_data_postcode")
public class PostCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postcode_id")
    private int postcode_id;

    @Column(name = "postcode_code")
    private String postcode_code;

    @Column(name = "record_status")
    private String record_status;

    @Column(name = "created_time")
    private Date created_time;

    @Column(name = "updated_time")
    private Date updated_time;

    @Column(name = "sub_districts_id")
    private int sub_districts_id;
}