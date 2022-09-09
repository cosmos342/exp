package com.expt.commons;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CellRange {
    int Start;
    int End;
}
