package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentDataInsert {
    static void main() {
        Scanner sc=new Scanner(System.in);
        try{
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","bishal123@");
            System.out.println("enter the student id");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.println("enter the student name");
            String name=sc.nextLine();
            System.out.println("enter the Student city");
            String city=sc.nextLine();
            String qry="insert into students_insert (id,name,city) values(?, ?, ?)";
            PreparedStatement pstmt=con.prepareStatement(qry);
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setString(3,city);

            int result=pstmt.executeUpdate();
            if(result>0)
            {
                System.out.println("data inserted successfully");
            }
            pstmt.close();
            con.close();



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
