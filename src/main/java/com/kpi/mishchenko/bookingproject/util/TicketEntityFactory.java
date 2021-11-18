package com.kpi.mishchenko.bookingproject.util;

import com.kpi.mishchenko.bookingproject.entity.LocationEntity;
import com.kpi.mishchenko.bookingproject.entity.RoomEntity;
import com.kpi.mishchenko.bookingproject.entity.TicketEntity;
import com.kpi.mishchenko.bookingproject.model.Location;
import com.kpi.mishchenko.bookingproject.model.Room;
import com.kpi.mishchenko.bookingproject.model.Ticket;
import com.kpi.mishchenko.bookingproject.model.dto.ManagerTicketDTO;

public final class TicketEntityFactory {

    public TicketEntityFactory() {}

    public static TicketEntity create(ManagerTicketDTO managerTicketDTO) {
        TicketEntity ticket = new TicketEntity();
        ticket.setName(managerTicketDTO.getName());
        ticket.setPrice(managerTicketDTO.getPrice());
        ticket.setDate(managerTicketDTO.getDate());
        ticket.setStatus(managerTicketDTO.getStatus());
        ticket.setLocation(getLocationEntity(managerTicketDTO));
        ticket.setRoom(getRoomEntity(managerTicketDTO));
        return ticket;
    }

    private static LocationEntity getLocationEntity(ManagerTicketDTO managerTicketDTO) {
        LocationEntity location = new LocationEntity();
        location.setCountry(managerTicketDTO.getCounty());
        location.setCity(managerTicketDTO.getCity());
        location.setStreet(managerTicketDTO.getStreet());
        location.setBuild(managerTicketDTO.getBuild());
        return location;
    }

    private static RoomEntity getRoomEntity(ManagerTicketDTO managerTicketDTO) {
        RoomEntity room = new RoomEntity();
        room.setName(managerTicketDTO.getRoomName());
        room.setNumberRows(managerTicketDTO.getNumberRows());
        room.setNumberSeats(managerTicketDTO.getNumberSeats());
        return room;
    }

    public static TicketEntity create(Ticket ticket) {
        return getTicketEntity(ticket);
    }

    private static TicketEntity getTicketEntity(Ticket ticket) {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setName(ticket.getName());
        ticketEntity.setDate(ticket.getDate());
        ticketEntity.setLocation(getLocationEntity(ticket));
        ticketEntity.setStatus(ticket.getStatus());
        ticketEntity.setPrice(ticket.getPrice());
        ticketEntity.setRoom(getRoomEntity(ticket));
        return ticketEntity;
    }

    private static RoomEntity getRoomEntity(Ticket ticket) {
        RoomEntity roomEntity = new RoomEntity();
        Room room = ticket.getRoom();
        roomEntity.setName(room.getName());
        roomEntity.setNumberRows(room.getNumberRows());
        roomEntity.setNumberSeats(room.getNumberSeats());
        return roomEntity;
    }

    private static LocationEntity getLocationEntity(Ticket ticket) {
        LocationEntity locationEntity = new LocationEntity();
        Location location = ticket.getLocation();
        locationEntity.setCountry(location.getCounty());
        locationEntity.setCity(location.getCity());
        locationEntity.setStreet(location.getStreet());
        locationEntity.setBuild(location.getBuild());
        return locationEntity;
    }

}
