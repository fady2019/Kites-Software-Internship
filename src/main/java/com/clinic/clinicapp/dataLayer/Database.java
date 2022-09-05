package com.clinic.clinicapp.dataLayer;

import com.clinic.clinicapp.buisnessLayer.entities.Tool;
import com.clinic.clinicapp.buisnessLayer.entities.ToolCategory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Database implements DataManager {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/clinicApp.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public ArrayList<Tool> getItems(String sql)
    {
        ArrayList<Tool> tools= new ArrayList<>();
        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Tool toolfiltered = new Tool(rs.getString("name")
                        , rs.getLong("label"),
                        LocalDate.parse(rs.getString("expDate"))
                        , rs.getInt("price")
                        , ToolCategory.valueOf(rs.getString("category"))
                        , rs.getInt("quantity")
                        , rs.getString("supplier")
                        , rs.getBoolean("reusable")
                        , rs.getInt("minQuantity"));
                tools.add(toolfiltered);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tools;
    }

    public boolean addTool(Tool tool) {
        String sql = "INSERT INTO Tools(name, label, expDate, price, category, quantity, supplier, reusable, minQuantity) VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tool.getName());
            pstmt.setLong(2, tool.getLabel());
            pstmt.setString(3, String.valueOf(tool.getExpDate()));
            pstmt.setInt(4, tool.getPrice());
            pstmt.setString(5, String.valueOf(tool.getCategory()));
            pstmt.setInt(6, tool.getQuantity());
            pstmt.setString(7, tool.getSupplier());
            pstmt.setBoolean(8, tool.isReusable());
            pstmt.setInt(9, tool.getMinQuantity());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            return false;
        }
    }

    public void removeTool(long label)
    {
        String sql = "DELETE FROM Tools WHERE label = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1,label);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public ArrayList<Tool> filterByCategory(ToolCategory category) {
        String sql = "SELECT * FROM Tools WHERE category = "+ "'"+ String.valueOf(category)+ "'";
        return getItems(sql);
    }

    @Override
    public Tool searchByName(String name) {
        String sql = "SELECT * FROM Tools WHERE name LIKE '%"+name+"%'";
        ArrayList<Tool> searchName = getItems(sql);
        return searchName.size() == 0? null : searchName.get(0);
    }

    @Override
    public ArrayList<Tool> filterByPrice(int start, int end) {
        String sql = "SELECT * FROM Tools WHERE price >= " + start + " AND price <= " + end;
        return getItems(sql);
    }

    public void displayTools() {
        String sql = "SELECT * FROM Tools";

        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + "\t" +
                                rs.getString("label"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
//    public static void createNewTable() {
//        // SQLite connection string
//        String url = "jdbc:sqlite:C://sqlite/clinicApp.db";
//
//        // SQL statement for creating a new table
//
//        String sql = "CREATE TABLE IF NOT EXISTS Tools (\n"
//                + " name text NOT NULL,\n"
//                + " label integer PRIMARY KEY,\n"
//                + " expDate text NOT NULL,\n"
//                + " price integer,\n"
//                + " category text NOT NULL,\n"
//                + " quantity integer,\n"
//                + " supplier text NOT NULL,\n"
//                + " reusable integer,\n"
//                + " minQuantity integer\n"
//                + ");";
//
//        try {
//            Connection conn = DriverManager.getConnection(url);
//            Statement stmt = conn.createStatement();
//            stmt.execute(sql);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    //
//    public static void main(String[] args) {
//
//        Database app = new Database();
////        LocalDate expDate= LocalDate.of(2023, 1, 1);;
////       Tool newTool = new Tool("Needle holder", 1215, expDate, 200,
////                ToolCategory.SURGICAL, 20, "s1", true, 3);
//        // insert three new rows
////        System.out.println(app.addTool(newTool));
//        //app.filterByPrice(100, 250);
////        app.filterByCategory(ToolCategory.SURGICAL);
//        app.displayTools();
//
//        System.out.println("-------------------------");
//        app.delete(96);
//        app.displayTools();
//
//        //createNewTable();
//    }


}