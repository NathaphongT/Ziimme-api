package com.ziimme.websource.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.models.Position;
import com.ziimme.websource.models.PositionSpecification;
import com.ziimme.websource.models.Users;
import com.ziimme.websource.models.UsersSpecification;
import com.ziimme.websource.repository.PositionRepository;
import com.ziimme.websource.repository.UsersRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;
// import com.ziimme.websource.utils.LogsUtil;

@Service
public class UserService {

    private UsersRepository usersRepository;
    private UsersSpecification usersSpecification;
    private TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    public void setWarehouseService(
            UsersRepository usersRepository,
            UsersSpecification usersSpecification,
            TokenAuthenticationService tokenAuthenticationService) {
        this.usersRepository = usersRepository;
        this.usersSpecification = usersSpecification;
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    public List<Users> getAll() {
        return this.usersRepository.findAll();
    }

    public Page<Users> search(String q, Pageable pageable) {
        return this.usersRepository.findAll(usersSpecification.searchByName(q), pageable);
    }

    public Users getById(int userId) {
        Users users = this.usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        return users;
    }

    public Users create(Users users, HttpServletRequest request) {
        String username = this.tokenAuthenticationService.getUsername(request);

        Users _users = new Users();
        _users.setUsername(users.getUsername());
        _users.setDisplayName(users.getDisplayName());
        _users.setPassword(users.getPassword());
        _users.setUserRole(users.getUserRole());
        _users.setBranchName(users.getBranchName());
        _users.setRecordStatus(GlobalUtil.getActiveStatus());
        _users.setCreatedBy(username);
        _users.setCreatedTime(GlobalUtil.getCurrentDateTime());
        return this.usersRepository.save(_users);
    }

    public Users update(int userId, Users users, HttpServletRequest request) {
        Users _users = this.usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        String username = this.tokenAuthenticationService.getUsername(request);

        _users.setDisplayName(users.getDisplayName());
        _users.setUserRole(users.getUserRole());
        _users.setBranchName(users.getBranchName());
        _users.setUpdatedBy(username);
        _users.setUpdatedTime(GlobalUtil.getCurrentDateTime());
        _users = this.usersRepository.save(_users);

        return _users;
    }

    public void delete(int userId, HttpServletRequest request) {
        Users users = this.usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        String username = this.tokenAuthenticationService.getUsername(request);

        users.setRecordStatus(GlobalUtil.getInActiveStatus());
        users.setUpdatedBy(username);
        users.setUpdatedTime(GlobalUtil.getCurrentDateTime());
        this.usersRepository.save(users);
    }

}