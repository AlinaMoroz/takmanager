package com.taskmanager.demo.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Timestamped implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;
    @Column(unique = true, nullable = false)
    private String password;


    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Task> createdTasks = new ArrayList<>();

    @OneToMany(mappedBy = "executor", fetch = FetchType.LAZY)
    private List<Task> assignedTasks = new ArrayList<>();

}
