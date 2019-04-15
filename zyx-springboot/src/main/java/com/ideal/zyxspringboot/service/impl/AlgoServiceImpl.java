package com.ideal.zyxspringboot.service.impl;

import com.ideal.zyxspringboot.model.Algo;
import com.ideal.zyxspringboot.repository.AlgoRepository;
import com.ideal.zyxspringboot.service.AlgoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AlgoServiceImpl implements AlgoService {
    @Resource
    private AlgoRepository algoRepository;
    @Override
    public List<Algo> findAll(){
        return algoRepository.findAll();
    }
    @Override
    public Algo findById(long id){
        return algoRepository.findById(id);
    }

}
