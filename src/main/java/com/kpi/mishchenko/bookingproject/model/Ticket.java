package com.kpi.mishchenko.bookingproject.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Ticket {

    private String name;

    private Double price;

    private Date date;

    private String status;

    private Location location;

    private Room room;

}
