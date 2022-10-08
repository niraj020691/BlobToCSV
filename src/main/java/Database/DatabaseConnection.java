package Database;

import java.sql.*;

public class DatabaseConnection {

        protected Connection connection;

        public DatabaseConnection() throws SQLException, ClassNotFoundException {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + "sms", "root", "faltugiri");

        }

        public ResultSet getDescription() throws SQLException {
            PreparedStatement psmt=connection.prepareStatement("select id, description from blob_test");
            ResultSet rs=psmt.executeQuery();
            return rs;
        }

    public void insertBlobToDB(String s) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO blob_test (id,description) VALUES (2,?);");
        Blob blob = connection.createBlob();
        blob.setBytes(1, s.getBytes());
        ps.setBlob(1, blob);
        ps.executeUpdate();
    }
}
