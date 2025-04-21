//package scoremanager;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import bean.Teacher;
//import dao.TeacherDao;
//import tool.Action;
//
//public abstract class LoginActionn extends Action{
//
//	public String execut(
//			HttpServletRequest request, HttpServletResponse response)
//	throws Exception{
//		HttpSession session = request.getSession();
//
//	String login=request.getParameter("login");
//	String password=request.getParameter("passwprd");
//
//	TeacherDao dao=new TeacherDao();
//	Teacher teacher=dao.search(login, password);
//
//	if(teacher!=null){
//		session.setAttribute("teacher",teacher );
//		return "LoginExecuteAction.jsp";
//	}
//
//	return "/error.jsp";
//
//	}
//}
