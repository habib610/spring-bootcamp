package com.example.springjpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student",
uniqueConstraints = @UniqueConstraint(
        name = "email_unique",
        columnNames = "email_address"
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
    @Column(name = "email_address", unique = true, nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;
}
