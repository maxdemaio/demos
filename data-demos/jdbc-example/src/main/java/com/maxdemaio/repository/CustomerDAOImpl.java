package com.maxdemaio.repository;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.maxdemaio.entity.Customer;

public class CustomerDAOImpl implements CustomerDAO {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    @Override
    public void insert(Customer customer) {
        try (FileInputStream fis = new FileInputStream("src/main/resources/application.properties");) {
            Properties p = new Properties();
            p.load(fis);
            String dname = (String) p.get("jdbc.driverClassName");
            String url = (String) p.get("spring.datasource.url");
            String username = (String) p.get("spring.datasource.username");
            String password = (String) p.get("spring.datasource.password");
            Class.forName(dname);
            // Register driver
            con = DriverManager.getConnection(url, username, password);
            // Create connection
            String query = "insert into customer values (?,?,?,?,?,?)";
            // Create prepared statement
            stmt = con.prepareStatement(query);
            stmt.setLong(1, customer.getPhoneNumber());
            stmt.setString(2, customer.getName());
            stmt.setInt(3, customer.getAge());
            stmt.setString(4, customer.getGender().toString());
            stmt.setString(5, customer.getAddress());
            stmt.setInt(6, customer.getPlanId());
            // Execute query
            stmt.executeUpdate();
            System.out.println("Record inserted");
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            try {
                // Close the prepared statement
                stmt.close();
                // Close the connection
                con.close();
            } catch (Exception e) {
                System.out.println("error: " + e.getMessage());
            }
        }
    }

    @Override
    public int remove(Long phoneNo) {
        int result = 1;
        try (FileInputStream fis = new FileInputStream("src/main/resources/application.properties");) {
            Properties p = new Properties();
            p.load(fis);
            String dname = (String) p.get("jdbc.driverClassName");
            String url = (String) p.get("spring.datasource.url");
            String username = (String) p.get("spring.datasource.username");
            String password = (String) p.get("spring.datasource.password");
            Class.forName(dname);
            // Create connection
            con = DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM Customer WHERE phone_no = ?";
            // Create prepared statement
            stmt = con.prepareStatement(query);
            stmt.setLong(1, phoneNo);
            // Execute query
            result = stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            try {
                // Close the prepared statement
                stmt.close();
                // Close the connection
                con.close();
            } catch (Exception e) {
                System.out.println("error: " + e.getMessage());
            }
        }
        return result;
    }
}
