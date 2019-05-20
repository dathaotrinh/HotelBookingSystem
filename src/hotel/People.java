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
public class People {
    private int resID;
    private String firstName;
    private String lastName;
    private String nationality;
    private String phone;
    private String email;
    private int guestNum;
    private float deposit;
    private float paid;    
    private String checkInDate;
    private String checkOutDate;
    
    
    public People()
    {
        
    }
    
    public People(int resID, String firstName, String lastName, 
            String nationality, String phone, 
            String email, int guestNum, float deposit, float paid, String checkInDate, String checkOutDate)
    {
        this.resID = resID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.phone = phone;
        this.email = email;
        this.guestNum = guestNum;
        this.deposit = deposit;
        this.paid = paid;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;        
    }
    
    public int getResID()
    {
        return resID;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getNationality()
    {
        return nationality;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public int getGuestNum()
    {
        return guestNum;
    }
    
    public float getDeposit()
    {
        return deposit;
    }

    public float getPaid()
    {
        return paid;
    }
    
    public String getCheckInDate()
    {
        return checkInDate;
    }
    
    public String getCheckOutDate()
    {
        return checkOutDate;
    }
    
    public void setResID(int resID)
    {
        this.resID = resID;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    public void setGuestNum(int guestNum)
    {
        this.guestNum = guestNum;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void setDeposit(int deposit)
    {
        this.deposit = deposit;
    } 
    
    public void setPaid(float paid)
    {
        this.paid = paid;
    }
    
    public void setCheckInDate(String checkInDate)
    {
        this.checkInDate = checkInDate;
    }
    
    public void setCheckOutDate(String checkOutDate)
    {
        this.checkOutDate = checkOutDate;
    }    
    
    
}
