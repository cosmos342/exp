package com.expt.dao;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "treatment")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentDao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tid;
    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private ExperimentDao expt;

    @NotNull
    @Column(name ="trmt_name", length = 50)
    private String trmt_name;

    @NotNull
    private double allocation_percent;

    @Nullable
    private String cellRanges;

}
