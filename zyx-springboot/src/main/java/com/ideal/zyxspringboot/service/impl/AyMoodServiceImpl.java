package com.ideal.zyxspringboot.service.impl;

import com.ideal.zyxspringboot.model.AyMood;
import com.ideal.zyxspringboot.repository.AyMoodRepository;
import com.ideal.zyxspringboot.service.AyMoodService;

import javax.annotation.Resource;

public class AyMoodServiceImpl implements AyMoodService {
    @Resource
    private AyMoodRepository ayMoodRepository;

    @Override
    public AyMood save(AyMood ayMood){
        return ayMoodRepository.save(ayMood);
    }
}
