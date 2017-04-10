/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appointments;

import java.sql.Date;

/**
 *
 * @author paul
 */
public class Appointment {
    private String type;
    private Date date;
    private int kms;
    static int totalKms;

    public static int getTotalKms() {
        return totalKms;
    }
    
    public Appointment(String type, Date date, int kms)
    {
     
        this.type = type;
        this.date = date;
        this.kms = kms;
        totalKms += kms;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public int getKms() {
        return kms;
    }
    
    @Override
    public String toString()
    {        
        return type + " appointment on " + date + " distance of " +kms + "kms.";
    }
    
    
    
}
