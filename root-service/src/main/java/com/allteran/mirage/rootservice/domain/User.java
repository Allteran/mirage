package com.allteran.mirage.rootservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String phone;
    private String firstName;
    private String lastName;
    private String password;

    @Transient
    private String newPassword;
    @Transient
    private String passwordConfirm;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    private boolean active;
    private LocalDateTime creationDate;
    private LocalDateTime dismissalDate;

}
