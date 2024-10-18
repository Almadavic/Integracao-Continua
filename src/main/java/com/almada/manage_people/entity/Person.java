package com.almada.manage_people.entity;

import com.almada.manage_people.enumerated.MaritalStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @CreationTimestamp
    private LocalDate created;

    @Builder
    public Person(String name, String email, Integer age, MaritalStatus maritalStatus) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.maritalStatus = maritalStatus;
    }

}
