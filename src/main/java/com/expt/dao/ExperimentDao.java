package com.expt.dao;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "experiment")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperimentDao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name ="expt_name", unique = true)
    private String name;

//    @JsonIgnore
//    @OneToMany
//    @JoinTable(
//            name = "treatments",
//            joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
//    )
//    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//    @BatchSize(size = 20)
    @OneToMany(mappedBy="expt", cascade=CascadeType.ALL, orphanRemoval=true)
//    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
//            org.hibernate.annotations.CascadeType.DELETE,
//            org.hibernate.annotations.CascadeType.MERGE,
//            org.hibernate.annotations.CascadeType.PERSIST,
//            org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    private List<TreatmentDao> treatments;

}
