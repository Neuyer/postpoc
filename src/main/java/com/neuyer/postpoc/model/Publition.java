package com.neuyer.postpoc.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "publition_table")
public class Publition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "publitions")
    private List<Like> likes;
}
