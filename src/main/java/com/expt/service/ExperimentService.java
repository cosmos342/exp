package com.expt.service;

import com.expt.commons.Experiment;
import com.expt.dao.ExperimentDao;
import com.expt.dao.TreatmentDao;
import com.expt.mapper.ExperimentMapper;
import com.expt.repository.ExperimentRepository;
import com.expt.repository.TreatmentRepository;
import com.sun.source.tree.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class ExperimentService {
    ExperimentRepository experimentRepository;

    TreatmentRepository treatmentRepository;

    public ExperimentService(
            ExperimentRepository experimentRepository,
            TreatmentRepository treatmentRepository
    ) {
        this.experimentRepository = experimentRepository;
        this.treatmentRepository = treatmentRepository;
    }

    public Experiment createExperiment(Experiment experiment) {
        // validate (name,treatment(min 1), allocation(non overlapping, later)
        // create the experiment and treatments and return the object (that has the id)
        ExperimentDao dao = ExperimentMapper.mappToDao(experiment);
        ExperimentDao resDao = experimentRepository.saveAndFlush(dao);
        return ExperimentMapper.mappToCommons(resDao);

    }

    public Experiment updateExperiment(Experiment experiment) {
        // verify existing experiment, verify as above for new experiment, verify id is non null
        ExperimentDao dao = experimentRepository.getReferenceById(experiment.getId());
        ExperimentDao inDao = ExperimentMapper.mappToDao(experiment);
        Map<String,TreatmentDao> map = new HashMap<>();
        inDao.getTreatments().forEach(t->map.put(t.getTrmt_name(),t));
        Set<Integer> remIdx = new HashSet<>();
        for(int i=0 ; i < dao.getTreatments().size() ; i++) {
            TreatmentDao existingDao = dao.getTreatments().get(i);
            if(map.containsKey(existingDao.getTrmt_name())) {
                TreatmentDao inTrmt = map.get(existingDao.getTrmt_name());
                existingDao.setCellRanges(inTrmt.getCellRanges());
            }
            else {
                remIdx.add(i);
            }
        }
        for (Integer idx : remIdx) {
            dao.getTreatments().remove(idx.intValue());
        }

        ExperimentDao resDao = experimentRepository.saveAndFlush(dao);
        return ExperimentMapper.mappToCommons(resDao);
    }

    public Experiment getExperiment(Long id) {
        // return experiment
        ExperimentDao dao = experimentRepository.getReferenceById(id);
        return ExperimentMapper.mappToCommons(dao);
    }
}
