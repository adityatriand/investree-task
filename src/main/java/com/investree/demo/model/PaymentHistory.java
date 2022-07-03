package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="payment_history")

public class PaymentHistory implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_transaksi")
    private Transaksi transaksi;

    @Column(name = "pembayaran_ke")
    private Integer pembayaran_ke;

    @Column(name = "jumlah")
    private Double jumlah;

    @Column(name = "bukti_pembayaran")
    private String bukti_pembayaran;
}
