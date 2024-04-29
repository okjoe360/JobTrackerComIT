package com.jobtracker.jobapp.entity;


import com.jobtracker.jobapp.enums.Role;
import com.jobtracker.jobapp.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(nullable = false, unique = true, length = 155)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "first_name", nullable = false, length = 155)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 155)
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    @Column(name = "post_code", length = 6)
    private String postCode;

    private Status status = Status.ACTIVE;

    private Role role = Role.USER;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    //private List<Jobs> jobsList;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    //private List<Education> educationList;

    @Override
    public String toString() {
        return String.format(
                "User [idUser=%s, email=%s, password=%s, email=%s, firstName=%s, lastName=%s, birth=%s, status=%s, role=%s]",
                idUser, username, password, email, firstName, lastName, birth, status, role);
    }
}
