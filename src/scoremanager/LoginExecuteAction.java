//package scoremanager;
//
//import java.util.ArrayList;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import bean.Teacher;
//import dao.TeacherDao;
//import tool.Action;
//
//
//public class LoginExecuteAction extends Action {
//
//	@Override
//	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		try{
//			HttpSession session = request.getSession(false);
//
//
//			if(session != null){
//				session.invalidate();
//				Enumeration<String> attrs = session.getAttributeNames();
//			    while (attrs.hasMoreElements()) {
//			        String name = attrs.nextElement();
//			        Object value = session.getAttribute(name);
//			        System.out.println("SESSION: " + name + " = " + value);
//			    }
//			}
//
//			Map<String, String> errors = new HashMap<>();
//
//
//
//		//ローカル変数の宣言 1
//		String url = "";
//		String id = "";
//		String password = "";
//		TeacherDao teacherDao = new TeacherDao();
//		Teacher teacher = null;
//
//		//リクエストパラメータ―の取得 2
//		id = request.getParameter("id");// 教員ID
//		password = request.getParameter("password");//パスワード
//
//		//DBからデータ取得 3
//		teacher = teacherDao.login(id, password);//教員データ取得
//
//		//ビジネスロジック 4
//		//DBへデータ保存 5
//		//レスポンス値をセット 6
//		//フォワード 7
//		//条件で手順4~7の内容が分岐
//		if (teacher != null) {// 認証成功の場合
//			// セッション情報を取得
//			HttpSession session1 = request.getSession(true);
//			// 認証済みフラグを立てる
//			teacher.setAuthenticated(true);
//			// セッションにログイン情報を保存
//			session1.setAttribute("user", teacher);
//
//			//リダイレクト
//			url = "main/menu.jsp";
//			response.sendRedirect(url);
//		} else {
//			// 認証失敗の場合
//			// エラーメッセージをセット
//			List<String> errors1 = new ArrayList<>();
//			errors1.add("IDまたはパスワードが確認できませんでした");
//			request.setAttribute("errors", errors1);
//			// 入力された教員IDをセット
//			request.setAttribute("id", id);
//
//			//フォワード
//			url = "login.jsp";
//			request.getRequestDispatcher(url).forward(request, response);
//		}
//
////
////		catch (Exception e) {
////            e.printStackTrace();
////            request.setAttribute("errorMessage", "システムエラーが発生しました。");
////            request.getRequestDispatcher("../../error.jsp").forward(request, response);
////        }
//
//		}
//	}
//}
//
//

package scoremanager;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TeacherDao;
import tool.Action;

public class LoginExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            // 旧セッションがあれば内容をログ出力して破棄
            HttpSession session = request.getSession(false);
            if (session != null) {
                Enumeration<String> attrs = session.getAttributeNames();
                while (attrs.hasMoreElements()) {
                    String name = attrs.nextElement();
                    Object value = session.getAttribute(name);
                    System.out.println("SESSION BEFORE INVALIDATE: " + name + " = " + value);
                }
                session.invalidate();
            }

            Map<String, String> errors = new HashMap<>();

            // ローカル変数の宣言
            String url = "";
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            TeacherDao teacherDao = new TeacherDao();
            Teacher teacher = teacherDao.login(id, password);

            // ログイン成功時
            if (teacher != null) {
                HttpSession newSession = request.getSession(true);
                teacher.setAuthenticated(true);
                newSession.setAttribute("user", teacher);

                url = "main/menu.jsp";
                response.sendRedirect(url);

            } else {
                // ログイン失敗時
                List<String> errors1 = new ArrayList<>();
                errors1.add("IDまたはパスワードが確認できませんでした");
                request.setAttribute("errors", errors1);
                request.setAttribute("id", id);

                url = "login.jsp";
                request.getRequestDispatcher(url).forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "システムエラーが発生しました。");
            request.getRequestDispatcher("../../error.jsp").forward(request, response);
        }
    }
}

