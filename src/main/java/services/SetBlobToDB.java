package services;

import Database.DatabaseConnection;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SetBlobToDB {
    public static void main(String args[]){
        try{
            DatabaseConnection dbconnection = new DatabaseConnection();

            String stringData="this is the final new string";
            dbconnection.insertBlobToDB(stringData);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
