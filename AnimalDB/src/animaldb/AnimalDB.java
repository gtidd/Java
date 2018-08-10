package animaldb;

/**
 * @author Greg
 * Java 2 
 * 9/14/2015
 * Paul Stay 
 * Week 4 JDBC
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;

public class AnimalDB {
    //Assigns location and table name to locale variables
    private static String URL = "jdbc:AnimalDB;create=true;user=user;password=password";
    private static String tableName = "animals";
    private static Connection connection = null;
    //setting initial values as they cannot be empty
    private boolean tablesCreated = false;
    private static int nextId = 1;
    
    // Create DB connection 
    private static void createConn() {
        try {
            // Loads the EmbeddedDriver for use on a personal level instead of server side 
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
           
            connection = DriverManager.getConnection(URL);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    // Increment Animal starting at id 1
    private void incId(){
        this.nextId++;
    }
    
    //creats animal table with all fields followed your example
    private void createTable(){
        Statement statement = null;
        try {
            StringBuilder strBuild = new StringBuilder("");
            strBuild.append("CREATE table Animals (\n");
                strBuild.append("ID    INT,\n");
                strBuild.append("Name varchar(30),\n");
                strBuild.append("Type varchar(30),\n");
                strBuild.append("Age INTEGER,\n");
                strBuild.append("Color varchar(30),\n");
                strBuild.append("Length in Zoo varchar(2)\n");
            strBuild.append(")\n");
            
            statement = connection.createStatement();
            statement.executeUpdate(strBuild.toString());
            tablesCreated = true;
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch(Exception e){
                    System.err.println(e.getMessage());
                    System.exit(0); 
                }
            }
        }
    }

    private void createAnimal(String name, String type, int age,String color, String lengthInZoo ){
        PreparedStatement preStatement = null;
        try {
            // The question ,marks represent variables for inserting the data
            String sql = "Insert into Animals values (?,?,?,?,?,?)";
            preStatement = connection.prepareStatement(sql);
            // Add the information to the statements
            preStatement.setInt(1, nextId);
            preStatement.setString(2, name);
            preStatement.setString(3,type);
            preStatement.setInt(4, age);
            preStatement.setString(5,color);
            preStatement.setString(6, lengthInZoo);
            
            preStatement.executeUpdate();
            preStatement.close();
            incId(); //Increment for new Animal ID
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    // Close just like a buffered file reader always close to free up resources
    private static void closeConnection() {
        try {
            // Close the connection
            if(connection != null){
                connection.close();
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
   
    public static void pullAnimals(){
        String query = "select * from Animals";
        try {
            Statement stmt = connection.createStatement();
            ResultSet set = stmt.executeQuery(query);
            
            double avgAge = 0;
            int count = 0;
            
            while(set.next()){
                StringBuilder strBuilder = new StringBuilder();
                strBuilder.append("Id : " + set.getInt("ID"));
                strBuilder.append(" Name : " + set.getString("Name"));
                strBuilder.append(" Type : " + set.getString("Type"));
                int age = set.getInt("AGE");
                avgAge += age;
                count++;
                strBuilder.append(" Age " + age );
                strBuilder.append(" Length in zoo : " + set.getString("LENGTHINZOO"));
                System.out.println(strBuilder.toString());
            }
            System.out.println("Average is " + (avgAge/count));
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String args[]){
        // Calls the class for the connection
        createConn();
        // creates a new AnimalDB object
        AnimalDB db = new AnimalDB();
 
        db.createTable();

        // Add some data to the table
        db.createAnimal("Timone", "Meerkat", 7, "Tan" ,"8 years");
        db.createAnimal("Pumba", "Warthog", 5,"Brown","10 years");
        db.createAnimal("Rafiki", "Monkey", 102,"Multi","50 years");
        db.createAnimal("Simba", "Lion", 2,"Yellow", "3 years");
        
        // Query the database table and calculate the average age.
        db.pullAnimals();
        
        // Close the connection
        closeConnection();
    }
}
