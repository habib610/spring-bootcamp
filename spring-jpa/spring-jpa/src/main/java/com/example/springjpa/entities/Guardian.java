package com.example.springjpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name="name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name="phone",
                column = @Column(name = "guardian_phone")
        ),
        @AttributeOverride(
                name="email",
                column = @Column(name = "guardian_email")
        ), @AttributeOverride(
        name="address",
        column = @Column(name = "guardian_address")
)
}
)
public class Guardian {
    private String name;
    private String phone;
    private String address;
    private String email;
}
