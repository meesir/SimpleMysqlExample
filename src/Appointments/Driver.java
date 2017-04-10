package Appointments;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author paul
 */
public class Driver {
    
    //Database Credentials
    String dbUserName = "username";
    String dbPassword = "secretpassword";

    
    public static void main(String[] args) {
        // TODO code application logic here
        Driver go = new Driver();
        go.start();
        
     
    }
 
    public void start() 
    {
        //Create list to hold appointments
       ArrayList<Appointment> list = new ArrayList<Appointment>();  
   
   try{
      //Get connection and query Database
      Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance?autoReconnect=true&useSSL=false", dbUserName,dbPassword);
      Statement myStmt = myConn.createStatement();      
      ResultSet rs = myStmt.executeQuery("SELECT * FROM appointment ORDER BY date");

            
      while(rs.next())
      {       
       //Create Object and Add to list
          Appointment app = new Appointment(rs.getString("type"), rs.getDate("date"),rs.getInt("kms"));
          list.add(app);               
      }
      //Close Connection
      rs.close();

   
   }catch(Exception e){
      //Handle errors 
      e.printStackTrace();     
    }
   
   //Variable to calculate distance traveled for all appointments
   int totalDistance = Appointment.getTotalKms();
 
        //Loop through list and display data
        for (Appointment a: list)
        {
            System.out.println(a.toString());
            //System.out.println(a.getType() + " appointment on " + a.getDate() + " distance of " + a.getKms() + "kms.");  -- Used before toString function was overridden    
        }
        
        //Output total distance and dollar amount at $0.30 / km  (Total distance is stored as a static variable in the Appointment Object)
        System.out.printf("Total distance traveled: %d Kilometers - ", totalDistance);
        System.out.printf("At 30 cents per KM that would equate to %.2f \n", totalDistance * 0.3);  
    } 
}

