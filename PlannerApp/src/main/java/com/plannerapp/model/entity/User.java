package com.plannerapp.model.entity;

import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "uuid-char")
    private UUID id;

    @Length(min = 3, max = 20)
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "assignee")
    private Set<Task> tasks;
}
