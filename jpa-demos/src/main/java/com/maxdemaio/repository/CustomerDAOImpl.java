package com.maxdemaio.repository;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.apache.log4j.Logger;
import com.maxdemaio.entity.Customer;

public class CustomerDAOImpl implements CustomerDAO {
    static Logger logger = Logger.getLogger(CustomerDAOImpl.class);
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    @Override
    public void insert(Customer customer) {
        try (FileInputStream fis = new FileInputStream("resources/application.properties");) {
            Properties p = new Properties();
            p.load(fis);
            String dname = (String) p.get("JDBC_DRIVER");
            String url = (String) p.get("JDBC_URL");
            String username = (String) p.get("USER");
            String password = (String) p.get("PASSWORD");
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
            logger.info("Record inserted");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                // Close the prepared statement
                stmt.close();
                // Close the connection
                con.close();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    @Override
    public int remove(Long phoneNo) {
        int result = 1;
        try (FileInputStream fis = new FileInputStream("resources/application.properties");) {
            Properties p = new Properties();
            p.load(fis);
            String dname = (String) p.get("JDBC_DRIVER");
            String url = (String) p.get("JDBC_URL");
            String username = (String) p.get("USER");
            String password = (String) p.get("PASSWORD");
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
            logger.error(e.getMessage(), e);
        } finally {
            try {
                // Close the prepared statement
                stmt.close();
                // Close the connection
                con.close();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return result;
    }
}
