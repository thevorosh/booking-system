package com.kpi.mishchenko.bookingproject.repository;

import com.kpi.mishchenko.bookingproject.entity.TicketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface TicketRepository extends CrudRepository<TicketEntity, Long> {

    boolean existsByNameAndDate(String name, Date date);

}
