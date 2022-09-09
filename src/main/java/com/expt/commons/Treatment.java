package com.expt.commons;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Treatment {
    Long id;
    String name;
    List<CellRange> cells;
    Double allocationPercent;
}

