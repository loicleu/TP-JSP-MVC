import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;
import com.mycompany.tp_jsp.mvc.CodeDiscount;



public class DAO {

	public DataSource myDataSource;

	public DAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}

        public List<CodeDiscount> codes()throws SQLException{
            List<CodeDiscount> listcode = new LinkedList<>();
            String sql = "SELECT * FROM DISCOUNT_CODE ORDER BY DISCOUNT_CODE";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				String code = result.getString("DISCOUNT_CODE");
				float taux = result.getFloat("RATE");
				CodeDiscount c = new CodeDiscount(code,taux);
				listcode.add(c);
			}
		}
		return listcode;
	}
        
        public int ajoutDCode(String code, float taux) throws SQLException{
            int result;
            String sql = "INSERT INTO DISCOUNT_CODE VALUES (?,?)";
            try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1,code);
                stmt.setFloat(2,taux);
                result=stmt.executeUpdate();
                
            }
            return result;
            
            
            
            
            
            
            
            
        }
}









}