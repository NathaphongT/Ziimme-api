package com.ziimme.websource.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.json.LoginJson;
import com.ziimme.websource.json.res.ResponseJson;
import com.ziimme.websource.models.Users;
import com.ziimme.websource.repository.UsersRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.JsonUtil;
import com.ziimme.websource.utils.LogsUtil;
import com.ziimme.websource.utils.TokenUtil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;

@Component("authService")
public class AuthService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private TokenAuthenticationService jwt;
    @Autowired
    private LogsUtil logsUtil;

    public ResponseJson login(LoginJson _users) {
        Users users = this.usersRepository.findByUserNameAndPassword(_users.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", _users.getUsername()));
        JSONObject data = new JSONObject();
        data.put("user_id", users.getUserId());
        data.put("username", users.getUsername());
        data.put("displayname", users.getDisplayName());
        data.put("status", users.getUserRole());
        logsUtil.setLogs(users, "เข้าใช้งานระบบ", "เข้าใช้งานระบบ");
        JSONObject response = new JSONObject(users);
        response.put("token", jwt.getToken(data.toString()));
        ResponseJson responseJson = new ResponseJson();
        responseJson.setData(response.toMap());
        return responseJson;
    }

    public ResponseEntity<Object> authentication(HttpServletRequest request) {
        try {
            String tokenRequest = jwt.readToken(request);
            if (!tokenRequest.equals("")) {
                JSONObject infomationObj = new JSONObject(tokenRequest);
                JSONObject responseModels = new JSONObject();
                responseModels.put("userId", JsonUtil.getLong(infomationObj, "user_id"));
                responseModels.put("username", JsonUtil.getString(infomationObj, "username"));
                responseModels.put("creditNo", 0);
                responseModels.put("userRole", JsonUtil.getString(infomationObj, "status"));
                responseModels.put("displayName", JsonUtil.getString(infomationObj, "displayname"));
                responseModels.put("recordStatus", "A");
                return new ResponseEntity<>(responseModels.toString(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> logout(HttpServletRequest request) {
        String tokenRequest = this.jwt.readToken(request);
        String username = TokenUtil.getUsername(tokenRequest);
        String displayname = TokenUtil.getDisplayName(tokenRequest);
        Users userJson = new Users();
        JSONObject response = new JSONObject();
        response.put("status", true);
        response.put("username", username);
        userJson.setUsername(username);
        userJson.setDisplayName(displayname);
        userJson.setRecordStatus("A");
        logsUtil.setLogs(userJson, "ออกจากระบบ", "ออกจากระบบ");
        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }

}
