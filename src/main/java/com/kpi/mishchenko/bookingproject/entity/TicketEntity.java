package com.kpi.mishchenko.bookingproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tickets")
@Getter
@Setter
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private Date date;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", nullable = false)
    private LocationEntity location;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;

    @OneToOne(mappedBy = "ticket")
    private ManagerTicketsEntity manager;

}
