package com.ziimme.websource.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.models.Branch;
import com.ziimme.websource.repository.BranchRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    public List<Branch> getAll() {
        return this.branchRepository.findAll();
    }

    public Branch create(Branch branchs, HttpServletRequest request) {
        String username = this.tokenAuthenticationService.getUsername(request);

        Branch _branchs = new Branch();
        _branchs.setBranch_name(branchs.getBranch_name());
        _branchs.setBranch_code(branchs.getBranch_code());
        _branchs.setRecordStatus(GlobalUtil.getActiveStatus());
        _branchs.setCreatedBy(username);
        _branchs.setCreatedTime(GlobalUtil.getCurrentDateTime());
        return this.branchRepository.save(_branchs);
    }

    public Branch update(int branch_id, Branch branch, HttpServletRequest request) {
        Branch _branch = this.branchRepository.findById(branch_id)
                .orElseThrow(() -> new ResourceNotFoundException("Branch", "id", branch_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _branch.setBranch_code(branch.getBranch_code());
        _branch.setBranch_name(branch.getBranch_name());
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
