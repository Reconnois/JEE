import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author guillaumequirin
 */
public class Bdd {
    
    private Connection conn = null;
    private Statement statement = null;
    
    public Bdd(){
        //Connexion à la BDD
        try{		
            Class.forName("com.mysql.jdbc.Driver");
            try{
                this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee", "root","root");
                this.statement = conn.createStatement();
            }
            catch (SQLException e) {
                //out.println(e);
            }
        }
        catch (ClassNotFoundException e) {
            //out.println(e);
        }
    }
    
    public ResultSet get(String query) throws SQLException{
        //SELECT
        try{
            ResultSet result = this.statement.executeQuery(query);
            return result;
        }
        catch(SQLException e){
            System.out.println("Erreur SELECT");
            System.out.println(query);
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public Boolean edit(String query){
        //INSERT - UPDATE - DELETE
        try{
            //Edition de la BDD
            this.statement.executeUpdate(query);
            return true;
        }
        catch (SQLException e) {
            System.out.println("Erreur EDIT");
            System.out.println(query);
            System.out.println(e.getMessage());
        } 
        return false;
    }
}
