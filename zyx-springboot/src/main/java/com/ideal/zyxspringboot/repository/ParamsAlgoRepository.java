package com.ideal.zyxspringboot.repository;

import com.ideal.zyxspringboot.model.ParamsAlgo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParamsAlgoRepository extends JpaRepository<ParamsAlgo,String> {
    List<ParamsAlgo> findParamsAlgosByAlgoId(long algoId);
}
