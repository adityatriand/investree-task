package com.investree.demo.repository;

import com.investree.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends PagingAndSortingRepository<User, Long> {
    @Query("select c from User c")// nama class
    public List<User> getList();
    @Query("select c from User c WHERE c.id = :id")
    public User getByID(@Param("id") Long id);
}
