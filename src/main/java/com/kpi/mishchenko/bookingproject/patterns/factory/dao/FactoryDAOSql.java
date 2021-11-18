package com.kpi.mishchenko.bookingproject.patterns.factory.dao;

import com.kpi.mishchenko.bookingproject.patterns.factory.ticket.TicketDAO;
import com.kpi.mishchenko.bookingproject.patterns.factory.ticket.TicketDAOSql;
import com.kpi.mishchenko.bookingproject.patterns.factory.user.UserDAO;
import com.kpi.mishchenko.bookingproject.patterns.factory.user.UserDAOSql;

import java.sql.Connection;

public class FactoryDAOSql implements FactoryDAO {

    @Override
    public UserDAO createUserDAO(Connection connection) {
        return new UserDAOSql(connection);
    }

    @Override
    public TicketDAO createTicketDAO(Connection connection) {
        return new TicketDAOSql(connection);
    }

}
