package com.ziimme.websource.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.models.Position;
import com.ziimme.websource.repository.PositionRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;

@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    public List<Position> getAll() {
        return this.positionRepository.findAll();
    }

    public Position create(Position positions, HttpServletRequest request) {
        String username = this.tokenAuthenticationService.getUsername(request);

        Position _positions = new Position();
        _positions.setPosition_name_th(positions.getPosition_name_th());
        _positions.setPosition_name_eng(positions.getPosition_name_eng());
        _positions.setRecordStatus(GlobalUtil.getActiveStatus());
        _positions.setCreatedBy(username);
        _positions.setCreatedTime(GlobalUtil.getCurrentDateTime());
        return this.positionRepository.save(_positions);
    }

    public Position update(int position_id, Position position, HttpServletRequest request) {
        Position _position = this.positionRepository.findById(position_id)
                .orElseThrow(() -> new ResourceNotFoundException("Position", "id", position_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _position.setPosition_name_th(position.getPosition_name_th());
        _position.setPosition_name_eng(position.getPosition_name_eng());
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
