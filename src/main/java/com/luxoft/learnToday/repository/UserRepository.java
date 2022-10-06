package com.luxoft.learnToday.repository;



import com.luxoft.learnToday.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    @Query("select s from UserEntity s where s.username = ?1")
    UserEntity findByUsername(String username);
}