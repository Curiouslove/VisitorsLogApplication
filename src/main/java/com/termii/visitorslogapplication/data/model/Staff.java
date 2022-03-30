package com.termii.visitorslogapplication.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String staffName;

    private String phoneNumber;

   @Email
   @Column(unique = true)
    private String emailAddress;

    private String address;

    private String password;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Authority> authorities;
}
