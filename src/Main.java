import  java.sql.*;

public class Main {
    private static final String url="jdbc:mysql://localhost:3306/student";
    private  static  final  String username="root";
    private static final String password="ket@n";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement= connection.createStatement();
            String query= "select *from stu_info";
            ResultSet resultSet= statement.executeQuery(query);

            while (resultSet.next()){
                int id= resultSet.getInt("tId");
                String name= resultSet.getString("tName");
                String city= resultSet.getString("tCity");

                System.out.println("ID:"+id+" Name:" + name+" City :"+city);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}