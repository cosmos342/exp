package com.expt.commons;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Experiment {
    Long id;
    String name;
    List<Treatment> treatments;
}
