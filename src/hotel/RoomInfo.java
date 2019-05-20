/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author trinh
 */
public class RoomInfo {
    private String guestType;
    private String roomType;
    private int roomNum;
    private int roomLimit;
    private float total;
    private String note;
    
    public RoomInfo(String guestType, String roomType, 
            int roomNum, int roomLimit, float total, String note)
    {
        this.guestType = guestType;
        this.roomType = roomType;
        this.roomNum = roomNum;
        this.roomLimit = roomLimit;
        this.total = total;
        this.note = note;
    }
    
    public String getGuestType()
    {
        return guestType;
    }
    
    public String getRoomType()
    {
        return roomType;
    }
    
    public int getRoomNum()
    {
        return roomNum;
    }
    
    public int getRoomLimit()
    {
        return roomLimit;
    }
    
    public float getTotal()
    {
        return total;
    }
    
    public String getNote()
    {
        return note;
    }
    
    public void setGuestType(String guestType)
    {
        this.guestType = guestType;
    }
    
    public void setRoomType(String roomType)
    {
        this.roomType = roomType;
    }
    
    public void setRoomNum(int roomNum)
    {
        this.roomNum = roomNum;
    }
    
    public void setRoomLimit(int roomLimit)
    {
        this.roomLimit = roomLimit;
    }    
    
    public void setTotal(float total)
    {
        this.total = total;
    }
    
    public void setNote(String note)
    {
        this.note = note;
    }

}
