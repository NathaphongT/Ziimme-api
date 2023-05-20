package com.ziimme.websource.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziimme.websource.json.LogsJson;
import com.ziimme.websource.models.Users;
import com.ziimme.websource.services.LogService;

@Service
public class LogsUtil {

    @Autowired
    public LogService logService;
    
    public void setLogs(Users userJson, String type, String menu) {
        try {
            LogsJson logsJson = new LogsJson();
            logsJson.setLog_title("ผู้ใช้: " + userJson.getDisplayName());
            logsJson.setLog_activity(type);
            logsJson.setLog_menu(menu);
            logsJson.setLog_user_name(userJson.getUsername());
            logsJson.setCreated_by(userJson.getUsername());
            logsJson.setUpdated_by(userJson.getUsername());
            logsJson.setRecord_status(userJson.getRecordStatus());
            logService.create(logsJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
