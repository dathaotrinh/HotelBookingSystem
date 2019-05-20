/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.io.*;
import java.sql.*;


/**
 *
 * @author Surface
 */
public class GuestTableCreator {
    
    public static void main(String[] args) throws FileNotFoundException {
 
        Connection conn = null;
   
        Statement stmt = null;
        
        String dbName = "Hotel";
        
        File inFile = new File("data.csv");
        
        FullList list = new FullList(inFile);
                       
        
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName);
            stmt = conn.createStatement();
            
            //Drops/deletes the GUESTS table if it already exists
            try {
                stmt.execute("DROP TABLE GUESTS");
                System.out.println("GUESTS TABLE DROPPED");
            } catch(SQLException e) {
                //Table doesn't exist/nothing to drop
            }
            //(Re)creates GUESTS table and inserts test data
            stmt.execute("CREATE TABLE GUESTS (FIRST_NAME VARCHAR(25), LAST_NAME VARCHAR(25), RES_ID INTEGER PRIMARY KEY NOT NULL, NATIONALITY VARCHAR(25), GUEST_TYPE VARCHAR(25), ROOM_TYPE VARCHAR(30), ROOM_NUMBER INTEGER, NUM_GUESTS INTEGER, LIMIT INTEGER, DEPOSIT FLOAT, TOTAL FLOAT, PAID FLOAT, CHECK_IN DATE, CHECK_OUT DATE, PHONE VARCHAR(20), EMAIL VARCHAR(40), NOTE VARCHAR(200))");
            System.out.println("GUESTS TABLE CREATED");

            String sql = "INSERT INTO GUESTS VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement dataUpdate = conn.prepareStatement(sql);            

            for(int i = 0; i < list.size(); i++)
            {
                dataUpdate.setInt(3, list.getPeople()[i].getResID()); 
                dataUpdate.setString(1, list.getPeople()[i].getFirstName());
                dataUpdate.setString(2, list.getPeople()[i].getLastName());
                dataUpdate.setString(4, list.getPeople()[i].getNationality());
                dataUpdate.setString(5, list.getRoomInfo()[i].getGuestType());
                dataUpdate.setString(6, list.getRoomInfo()[i].getRoomType());
                dataUpdate.setInt(7, list.getRoomInfo()[i].getRoomNum());
                dataUpdate.setInt(8, list.getPeople()[i].getGuestNum());
                dataUpdate.setInt(9, list.getRoomInfo()[i].getRoomLimit());
                dataUpdate.setFloat(10, list.getPeople()[i].getDeposit());
                dataUpdate.setFloat(11, list.getRoomInfo()[i].getTotal());
                dataUpdate.setFloat(12, list.getPeople()[i].getPaid());                
                dataUpdate.setString(13, list.getPeople()[i].getCheckInDate());
                dataUpdate.setString(14, list.getPeople()[i].getCheckOutDate());
                dataUpdate.setString(15, list.getPeople()[i].getPhone());
                dataUpdate.setString(16, list.getPeople()[i].getEmail());  
                dataUpdate.setString(17, list.getRoomInfo()[i].getNote());
             
                dataUpdate.executeUpdate();
                dataUpdate.clearParameters();
            }   

            System.out.println("RECORDS INSERTED");
        
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch(Exception e) {
                
            }
        }
        
    }
    
}
