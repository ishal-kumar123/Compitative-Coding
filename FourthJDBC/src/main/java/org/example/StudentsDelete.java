package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentsDelete {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","bishal123@");
            System.out.println("enter the id");
            int id=sc.nextInt();
            String qry="DELETE FROM students_insert WHERE id=?";
            PreparedStatement pstmt= con.prepareStatement(qry);
            pstmt.setInt(1,id);
            int result= pstmt.executeUpdate();
            if(result>0)
            {
                System.out.println("data deleted successfully");
            }
            else {
                System.out.println("data was not deleted");
            }
            pstmt.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
