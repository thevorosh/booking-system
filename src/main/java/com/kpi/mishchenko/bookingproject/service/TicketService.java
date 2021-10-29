package com.kpi.mishchenko.bookingproject.service;

import com.kpi.mishchenko.bookingproject.entity.TicketEntity;
import com.kpi.mishchenko.bookingproject.model.Ticket;
import com.kpi.mishchenko.bookingproject.repository.LocationRepository;
import com.kpi.mishchenko.bookingproject.repository.RoomRepository;
import com.kpi.mishchenko.bookingproject.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public boolean insert(TicketEntity ticket) {
        if (ticketRepository.existsByNameAndDate(ticket.getName(), ticket.getDate())) {
            return false;
        }
        ticketRepository.save(ticket);
        return true;
    }

}
