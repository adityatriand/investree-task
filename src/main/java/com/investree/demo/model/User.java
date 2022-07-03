package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", unique = true)
    private String username;

    @Column(name="password")
    private String password;

    @Column(name = "is_active")
    private Boolean is_active;

    @OneToOne(mappedBy = "user")
    private UserDetail userdetail;

    @OneToMany(mappedBy = "peminjam")
    private List<Transaksi> pinjam;

    @OneToMany(mappedBy = "meminjam")
    private List<Transaksi> dipinjam;

}
