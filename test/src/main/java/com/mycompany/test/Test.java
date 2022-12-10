package com.mycompany.test;
import java.sql.SQLException;
import java.text.ParseException;

public class Test {

    public static void main(String[] args) throws SQLException, ParseException {
        Room.addRoom(1, "double", "sea view", 0, "VIP", "open buffeh", 2, 1, 0, 0, 0, 1500, 0);
          Room.addRoom(2, "TRiple", "Balcony", 1, "VIP", "open bufih free gym swimmingpool", 3, 2, 1, 1, 1, 250, 1);
           Room.addRoom(3, "single", "No view", 1, "Normal", "2 meals", 1, 2, 0, 0, 0, 10, 1);
Room.deleteRoom(1);
         Room.showData();
    }
}
