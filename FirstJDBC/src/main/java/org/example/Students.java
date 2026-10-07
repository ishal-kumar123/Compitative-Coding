package org.example;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Students {
    public static void main() {
        try{
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Students","root","bishal123@");
            Statement stmt= con.createStatement();
            ResultSet rs= stmt.executeQuery("SELECT * FROM students_data");
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String city = rs.getString("city");

                System.out.println("id :"+id+" "+ "name :"+name+" "+ "city :"+" "+city);


            }
            con.close();
        } catch (Exception e) {
                throw new RuntimeException(e);
        }
    }
}
