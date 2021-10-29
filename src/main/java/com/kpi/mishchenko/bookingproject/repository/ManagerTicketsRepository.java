package com.kpi.mishchenko.bookingproject.repository;

import com.kpi.mishchenko.bookingproject.entity.ManagerTicketsEntity;
import com.kpi.mishchenko.bookingproject.entity.TicketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerTicketsRepository extends CrudRepository<ManagerTicketsEntity, Long> {

    boolean existsByTicket(TicketEntity ticket);

}
