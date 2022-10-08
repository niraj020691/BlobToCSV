package services;

import Database.DatabaseConnection;

import java.sql.*;
import java.time.Instant;

public class SetBlobToDB {
    public static void main(String args[]){
        try{
            DatabaseConnection dbconnection = new DatabaseConnection();

            Timestamp time = Timestamp.from(Instant.now());
            String stringData="This string inserted at "+time ;
            dbconnection.insertBlobToDB(stringData);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
