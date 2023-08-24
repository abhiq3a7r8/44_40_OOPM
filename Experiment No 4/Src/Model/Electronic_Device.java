package model;

//DEFINE CLASS ATTRIBUTES WITH THEIR DATA TYPES

import java.util.ArrayList;

public class Electronic_Device extends Device implements Electronic_Device_dsc{

      private int user_set_wattage;
      private static boolean isTurnedOn;
      ArrayList<String> turn;
      ArrayList<String> timer;

      public void setUser_set_wattage(int user_set_wattage){
            this.user_set_wattage = user_set_wattage;
      }

      public int getUser_set_wattage(){
            return this.user_set_wattage;
      }

      public void setTurnedOn(boolean turnedOn) {
            isTurnedOn = turnedOn;
      }

      public void turnOn() {
            isTurnedOn = true;
            System.out.println("Device turned on.");
      }
      public void turnOff() {
            isTurnedOn = false;
            System.out.println("Device turned off.");
      }
      public boolean isTurnedOn() {
            return isTurnedOn;
      }
      public void setTimer(int minutes) {
            if (isTurnedOn) {
                  System.out.println("Timer set for " + minutes + " minutes.");
            }
            else
                  System.out.println("Turn your device on first");
      }
}