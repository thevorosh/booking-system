package com.kpi.mishchenko.bookingproject.service;

import com.kpi.mishchenko.bookingproject.entity.ManagerTicketsEntity;
import com.kpi.mishchenko.bookingproject.model.dto.ManagerTicketDTO;
import com.kpi.mishchenko.bookingproject.repository.ManagerTicketsRepository;
import com.kpi.mishchenko.bookingproject.util.TicketEntityFactory;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ManagerTicketsService {

    private final ManagerTicketsRepository managerTicketsRepository;

    private final UserService userService;

    public ManagerTicketsService(ManagerTicketsRepository managerTicketsRepository, UserService userService) {
        this.managerTicketsRepository = managerTicketsRepository;
        this.userService = userService;
    }

    public boolean insert(ManagerTicketsEntity managerTicket) {
        if (managerTicketsRepository.existsByTicket(managerTicket.getTicket())) {
            return false;
        }
        managerTicketsRepository.save(managerTicket);
        return true;
    }

    public ResponseEntity<Map<String, Object>> addTicket(ManagerTicketDTO managerTicket) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (insert(getManagerTicketsEntity(managerTicket))) {
                map.put("Status", "added");
                return new ResponseEntity<>(map, HttpStatus.OK);
            }
            map.put("Status", "existed");
        } catch (NotFoundException e) {
            log.error("Can not to add new ticket for manager with id: {}", managerTicket.getManagerId());
            map.put("Status", "error");
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    private ManagerTicketsEntity getManagerTicketsEntity(ManagerTicketDTO managerTicket) throws NotFoundException {
        ManagerTicketsEntity managerTickets = new ManagerTicketsEntity();
        managerTickets.setManager(userService.get(managerTicket.getManagerId()));
        managerTickets.setTicket(TicketEntityFactory.create(managerTicket));
        return managerTickets;
    }

}
