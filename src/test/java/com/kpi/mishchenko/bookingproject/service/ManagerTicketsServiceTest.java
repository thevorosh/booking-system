package com.kpi.mishchenko.bookingproject.service;

import com.kpi.mishchenko.bookingproject.entity.ManagerTicketsEntity;
import com.kpi.mishchenko.bookingproject.entity.TicketEntity;
import com.kpi.mishchenko.bookingproject.entity.UserEntity;
import com.kpi.mishchenko.bookingproject.model.dto.ManagerTicketDTO;
import com.kpi.mishchenko.bookingproject.repository.ManagerTicketsRepository;
import com.kpi.mishchenko.bookingproject.repository.UserRepository;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ManagerTicketsServiceTest {

    @Autowired
    private ManagerTicketsService managerTicketsService;

    @MockBean
    private ManagerTicketsRepository managerTicketsRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserService userService;

    @Test
    public void addTicket() throws NotFoundException {
        ManagerTicketDTO managerTicketDTO = new ManagerTicketDTO();
        managerTicketDTO.setManagerId(1L);

        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("Status", "added");

        ResponseEntity<Map<String, Object>> expectedResponseEntity =
                new ResponseEntity<>(expectedMap, HttpStatus.OK);

        ResponseEntity<Map<String, Object>> actualResponseEntity = managerTicketsService.addTicket(managerTicketDTO);

        assertEquals(expectedResponseEntity, actualResponseEntity);

        verify(managerTicketsRepository, times(1)).save(ArgumentMatchers.any());
        verify(userService,  times(1)).get(1L);

    }

}