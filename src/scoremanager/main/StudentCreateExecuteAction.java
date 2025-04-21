package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import tool.Action;

public class StudentCreateExecuteAction extends Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	HttpSession session = request.getSession();
    	Teacher teacher = (Teacher)session.getAttribute("user");

    	StudentDao sDao = new StudentDao();

        try {
            String no = request.getParameter("f2");
            String name = request.getParameter("f3");
            int entYear = Integer.parseInt(request.getParameter("f1"));
            String classNum = request.getParameter("f4");
            boolean isAttend = true; // Boolean.parseBoolean(request.getParameter("isAttend"));
//            String schoolCd = request.getParameter("schoolCd");
            School school = teacher.getSchool();


//            if (school == null) {
//                request.setAttribute("errorMessage", "指定された学校コードは存在しません。");
//                request.getRequestDispatcher("student_create.jsp").forward(request, response);
//                return;
//            }

            Student student = new Student();
            student.setNo(no);
            student.setName(name);
            student.setEntYear(entYear);
            student.setClassNum(classNum);
            student.setAttend(isAttend);
            student.setSchool(school);

//            StudentDao studentDao = new StudentDao();
            boolean save = sDao.save(student);

            if (save) {
            	request.setAttribute("class_num", save);
            	request.getRequestDispatcher("student_create_done.jsp").forward(request, response);
//                response.sendRedirect("student_create_done.jsp");
            } else {
                request.setAttribute("errorMessage", "登録に失敗しました。");
                request.getRequestDispatcher("student_create.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "システムエラーが発生しました。");
            request.getRequestDispatcher("../../error.jsp").forward(request, response);
        }
    }
}
