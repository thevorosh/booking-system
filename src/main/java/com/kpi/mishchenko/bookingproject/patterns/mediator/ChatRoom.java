package com.kpi.mishchenko.bookingproject.patterns.mediator;

public class ChatRoom implements ChatRoomMediator {

    @Override
    public void showMessage(User user, String message) {
        String sender = user.getName();
        System.out.println("[" + sender + "]: " + message);
    }

}
