package moneycalculator.persistence;

import java.sql.Statement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseReader {

    private static Connection c;
    private static Statement stmt;

    public static void read() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        setConnection();

        ResultSet rs = stmt.executeQuery("SELECT  FROM ");

        closeConnection(rs);
    }

    private static void closeConnection(ResultSet rs) throws SQLException {
        rs.close();
        stmt.close();
        c.close();
    }

    private static void setConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:ExchangeRatesDB.db");
        stmt = c.createStatement();
    }

    public static boolean search(String object) throws SQLException, ClassNotFoundException {
        setConnection();
        ResultSet rs = stmt.executeQuery("SELECT ID FROM ExchangeRates WHERE ACRONYM='" + object + "'");
        if (rs.next()) {
            if (rs.getInt("ID") < 1) {
                closeConnection(rs);
                return false;
            }
        }
        closeConnection(rs);
        return true;
    }
}
