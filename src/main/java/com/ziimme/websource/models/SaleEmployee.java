package com.ziimme.websource.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "zim_txt_data_consultant")
public class SaleEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consultant_id")
    private int consultantId;

    @Column(name = "sale_id")
    private int saleId;

    @Column(name = "emp_id")
    private int empId;

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

    public SaleEmployee() {

    }

    public SaleEmployee(int empId, int saleId, int cusId) {
        this.empId = empId;
        this.saleId = saleId;
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return String.format(
                "SaleEmployee[consultantId=%d, empId=%d, saleId=%d, cusId=%d]",
                consultantId, empId, saleId, cusId);
    }

    public int getconsultantId() {
        return consultantId;
    }

    public void setconsultantId(int consultantId) {
        this.consultantId = consultantId;
    }

    public int getsaleId() {
        return saleId;
    }

    public void setsaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getempId() {
        return empId;
    }

    public void setempId(int empId) {
        this.empId = empId;
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
