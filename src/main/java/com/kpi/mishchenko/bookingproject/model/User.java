package com.kpi.mishchenko.bookingproject.model;

import lombok.Data;

@Data
public class User {

    private Long id;

    private String username;

    private String email;

    private Role role;

}
