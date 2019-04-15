package com.ideal.zyxspringboot.repository;

import com.ideal.zyxspringboot.model.Algo;
import com.ideal.zyxspringboot.model.ParamsAlgo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlgoRepository extends JpaRepository<Algo,String> {
    Algo findById(long Id);
}
