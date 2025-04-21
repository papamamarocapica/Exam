
package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateAction extends Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String no = request.getParameter("no");

        StudentDao studentDao = new StudentDao();
        Student student = studentDao.get(no);

        if (student != null) {
            request.setAttribute("student", student);
            request.getRequestDispatcher("student_update.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "指定された学生は見つかりませんでした。");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
