package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.ClassNumDao;
import tool.Action;

public class StudentCreateAction extends Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

//    	HttpSession session = request.getSession();
//    	Teacher teacher = (Teacher)session.getAttribute("user");
//
//
//    	ClassNumDao classNumDao = new ClassNumDao();
//    	LocalDate todaysDate = LocalDate.now();

    	 HttpSession session = request.getSession();
         Teacher teacher = (Teacher) session.getAttribute("user");
//         String userSchoolCd = teacher.getSchool().getCd();


         ClassNumDao cNumDao = new ClassNumDao();
         LocalDate todaysDate = LocalDate.now();
         int year = todaysDate.getYear();

         List<Integer> entYearSet = new ArrayList<>();

         for(int i = year -10; i < year + 10; i++){
        	 entYearSet.add(i);
         }


         List<String> list = cNumDao.filter(teacher.getSchool());

//         ClassNumDao classNumDao = new ClassNumDao();
//         List<ClassNum> classList = classNumDao.getBySchoolCd(userSchoolCd);

         request.setAttribute("ent_year_set", entYearSet);
         request.setAttribute("class_num_set", list);
//         request.setAttribute("classList", classList);
         request.getRequestDispatcher("student_create.jsp").forward(request, response);
     }

}
