package com.expt.mapper;


import com.expt.commons.Experiment;
import com.expt.commons.Treatment;
import com.expt.dao.ExperimentDao;
import com.expt.dao.TreatmentDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class ExperimentMapper {

    public static ExperimentDao mappToDao(Experiment expt) {
        List<Treatment> treatments = expt.getTreatments();
        List<TreatmentDao> treatmentDaos = new ArrayList<>();
        ExperimentDao exptDao= ExperimentDao.builder().id(expt.getId()).name(expt.getName()).treatments(treatmentDaos).build();
        treatments.stream().forEach(t->treatmentDaos.add(TreatmentMapper.mappToDao(t,exptDao)));
        return exptDao;
    }
    public static Experiment mappToCommons(ExperimentDao exptDao) {
        List<TreatmentDao> treatmentsDao = exptDao.getTreatments();
        List<Treatment>  treatments = new ArrayList<>();
        treatmentsDao.stream().forEach(t->treatments.add(TreatmentMapper.mappToCommon(t)));
        return Experiment.builder().id(exptDao.getId()).name(exptDao.getName()).treatments(treatments).build();
    }

}
