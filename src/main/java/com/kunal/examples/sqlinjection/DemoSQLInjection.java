package com.kunal.examples.sqlinjection;

import java.sql.*;
class DemoSQLInjection
{

    public static final String INTENDED_GET_ALL = "select * from accounts";

    public static void main(String args[]){
        try{
            Connection con = getConnection();
            //here trainings is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(INTENDED_GET_ALL);

            String name  = "Bheem";

            String sqlInjectionString  = "abc' or '1' = '1";

            //final String VULNERABLE_QUERY = "select * from accounts where  name = '" + name + "'";
            final String VULNERABLE_QUERY = "select * from accounts where  name = '" + name + "'";

            iterateResultset(rs);
            System.out.println("=======================Seperator======================================");
            Statement stmt2=con.createStatement();
            ResultSet rs2 =stmt2.executeQuery(VULNERABLE_QUERY);
            iterateResultset(rs2);
            System.out.println("=======================Seperator======================================");
            safeIterate("Bheem");
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    private static void iterateResultset(ResultSet rs) throws SQLException {
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+ rs.getString(2)+"  "+ rs.getString(3));
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/trainings?useSSL=false","root","kunal");
        return con;
    }


    /*
    Resolution
     */
    public static void safeIterate(String name)
            throws Exception {

        String sql = "select * from accounts where name = ?";

        Connection c = getConnection();
        PreparedStatement p = c.prepareStatement(sql);
        p.setString(1, name);
        ResultSet rs = p.executeQuery();
        iterateResultset(rs);
    }
}  