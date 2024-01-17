package Prac_4.Homework;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        try {
            DatabaseManager databaseManager = new DatabaseManager();
            databaseManager.connect();

            databaseManager.createDatabase("SchoolDB");

            databaseManager.useDatabase("SchoolDB");

            databaseManager.createTable("Courses");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}