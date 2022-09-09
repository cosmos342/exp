package com.expt.repository;

import com.expt.dao.ExperimentDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
@Repository
public interface ExperimentRepository extends JpaRepository<ExperimentDao,Long> {
    String USERS_BY_LOGIN_CACHE = "usersByLogin";
}
