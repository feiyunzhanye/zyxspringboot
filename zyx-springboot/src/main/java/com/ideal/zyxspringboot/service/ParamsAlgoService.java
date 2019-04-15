package com.ideal.zyxspringboot.service;

import com.ideal.zyxspringboot.model.ParamsAlgo;

import java.util.List;

public interface ParamsAlgoService {
    List<ParamsAlgo> findParamsAlgosByAlgoId(long algoId);
}
