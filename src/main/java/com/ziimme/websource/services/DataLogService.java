package com.ziimme.websource.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.ziimme.websource.json.res.DataLogSpecification;
import com.ziimme.websource.models.DataLogs;
import com.ziimme.websource.repository.DataLogsRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component("dataLogService")
public class DataLogService {
    private DataLogsRepository dataLogsRepository;
    private DataLogSpecification dataLogSpecification;
    private TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    public void setDataLogService(DataLogsRepository dataLogsRepository,
            DataLogSpecification dataLogSpecification,
            TokenAuthenticationService tokenAuthenticationService) {
        this.dataLogsRepository = dataLogsRepository;
        this.dataLogSpecification = dataLogSpecification;
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    public List<DataLogs> getAll() {
        return this.dataLogsRepository.findAll();
    }

    public Page<DataLogs> search(String q, Pageable pageable) {
        return this.dataLogsRepository.findAll(dataLogSpecification.search(q), pageable);
    }

    public DataLogs create(DataLogs dataLogs, HttpServletRequest request) {
        String username = this.tokenAuthenticationService.getUsername(request);

        DataLogs _dataLogs = new DataLogs();
        _dataLogs.setLogMenu(dataLogs.getLogMenu());
        _dataLogs.setLogTitle(dataLogs.getLogTitle());
        _dataLogs.setLogActivity(dataLogs.getLogActivity());
        _dataLogs.setLogUserName(dataLogs.getLogUserName());
        _dataLogs.setCreatedBy(username);
        _dataLogs.setCreatedTime(GlobalUtil.getCurrentDateTime());

        return this.dataLogsRepository.save(_dataLogs);
    }
}
