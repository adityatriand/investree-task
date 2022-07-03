package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="user_detail")
public class UserDetail implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "alamat")
    private String alamat;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;
}
