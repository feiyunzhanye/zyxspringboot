package com.ideal.zyxspringboot.service;

import com.ideal.zyxspringboot.model.Algo;

import java.util.List;

public interface AlgoService {
    List<Algo> findAll();
    Algo findById(long Id);
}
