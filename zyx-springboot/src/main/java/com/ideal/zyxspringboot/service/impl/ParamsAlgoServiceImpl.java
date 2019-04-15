package com.ideal.zyxspringboot.service.impl;

import com.ideal.zyxspringboot.model.ParamsAlgo;
import com.ideal.zyxspringboot.repository.ParamsAlgoRepository;
import com.ideal.zyxspringboot.service.ParamsAlgoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParamsAlgoServiceImpl implements ParamsAlgoService {
    @Resource
    private ParamsAlgoRepository paramsAlgoRepository;
    @Override
    public List<ParamsAlgo> findParamsAlgosByAlgoId(long algoId){
        return paramsAlgoRepository.findParamsAlgosByAlgoId(algoId);
    }
}
