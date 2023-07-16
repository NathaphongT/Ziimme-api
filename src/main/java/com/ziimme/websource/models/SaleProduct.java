package com.ziimme.websource.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "zim_txt_data_products")
public class SaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_product_id")
    private int saleProductId;

    @Column(name = "sale_id")
    private int saleId;

    @Column(name = "course_id")
    private int courseId;

    @Column(name = "cusId")
    private int cusId;

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

    public SaleProduct() {

    }

    public SaleProduct(int courseId, int saleId, int cusId) {
        this.courseId = courseId;
        this.saleId = saleId;
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return String.format(
                "SaleProduct[saleProductId=%d, courseId=%d, saleId=%d, cusId=%d]",
                saleProductId, courseId, saleId, cusId);
    }

    public int getsaleProductId() {
        return saleProductId;
    }

    public void setsaleProductId(int saleProductId) {
        this.saleProductId = saleProductId;
    }

    public int getsaleId() {
        return saleId;
    }

    public void setsaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getcourseId() {
        return courseId;
    }

    public void setcourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getcusId() {
        return cusId;
    }

    public void setcusId(int cusId) {
        this.cusId = cusId;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
