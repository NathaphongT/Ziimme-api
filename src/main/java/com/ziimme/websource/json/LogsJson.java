package com.ziimme.websource.json;

import lombok.Data;

import java.util.Date;

@Data
public class LogsJson {
    private Long log_id;
    private String log_menu;
    private String log_title;
    private String log_activity;
    private String log_user_name;
    private String record_status;
    private Date created_time;
    private String created_by;
    private Date updated_time;
    private String updated_by;

    public Long getLog_id() {
        return log_id;
    }

    public void setLog_id(Long log_id) {
        this.log_id = log_id;
    }

    public String getLog_menu() {
        return log_menu;
    }

    public void setLog_menu(String log_menu) {
        this.log_menu = log_menu;
    }

    public String getLog_title() {
        return log_title;
    }

    public void setLog_title(String log_title) {
        this.log_title = log_title;
    }

    public String getLog_activity() {
        return log_activity;
    }

    public void setLog_activity(String log_activity) {
        this.log_activity = log_activity;
    }

    public String getLog_user_name() {
        return log_user_name;
    }

    public void setLog_user_name(String log_user_name) {
        this.log_user_name = log_user_name;
    }

    public String getRecord_status() {
        return record_status;
    }

    public void setRecord_status(String record_status) {
        this.record_status = record_status;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(Date updated_time) {
        this.updated_time = updated_time;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }
}
