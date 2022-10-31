package com.example.springjpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(uniqueConstraints =
@UniqueConstraint(
        name = "email_unique",
        columnNames = "student_email"
)
)
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            allocationSize = 1,
            sequenceName = "student_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(
            name = "student_email",
            unique = true,
            nullable = false
    )
    private String studentEmail;
@Embedded
    private Guardian guardian;
}
