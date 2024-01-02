package ru.erma.footballapplication.util;




public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(String lastName){
        super("Player not found with lastName: " + lastName);

    }
}
