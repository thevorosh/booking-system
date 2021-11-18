package com.kpi.mishchenko.bookingproject.patterns.factory.ticket;

import java.sql.Connection;
import java.util.List;

public class TicketDAOPostgreSQL implements TicketDAO<Long> {

    private Connection connection;

    public TicketDAOPostgreSQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Ticket> getAll() {
        return null;
    }

    @Override
    public boolean update(Ticket entity) {
        return false;
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public boolean create(Ticket entity) {
        return false;
    }

    @Override
    public Ticket getById(Long aLong) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketDAOPostgreSQL)) return false;
        TicketDAOPostgreSQL that = (TicketDAOPostgreSQL) o;
        return connection.equals(that.connection);
    }

}
