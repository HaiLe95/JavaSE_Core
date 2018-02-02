package jdbcDEMO;


import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtils {

    private static Connection con;

    public static void openConnection(String path) {
        try {
            Driver driver = (Driver) Class.forName("org.sqlite.JDBC").newInstance();


            String url = "jdbc:sqlite:" + path;

            if (con == null) {
                con = DriverManager.getConnection(url);
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public static ArrayList<SprObject> getResultList(String sql) {

        ArrayList<SprObject> list = new ArrayList<>();

        Statement statement = null;
        ResultSet rs = null;

        try {
            statement = con.createStatement();
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                SprObject obj = new SprObject();
                obj.setId(rs.getInt("id"));
                obj.setName_ru(rs.getString("name_ru"));
                obj.setName_en(rs.getString("name_en"));

                list.add(obj);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
            statement.close();
        } catch (SQLException e) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, e);
        }

        return list;
    }

    public static void closeConnection() {
        try {
            if(con != null) {
                con.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
