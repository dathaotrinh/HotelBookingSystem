/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.io.*;
import java.util.*;

/**
 *
 * @author trinh
 */
public class FullList {
    private final People[] peopleList;
    private final RoomInfo[] roomList;
    private int count;
    
    public FullList(File inFile) throws FileNotFoundException
    {
        peopleList = new People[10000];
        roomList = new RoomInfo[10000];
        count = 0;
        loadData(inFile);
    }
    
    private void loadData(File inFile) throws FileNotFoundException
    {
        // read file
        Scanner fileReader = new Scanner(inFile);
        
        // load data to array
        while(fileReader.hasNextLine())
        {            
            // read each line and use split method 
            // to separate each element
            String tokens[] = fileReader.nextLine().split(",");
            
            // initialize temporary variables to store data

            String firstName = tokens[0];
            String lastName = tokens[1];           
            int resID = Integer.valueOf(tokens[2]);
            String nationality = tokens[3];
            
            String guestType = tokens[4];
            String roomType = tokens[5];
            
            int roomNum = Integer.parseInt(tokens[6]);
            int guestNum = Integer.parseInt(tokens[7]);
            int roomLimit = Integer.parseInt(tokens[8]);            
            float deposit = Float.parseFloat(tokens[9]);
            
            float total = Float.parseFloat(tokens[10]);
            float paid = Float.parseFloat(tokens[11]);
            
            String checkInDate = tokens[12];
            String checkOutDate = tokens[13];            
            String phone = tokens[14];
            String email = tokens[15]; 
            String note = tokens[16];
            
            // load data into objects
            peopleList[count] = new People(resID, firstName, lastName, nationality, phone, email, guestNum, deposit, paid, checkInDate, checkOutDate);
         
            roomList[count] = new RoomInfo(guestType, roomType, roomNum, roomLimit, total, note);
            
            // increment count by 1
            count++;            
        }
    }
    
    public int size()
    {
        return count;
    }
    
    public People[] getPeople()
    {
        return peopleList;
    }
    
    public RoomInfo[] getRoomInfo()
    {
        return roomList;
    }
    
    
}
