package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="transaksi")
public class Transaksi implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_peminjam")
    private User peminjam;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_meminjam")
    private User meminjam;

    @Column(name = "tenor")
    private Integer tenor;

    @Column(name = "total_pinjaman")
    private Double total_pinjaman;

    @Column(name = "bunga_persen")
    private  Double bunga_persen;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "transaksi")
    private List<PaymentHistory> riwayat_pembayaran;
}
