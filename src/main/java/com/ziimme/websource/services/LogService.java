package com.ziimme.websource.services;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.json.LogsJson;
import com.ziimme.websource.json.res.ResponseJson;
import com.ziimme.websource.models.Logs;
import com.ziimme.websource.models.Users;
import com.ziimme.websource.repository.LogsRepo;
import com.ziimme.websource.repository.UsersRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;
import com.ziimme.websource.utils.TokenUtil;

import java.util.ArrayList;
import java.util.List;

@Component
public class LogService {
    @Autowired
    private LogsRepo logsRepo;
    @Autowired
    private UsersRepository userRepo;
    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    public ResponseEntity<Object> create(LogsJson logsJson) {
        Logs logs = new Logs();
        logs.setLog_title(logsJson.getLog_title());
        logs.setLog_activity(logsJson.getLog_activity());
        logs.setLog_menu(logsJson.getLog_menu());
        logs.setLog_user_name(logsJson.getLog_user_name());
        logs.setCreated_time(GlobalUtil.getCurrentDateTime());
        logs.setCreated_by(logsJson.getCreated_by());
        logs.setUpdated_time(GlobalUtil.getCurrentDateTime());
        logs.setUpdated_by(logsJson.getUpdated_by());
        logs.setRecord_status(logsJson.getRecord_status());
        return new ResponseEntity<>(this.logsRepo.save(logs), HttpStatus.OK);
    }

    public ResponseEntity<ResponseJson> findAll(HttpServletRequest request){
        ResponseJson responseJson = new ResponseJson();
        List<Logs> logsList = new ArrayList<Logs>();
        List<LogsJson> logsJsonList = new ArrayList<>();
        String tokenRequest = this.tokenAuthenticationService.readToken(request);
        System.out.println("tokenRequest: " + tokenRequest);
        String username = TokenUtil.getUsername(tokenRequest);
        Users users = this.userRepo.findUsername(username).orElseThrow(() -> new ResourceNotFoundException("Data", "username", username));
        if(users.getUserRole().equals("Admin")){
            this.logsRepo.findAll().forEach(logsList::add);
        }else{
            this.logsRepo.findByUsername(username).forEach(logsList::add);
        }
        if (logsList != null){
            for (Logs l : logsList) {
                LogsJson logs = new LogsJson();
                logs.setLog_id(l.getLog_id());
                logs.setLog_title(l.getLog_title());
                logs.setLog_activity(l.getLog_activity());
                logs.setLog_menu(l.getLog_menu());
                logs.setLog_user_name(l.getLog_user_name());
                logs.setCreated_time(l.getCreated_time());
                logs.setCreated_by(l.getCreated_by());
                if(l.getUpdated_time() != null){
                    logs.setUpdated_time(l.getUpdated_time());
                    logs.setUpdated_by(l.getUpdated_by());
                }
                logsJsonList.add(logs);
            }
        }
        responseJson.setData(logsJsonList);
        return new ResponseEntity<>(responseJson, HttpStatus.OK);
    }
}
