package com.kpi.mishchenko.bookingproject.patterns.factory.dao;

import com.kpi.mishchenko.bookingproject.patterns.factory.ticket.TicketDAO;
import com.kpi.mishchenko.bookingproject.patterns.factory.ticket.TicketDAOPostgreSQL;
import com.kpi.mishchenko.bookingproject.patterns.factory.user.UserDAO;
import com.kpi.mishchenko.bookingproject.patterns.factory.user.UserDAOPostgreSQL;

import java.sql.Connection;

public class FactoryDAOPostgreSQL implements FactoryDAO {

    @Override
    public UserDAO createUserDAO(Connection connection) {
        return new UserDAOPostgreSQL(connection);
    }

    @Override
    public TicketDAO createTicketDAO(Connection connection) {
        return new TicketDAOPostgreSQL(connection);
    }

}
