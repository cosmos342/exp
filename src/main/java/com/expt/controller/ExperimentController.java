package com.expt.controller;

import com.expt.commons.Experiment;
import com.expt.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ExperimentController {
    @Autowired
    ExperimentService service;

    @PostMapping("/expt")
    Experiment createExperiment(@RequestBody Experiment experiment) {
        return service.createExperiment(experiment);
    }

    @PutMapping("/expt")
    Experiment updateExperiment(@RequestBody Experiment experiment) {
        return service.updateExperiment(experiment);
    }

    @GetMapping("/expt/{id}")
    Experiment getExperiment(@PathVariable long id) {
        return service.getExperiment(id);
    }

}
