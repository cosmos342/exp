package com.expt.repository;

import com.expt.dao.TreatmentDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
@Repository
public interface TreatmentRepository extends JpaRepository<TreatmentDao,Long> {
    String USERS_BY_LOGIN_CACHE = "usersByLogin";
}
