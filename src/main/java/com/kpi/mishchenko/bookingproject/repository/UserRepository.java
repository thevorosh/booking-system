package com.kpi.mishchenko.bookingproject.repository;

import com.kpi.mishchenko.bookingproject.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
