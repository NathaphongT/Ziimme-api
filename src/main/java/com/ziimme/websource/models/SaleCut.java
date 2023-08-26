package com.ziimme.websource.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "zim_txt_data_sale_cut")
public class SaleCut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_cut_id")
    private int saleCutId;

    @Column(name = "sale_cut_count")
    private String saleCutCount;

    @Column(name = "sale_count")
    private int saleCount;

    @Column(name = "sale_cut_course")
    private String saleCutCourse;

    @Column(name = "sale_cut_vitamin")
    private String saleCutVitamin;

    @Column(name = "sale_cut_mark")
    private String saleCutMark;

    @Column(name = "sale_cut_therapist")
    private int saleCutTherapist;

    @Column(name = "sale_cut_doctor")
    private String saleCutDoctor;

    @Column(name = "sale_cut_detail")
    private String saleCutDetail;

    @Column(name = "sale_cut_date")
    private Date saleCutDate;

    @Column(name = "sale_product_id")
    private int saleProductId;

    @Column(name = "sale_id")
    private int saleId;

    @Column(name = "course_id")
    private int courseId;

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
