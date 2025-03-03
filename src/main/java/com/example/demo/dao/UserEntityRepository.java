package com.example.demo.dao;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, String> {

//    @Override
//    <S extends UserEntity> S save(S entity);
//
//    @Override
//    void delete(UserEntity entity);

}
