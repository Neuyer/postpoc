package com.neuyer.postpoc.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "user")
    private List<Publition> publitions;
    @OneToMany(mappedBy = "user")
    private List<Like> likes;
}
