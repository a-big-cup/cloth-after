package com.cloth.clothfrontweb.commonmodel.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "magazine")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Magazine {
    @Id
    private Integer id;
    private String time;
    private String name;
    private int hot;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "magazine_designer",
            joinColumns ={@JoinColumn(name="magazine_id",referencedColumnName = "id")},
            inverseJoinColumns={@JoinColumn(name = "designer_id",referencedColumnName = "id")}
    )
    private Set<Designer>  designers=new HashSet<>();
}
