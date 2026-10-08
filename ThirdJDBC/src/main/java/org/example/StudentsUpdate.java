package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentsUpdate {

    static void main() {
        Scanner sc=new Scanner(System.in);
        try{
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","bishal123@");
            System.out.println("enter the id");
            int id =sc.nextInt();
            sc.nextLine();
            System.out.println("enter the new name");
            String name= sc.nextLine();
            System.out.println("enter the new city");
            String city=sc.nextLine();
            String qry = "UPDATE students_insert SET name=?, city=? WHERE id=?";
            PreparedStatement pstmt= con.prepareStatement(qry);
            pstmt.setString(1,name);
            pstmt.setString(2,city);
            pstmt.setInt(3,id);
            int resul=pstmt.executeUpdate();
            if(resul>0)
            {
                System.out.println("data updated successfully");
            }
            else {
                System.out.println("data not inserted");
            }
            pstmt.close();
            con.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
