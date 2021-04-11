package erp_jsp_exam.ds;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JndiDs {
private static DataSource ds;
	
	private JndiDs() {}
	
	static {
		try {
			InitialContext ic = new InitialContext(); //1.JNDC ���� ��ü ����
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/erp_jsp_exam"); //2.lookup()
			System.out.println("ds : "+ ds);
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
