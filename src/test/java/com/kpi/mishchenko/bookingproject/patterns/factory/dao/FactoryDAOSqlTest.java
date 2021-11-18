package com.kpi.mishchenko.bookingproject.patterns.factory.dao;

import com.kpi.mishchenko.bookingproject.patterns.factory.ticket.TicketDAO;
import com.kpi.mishchenko.bookingproject.patterns.factory.ticket.TicketDAOSql;
import com.kpi.mishchenko.bookingproject.patterns.factory.user.UserDAO;
import com.kpi.mishchenko.bookingproject.patterns.factory.user.UserDAOSql;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class FactoryDAOSqlTest {

    private FactoryDAOSql factoryDAOSql;

    private Connection connection;

    @Before
    public void setUp() {
        factoryDAOSql = new FactoryDAOSql();
        connection = mock(Connection.class);
    }

    @Test
    public void createUserDAO_Connection_CallCreateUserDAOWithSuccessfulCreation() {
        UserDAO<?> expected = new UserDAOSql(connection);
        UserDAO<?> actual = factoryDAOSql.createUserDAO(connection);

        assertEquals(expected, actual);
    }

    @Test
    public void createTicketDAO_Connection_CallCreateTicketDAOWithSuccessfulCreation() {
        TicketDAO<?> expected = new TicketDAOSql(connection);
        TicketDAO<?> actual = factoryDAOSql.createTicketDAO(connection);

        assertEquals(expected, actual);
    }

}
