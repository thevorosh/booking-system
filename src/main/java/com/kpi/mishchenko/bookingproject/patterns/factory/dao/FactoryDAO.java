package com.kpi.mishchenko.bookingproject.patterns.factory.dao;

import com.kpi.mishchenko.bookingproject.patterns.factory.ticket.TicketDAO;
import com.kpi.mishchenko.bookingproject.patterns.factory.user.UserDAO;

import java.sql.Connection;

public interface FactoryDAO {

    UserDAO createUserDAO(Connection connection);
    TicketDAO createTicketDAO(Connection connection);

}
