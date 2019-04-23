package com.ideal.zyxspringboot.repository;

import com.ideal.zyxspringboot.model.AyMood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AyMoodRepository extends JpaRepository<AyMood,String> {
    AyMood save(AyMood ayMood);
}
