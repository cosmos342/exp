package com.expt.mapper;

import com.expt.commons.CellRange;
import com.expt.commons.Experiment;
import com.expt.commons.Treatment;
import com.expt.dao.ExperimentDao;
import com.expt.dao.TreatmentDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class TreatmentMapper {
    public static String cellsToString(List<CellRange> cellRangeList) {
        StringBuilder sb = new StringBuilder();
        cellRangeList.stream().forEach(c -> {
            sb.append(c.getStart());
            sb.append('-');
            sb.append(c.getEnd());
            sb.append(',');
        });
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public static List<CellRange> stringToCellRangeList(String cells) {
        List<CellRange> list = new ArrayList<>();
        String [] cellRanges = cells.split(",");
        for(String range : cellRanges) {
            String [] cellrange = range.split("-");
            list.add(CellRange.builder().Start(Integer.parseInt(cellrange[0])).End(Integer.parseInt(cellrange[1]))
                    .build());
        }
        return list;
    }
    public static TreatmentDao mappToDao(Treatment trmt, ExperimentDao exptDao) {
        String cells = cellsToString(trmt.getCells());
        return TreatmentDao.builder().tid(trmt.getId()).trmt_name(trmt.getName()).cellRanges(cells).expt(exptDao)
                //.allocation_percent(trmt.getAllocationPercent())
                .build();
    }
    public static Treatment mappToCommon(TreatmentDao treatmentDao) {
        List<CellRange> cellRangeList = stringToCellRangeList(treatmentDao.getCellRanges());
        return Treatment.builder().id(treatmentDao.getTid()).name(treatmentDao.getTrmt_name()).cells(cellRangeList)
                .allocationPercent(treatmentDao.getAllocation_percent()).build();
    }
}
