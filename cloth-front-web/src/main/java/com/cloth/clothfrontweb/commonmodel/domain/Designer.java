package com.cloth.clothfrontweb.commonmodel.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "designer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Designer {
    private String surface;
    private String surfaceIntroduce;
    private String surfaceTopic;
    private String type;
    private String comment;
    @Id
    private Integer id;
    private int hot;
//    中间表谁维护写谁
    @JsonIgnore
    @ManyToMany(mappedBy = "designers")
    Set<Magazine> magazines=new HashSet<>();
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "designer_id",referencedColumnName = "id")
    Set<Expriences> expriences=new HashSet<>();
}
