package com.investree.demo.repository;

import com.investree.demo.model.UserDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailRepo extends PagingAndSortingRepository<UserDetail, Long> {
}
