package ru.geekbrains.java_three.Lesson_2.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psAdd;

    public static void main(String[] args) {
        try {
            connect();
            createTableEx();

            readFile();
            printData();
//            dropTableEx();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // метод создания таблицы
    private static void createTableEx() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Products (\n" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "Title  TEXT, Cost INTEGER);");
    }
    //метод для добавления записи
    private static void insertEx(String title, int cost) throws SQLException {
        psAdd = connection.prepareStatement("INSERT INTO Products (Title, Cost) VALUES (?, ?)");
        psAdd.setString(1, title);
        psAdd.setInt(2, cost);
        psAdd.addBatch();
        psAdd.executeBatch();
    }
    //метод для удаления записи
    private static void deleteOneEntryEx() throws SQLException {
        stmt.executeUpdate("DELETE FROM Products WHERE id = 5;");
    }
    //удаление таблицы
    private static void dropTableEx() throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS Products;");
    }
    // изменяем запись таблицы
    private static void updateEx() throws SQLException {
        System.out.println("изменяем...");
        Scanner scanner = new Scanner(System.in);
        String cost = scanner.nextLine();
        String id = scanner.nextLine();
        String sql = String.format("UPDATE Products SET cost = '%s' WHERE id = '%s';", cost, id);
        stmt.executeUpdate(sql);
    }

    public static void readFile() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("d:\\test.txt");
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()) {
            String[] str = scanner.nextLine().split(" ");
            try {
//                insertEx(str[1], Integer.parseInt(str[2]));
                updateData(str[0], str[1], str[2]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateData(String id, String Title, String cost) throws SQLException {
        System.out.println(Title + " " + cost + " " + id);
        String sql = String.format("UPDATE Products SET Title = '%s', cost = %s where id = %s", Title, cost, id);
        System.out.println(sql);
        stmt.executeUpdate(sql);
    }
    public static void printData() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM Products;");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString("title") + " " + rs.getInt("cost"));
        }
    }
}
