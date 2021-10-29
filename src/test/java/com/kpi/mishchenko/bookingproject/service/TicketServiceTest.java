package com.kpi.mishchenko.bookingproject.service;

import com.kpi.mishchenko.bookingproject.entity.TicketEntity;
import com.kpi.mishchenko.bookingproject.model.Location;
import com.kpi.mishchenko.bookingproject.model.Room;
import com.kpi.mishchenko.bookingproject.model.Ticket;
import com.kpi.mishchenko.bookingproject.model.TicketStatus;
import com.kpi.mishchenko.bookingproject.repository.TicketRepository;
import com.kpi.mishchenko.bookingproject.util.TicketEntityFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    @MockBean
    private TicketRepository ticketRepository;

    @Test
    public void insertSuccessful() {
        Ticket ticket = new Ticket();
        ticket.setName("Test ticket");
        ticket.setPrice(150.0);
        Date date = new Date(System.currentTimeMillis());
        ticket.setDate(date);
        ticket.setLocation(new Location("Country", "City", "Street", "Build"));
        ticket.setRoom(new Room("First room",20, 30));
        ticket.setStatus(TicketStatus.NOT_CONFIRMED.toString());

        TicketEntity ticketEntity = TicketEntityFactory.create(ticket);

        boolean isTicketCreated = ticketService.insert(ticketEntity);

        assertTrue(isTicketCreated);

        Mockito.verify(ticketRepository, Mockito.times(1)).save(ticketEntity);
    }

}