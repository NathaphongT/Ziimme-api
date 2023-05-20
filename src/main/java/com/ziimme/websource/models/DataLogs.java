package com.ziimme.websource.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "zim_mdm_data_logs")
public class DataLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private int logId;

    @Column(name = "log_menu")
    private String logMenu;

    @Column(name = "log_title")
    private String logTitle;

    @Column(name = "log_activity")
    private String logActivity;

    @Column(name = "log_user_name")
    private String logUserName;

    @Column(name = "record_status")
    private String recordStatus;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "created_by")
    private String createdBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_time")
    private Date updatedTime;

    @Column(name = "updated_by")
    private String updatedBy;

    public DataLogs() {

    }

    public DataLogs(String logMenu, String logTitle, String logActivity, String logUserName) {
        this.logMenu = logMenu;
        this.logTitle = logTitle;
        this.logActivity = logActivity;
        this.logUserName = logUserName;
    }

    @Override
    public String toString() {
        return String.format(
                "DataLogs[logId=%d, logMenu=%d, logTitle=%d, logActivity=%d, logUserName=%d]",
                logId, logMenu, logTitle, logActivity, logUserName
        );
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getLogMenu() {
        return logMenu;
    }

    public void setLogMenu(String logMenu) {
        this.logMenu = logMenu;
    }

    public String getLogTitle() {
        return logTitle;
    }

    public void setLogTitle(String logTitle) {
        this.logTitle = logTitle;
    }

    public String getLogActivity() {
        return logActivity;
    }

    public void setLogActivity(String logActivity) {
        this.logActivity = logActivity;
    }

    public String getLogUserName() {
        return logUserName;
    }

    public void setLogUserName(String logUserName) {
        this.logUserName = logUserName;
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
