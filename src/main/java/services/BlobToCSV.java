package services;

import Database.DatabaseConnection;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class BlobToCSV {
    public static void main(String args[]){
        try{
            File file=new File("M:\\blob.csv"); // file path name on local disk storage
            FileWriter fos = new FileWriter(file);

            String[] header = {"ID","Text"};
            CSVWriter writer = new CSVWriter(fos);
            writer.writeNext(header);

            DatabaseConnection dbconnection = new DatabaseConnection();
            ResultSet rs = dbconnection.getDescription();
            while(rs.next()){
                String id = rs.getString("id");
                Blob blob = rs.getBlob("description");

                String description = new String(blob.getBytes(1, (int)blob.length()), StandardCharsets.UTF_8);
                String[] row = {id, description};
                writer.writeNext(row);
            }
            fos.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}