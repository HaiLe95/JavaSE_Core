package sqlExample;

import java.sql.Driver;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class JDBCExample {

    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;


        try {

            Driver d = (Driver) Class.forName("org.sqlite.JDBC").newInstance();
            DriverManager.registerDriver(d);

            String url = "jdbc:sqlite:C:\\Java\\Databases\\carshop_lesson8\\CarShop.db";
            con = DriverManager.getConnection(url);

            String sql = "SELECT * FROM spr_Model";
            stmt = con.createStatement();

            res = stmt.executeQuery(sql);

            while (res.next()) {
                System.out.println(res.getString("name_en") + " - " + res.getObject("name_ru"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(res != null) res.close();
                if(stmt != null) stmt.close();
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
