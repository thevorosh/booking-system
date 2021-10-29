package com.kpi.mishchenko.bookingproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "manager_tickets")
@Getter
@Setter
public class ManagerTicketsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id", nullable = false)
    private UserEntity manager;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    private TicketEntity ticket;

}
