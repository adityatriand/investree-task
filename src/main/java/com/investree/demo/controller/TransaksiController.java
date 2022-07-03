package com.investree.demo.controller;

import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.TransaksiRepo;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/transaksi")
public class TransaksiController {

    @Autowired
    public TransaksiRepo repo;

    @Autowired
    public TransaksiService servis;

    @PostMapping
    public ResponseEntity<Map> save(@RequestBody Transaksi transaksi){
        Map map = new HashMap();
        Map obj = servis.save(transaksi);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Map> updateStatus(@RequestBody Transaksi transaksi){
        Map map = new HashMap();
        Map obj = servis.updateStatus(transaksi);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Transaksi>> list(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam() String status) {
        Pageable show_data = (Pageable) PageRequest.of(page, size);
        Page<Transaksi> listData = (Page<Transaksi>) repo.getList();
//        if(status.isEmpty()) {
//            listData = (Page<Transaksi>) repo.getList();
//        }else {
//            listData = repo.findByStatusLike("%" + status + "%", show_data);
//        }
        return new ResponseEntity<Page<Transaksi>>(listData, new HttpHeaders(), HttpStatus.OK);
    }





}
