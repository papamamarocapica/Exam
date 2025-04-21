package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Student;
import dao.SchoolDao;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateExecuteAction extends Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {

            String no = request.getParameter("no");
            String name = request.getParameter("name");
            int entYear = Integer.parseInt(request.getParameter("entYear"));
            String classNum = request.getParameter("classNum");
            boolean isAttend = Boolean.parseBoolean(request.getParameter("isAttend"));
            String schoolCd = request.getParameter("schoolCd");

            SchoolDao schoolDao = new SchoolDao();
            School school = schoolDao.get(schoolCd);

            if (school == null) {
                request.setAttribute("errorMessage", "指定された学校コードは存在しません。");
                request.setAttribute("student", new Student());
                request.getRequestDispatcher("student_update.jsp").forward(request, response);
                return;
            }

            Student student = new Student();
            student.setNo(no);
            student.setName(name);
            student.setEntYear(entYear);
            student.setClassNum(classNum);
            student.setAttend(isAttend);
            student.setSchool(school);

            StudentDao studentDao = new StudentDao();
            boolean success = studentDao.save(student);

            if (success) {
                response.sendRedirect("student_update_done.jsp");
            } else {
                request.setAttribute("errorMessage", "学生情報の更新に失敗しました。");
                request.setAttribute("student", student);
                request.getRequestDispatcher("student_update.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "システムエラーが発生しました。");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
