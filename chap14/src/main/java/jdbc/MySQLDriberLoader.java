<<<<<<< HEAD
package jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class MySQLDriberLoader extends HttpServlet{
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
=======
package jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class MySQLDriberLoader extends HttpServlet{
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
>>>>>>> 99e7bea7606fc2356ada7b8d913cf2ed31d101fb
