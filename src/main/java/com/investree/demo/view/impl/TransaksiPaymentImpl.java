package com.investree.demo.view.impl;

import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.TransaksiRepo;
import com.investree.demo.repository.UserRepo;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class TransaksiPaymentImpl implements TransaksiService {

    @Autowired
    public TransaksiRepo repo;

    @Autowired
    public UserRepo peminjam;

    @Autowired
    public UserRepo meminjam;

    @Override
    public Map save(Transaksi transaksi){
        Map map = new HashMap();
        try{
            Transaksi obj = repo.save(transaksi);
            map.put("data", obj);
            map.put("statusCode", "200");
            map.put("statusMessage", "success");
            return map;
        }catch(Exception e){
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map updateStatus(Transaksi transaksi){
        Map map = new HashMap();
        try{
            Transaksi obj = repo.getById(transaksi.getId());

            if(obj == null ){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data id tidak ditemukan");
                return map;
            }
            obj.setStatus("lunas");
            repo.save(obj);
            map.put("data", obj);
            map.put("statusCode", "200");
            map.put("statusMessage", "Update Success");
            return map;
        }catch(Exception e){
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }
}
