package com.kpi.mishchenko.bookingproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {

    private String county;

    private String city;

    private String street;

    private String build;

}
