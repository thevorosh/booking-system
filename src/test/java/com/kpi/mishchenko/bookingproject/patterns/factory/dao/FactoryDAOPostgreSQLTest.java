package com.kpi.mishchenko.bookingproject.patterns.factory.dao;

import com.kpi.mishchenko.bookingproject.patterns.factory.ticket.TicketDAO;
import com.kpi.mishchenko.bookingproject.patterns.factory.ticket.TicketDAOPostgreSQL;
import com.kpi.mishchenko.bookingproject.patterns.factory.user.UserDAO;
import com.kpi.mishchenko.bookingproject.patterns.factory.user.UserDAOPostgreSQL;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;

public class FactoryDAOPostgreSQLTest {

    private FactoryDAO factory;

    private Connection connection;

    @Before
    public void setUp() {
        factory = new FactoryDAOPostgreSQL();
        connection = mock(Connection.class);
    }

    @Test
    public void createUserDAOPostgreSQL_Connection_CallCreateUserDAOPostgreSQLWithSuccessfulCreation() {
        UserDAO<?> expected = new UserDAOPostgreSQL(connection);
        UserDAO<?> actual = factory.createUserDAO(connection);

        assertEquals(expected, actual);
    }

    @Test
    public void createTicketDAOPostgreSql_Connection_CallCreateTicketDAOPostgreSqlWithSuccessfulCreation() {
        TicketDAO<?> expected = new TicketDAOPostgreSQL(connection);
        TicketDAO<?> actual = factory.createTicketDAO(connection);

        assertEquals(expected, actual);
    }

}