import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
	
		
		//Nome do usuário do mysql
		   private static final String USERNAME = "root";
		 
		   //Senha do mysql
		   private static final String PASSWORD = "Cr485507!";
		 
		   //Dados de caminho, porta e nome da base de dados que irá ser feita a conexão
		   private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/site"; 
		     

	
		   public static Connection createConnectionToMySQL() throws Exception{  
		 
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   
		      Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		 
		      return connection;
		      
		   }
		
		   

}


