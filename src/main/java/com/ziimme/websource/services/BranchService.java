package com.ziimme.websource.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.models.Branch;
import com.ziimme.websource.models.BranchSpecification;
import com.ziimme.websource.repository.BranchRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;
import com.ziimme.websource.utils.LogsUtil;

@Service
public class BranchService {

    private BranchRepository branchRepository;
    private BranchSpecification branchSpecification;
    private TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    private LogsUtil logsUtil;

    @Autowired
    public void setFarmCategoryService(BranchRepository branchRepository,
            BranchSpecification branchSpecification,
            TokenAuthenticationService tokenAuthenticationService) {
        this.branchRepository = branchRepository;
        this.branchSpecification = branchSpecification;
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    public List<Branch> getAll() {
        return this.branchRepository.findAll();
    }

    public Page<Branch> search(String q, Pageable pageable) {
        return this.branchRepository.findAll(branchSpecification.search(q), pageable);
    }

    public Branch getById(int branchId) {
        Branch branch = this.branchRepository.findById(branchId)
                .orElseThrow(() -> new ResourceNotFoundException("Branch", "id", branchId));

        return branch;
    }

    public Branch create(Branch branch, HttpServletRequest request) {
        String username = this.tokenAuthenticationService.getUsername(request);

        Branch _branch = new Branch();
        _branch.setBranchCode(branch.getBranchCode());
        _branch.setBranchNameTh(branch.getBranchNameTh());
        _branch.setBranchNameEng(branch.getBranchNameEng());
        _branch.setRecordStatus(GlobalUtil.getActiveStatus());
        _branch.setCreatedBy(username);
        _branch.setCreatedTime(GlobalUtil.getCurrentDateTime());

        return this.branchRepository.save(_branch);
    }

    public Branch update(int branch_id, Branch branch, HttpServletRequest request) {
        Branch _branch = this.branchRepository.findById(branch_id)
                .orElseThrow(() -> new ResourceNotFoundException("Branch", "id", branch_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _branch.setBranchCode(branch.getBranchCode());
        _branch.setBranchNameTh(branch.getBranchNameTh());
        _branch.setBranchNameEng(branch.getBranchNameEng());
        _branch.setUpdatedBy(username);
        _branch.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        _branch = this.branchRepository.save(_branch);

        return _branch;
    }

    public void delete(int branch_id, HttpServletRequest request) {
        Branch _branch = this.branchRepository.findById(branch_id)
                .orElseThrow(() -> new ResourceNotFoundException("Branch", "id", branch_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _branch.setRecordStatus(GlobalUtil.getInActiveStatus());
        _branch.setUpdatedBy(username);
        _branch.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        this.branchRepository.save(_branch);
    }

}
