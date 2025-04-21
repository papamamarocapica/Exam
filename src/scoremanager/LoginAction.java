package scoremanager;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import tool.Action;

public class LoginAction extends Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try(Connection con = new Dao().getConnection()){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();

		}

	}

}
