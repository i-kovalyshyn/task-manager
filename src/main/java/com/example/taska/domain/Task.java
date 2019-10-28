package com.example.taska.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_fk_id")
    private User user;

    private String name;
}


