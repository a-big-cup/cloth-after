package com.cloth.clothfrontweb.commonmodel.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "expriences")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expriences {
    private String text;
    private String blackTopic;
    private String picture;
    @Id
    private Integer id;
    private String type;
    private int hot;

    @JsonIgnore
    @ManyToOne(targetEntity =Designer.class )
    private Designer designer;
}
