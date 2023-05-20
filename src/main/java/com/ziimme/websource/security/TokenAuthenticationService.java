package com.ziimme.websource.security;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ziimme.websource.models.Users;
import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.repository.UsersRepository;
import com.ziimme.websource.utils.JsonUtil;

import io.jsonwebtoken.*;

@Component
public class TokenAuthenticationService {
  @Value("${jwt.expirationtime}")
  private Long expireHours;
  @Value("${jwt.secret}")
  private String SECRET;
  @Value("${jwt.token_prefix}")
  private String TOKEN_PREFIX;
  @Value("${jwt.header_string}")
  private String HEADER_STRING;

  @Autowired
  private UsersRepository usersRepository;

  public String getToken(String username) {
    String JWT = Jwts.builder().setSubject(username).setExpiration(getExpirationTime())
        .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    return TOKEN_PREFIX + " " + JWT;
  }

  public String readToken(HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    String data = "";
    try {
      if (token != null) {
        data = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
            .getSubject();
      }
    } catch (Exception e) {
    }
    return data;
  }

  public String getUsername(HttpServletRequest request) {
    String username = "";
    String token = request.getHeader("Authorization");
    String tokenRequest = "";
    if (token != null) {
      tokenRequest = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
          .getSubject();
    }

    if (!tokenRequest.equals("")) {
      JSONObject requestJson = new JSONObject(tokenRequest);
      System.out.println("json" + requestJson);
      username = JsonUtil.getString(requestJson, "username");
    }
    return username;
  }

  public Users getUsers(HttpServletRequest request) {
    // String username = "";
    String token = request.getHeader("Authorization");
    String tokenRequest = "";
    if (token != null) {
      tokenRequest = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
          .getSubject();
    }

    Users users = new Users();
    if (!tokenRequest.equals("")) {
      JSONObject requestJson = new JSONObject(tokenRequest);
      String username = JsonUtil.getString(requestJson, "username");

      // users = usersRepository.findUsername(username);
      users = this.usersRepository.findUsername(username)
          .orElseThrow(() -> new ResourceNotFoundException("User", "", username));
    }

    return users;
  }

  private Date getExpirationTime() {
    Date now = new Date();
    Long expireInMillis = TimeUnit.HOURS.toMillis(expireHours);
    return new Date(expireInMillis + now.getTime());
  }
}
