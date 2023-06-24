package com.ziimme.websource.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.models.Branch;
import com.ziimme.websource.models.Position;
import com.ziimme.websource.models.PositionSpecification;
import com.ziimme.websource.repository.EmployeeRepository;
import com.ziimme.websource.repository.PositionRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;

@Service
public class PositionService {

    private PositionRepository positionRepository;
    private PositionSpecification positionSpecification;
    private TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    public void setWarehouseService(
            PositionRepository positionRepository,
            PositionSpecification positionSpecification,
            TokenAuthenticationService tokenAuthenticationService) {
        this.positionRepository = positionRepository;
        this.positionSpecification = positionSpecification;
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    public List<Position> getAll() {
        return this.positionRepository.findAll();
    }

    public Page<Position> search(String q, Pageable pageable) {
        return this.positionRepository.findAll(positionSpecification.searchByName(q), pageable);
    }

    public Position getById(int positionId) {
        Position position = this.positionRepository.findById(positionId)
                .orElseThrow(() -> new ResourceNotFoundException("Position", "id", positionId));

        return position;
    }

    public Position create(Position position, HttpServletRequest request) {
        String username = this.tokenAuthenticationService.getUsername(request);

        Position _position = new Position();
        _position.setPositionNameTh(position.getPositionNameTh());
        _position.setPositionNameEng(position.getPositionNameEng());
        _position.setRecordStatus(GlobalUtil.getActiveStatus());
        _position.setCreatedBy(username);
        _position.setCreatedTime(GlobalUtil.getCurrentDateTime());
        return this.positionRepository.save(_position);
    }

    public Position update(int position_id, Position position, HttpServletRequest request) {
        Position _position = this.positionRepository.findById(position_id)
                .orElseThrow(() -> new ResourceNotFoundException("Position", "id", position_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _position.setPositionNameTh(position.getPositionNameTh());
        _position.setPositionNameEng(position.getPositionNameEng());
        _position.setUpdatedBy(username);
        _position.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        _position = this.positionRepository.save(_position);

        return _position;
    }

    public void delete(int position_id, HttpServletRequest request) {
        Position _position = this.positionRepository.findById(position_id)
                .orElseThrow(() -> new ResourceNotFoundException("position", "id", position_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _position.setRecordStatus(GlobalUtil.getInActiveStatus());
        _position.setUpdatedBy(username);
        _position.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        this.positionRepository.save(_position);
    }
}
