package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class SimpleJDBCTest {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/EmployeeDB";
        String username = "root";
        String password = "pETER2600";
        String query = "SELECT * FROM Employee";
        try (Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement()){
        	String insert = "INSERT INTO Employee VALUES(13,'Sean','Cheng','1974-03-21',50000)";
        	int result =stmt.executeUpdate(insert);
        	if(result==1)
        		System.out.println("新增員工成功!");
        	else
        		System.out.println("新增員工失敗!");
        
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int empID = rs.getInt("ID");
                String first = rs.getString("FirstName");
                String last = rs.getString("LastName");
                Date birthDate = rs.getDate("BirthDate");
                float salary = rs.getFloat("Salary");
                System.out.println("Employee ID:   " + empID + "\n"
                        + "Employee Name: " + first + " " + last + "\n"
                        + "Birth Date:    " + birthDate + "\n"
                        + "Salary:        " + salary + "\n");
            } // end of while
        } catch (SQLException ex) {
            while (ex != null) {
                System.out.println("SQLState:  " + ex.getSQLState());
                System.out.println("Error Code:" + ex.getErrorCode());
                System.out.println("Message:   " + ex.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause:" + t);
                    t = t.getCause();
                }
                ex = ex.getNextException();
            }
        }
    }
}