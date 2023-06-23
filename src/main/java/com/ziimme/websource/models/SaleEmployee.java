package com.ziimme.websource.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "zim_txt_data_consultant")
public class SaleEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consultant_id")
    private int consultant_id;

    @Column(name = "sale_id")
    private int sale_id;

    @Column(name = "emp_id")
    private int emp_id;

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

    public SaleEmployee() {

    }

    public SaleEmployee(int emp_id, int sale_id) {
        this.emp_id = emp_id;
        this.sale_id = sale_id;
    }

    @Override
    public String toString() {
        return String.format(
                "SaleEmployee[consultant_id=%d, emp_id=%d, sale_id=%d]",
                consultant_id, emp_id, sale_id);
    }

    public int getconsultant_id() {
        return consultant_id;
    }

    public void setconsultant_id(int consultant_id) {
        this.consultant_id = consultant_id;
    }

    public int getsale_id() {
        return sale_id;
    }

    public void setsale_id(int sale_id) {
        this.sale_id = sale_id;
    }

    public int getemp_id() {
        return emp_id;
    }

    public void setemp_id(int emp_id) {
        this.emp_id = emp_id;
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
