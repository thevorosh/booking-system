package com.kpi.mishchenko.bookingproject.patterns.mediator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String name;

    private ChatRoomMediator chatMediator;

    public void sendMessage(String message) {
        this.chatMediator.showMessage(this, message);
    }

}
