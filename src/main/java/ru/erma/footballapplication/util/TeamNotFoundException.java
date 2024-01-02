package ru.erma.footballapplication.util;



public class TeamNotFoundException extends RuntimeException{
    public TeamNotFoundException(String teamName){
        super("Team: " + teamName + " not found");
    }
}
