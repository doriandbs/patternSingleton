package patternSingleton;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {

        /*for (int i = 1; i < 5; i++) {
            *//*Singleton sn = Singleton.getInstance();
            sn.doSomething("Task 1" + i);*//*
        }*/
        try {
            Database db = Database.getInstance();
            db.connect();
            ResultSet result = db.query("SELECT FROM");
            while (result.next()) {
                System.out.println(result.getString("nom"));
            }
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
