package com.jit.zky.service;

import com.jit.zky.dao.PcodeDao;
import com.jit.zky.entity.Pcode;

import java.util.List;

public class PcodeService {
    private PcodeDao dao = new PcodeDao();

    public List<Pcode> findPcodeListByCodeType(String codeType) {
        return dao.findPcodeListByCodeType(codeType);
    }
}
