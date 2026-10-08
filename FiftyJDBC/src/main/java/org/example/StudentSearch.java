package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentSearch {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","bishal123@");
            System.out.println("Enter the id");
            int id=sc.nextInt();
            String qrt="SELECT * FROM students_insert WHERE id=?";
            PreparedStatement pstmt=con.prepareStatement(qrt);
            pstmt.setInt(1,id);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next())
            {
                System.out.println("\nStudent Found");
                System.out.println("----------------");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("City: " + rs.getString("city"));
            }
            else {
                System.out.println("ID not found");
            }
            pstmt.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
