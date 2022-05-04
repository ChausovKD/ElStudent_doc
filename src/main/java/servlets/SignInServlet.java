package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Kirill Chausov
 * @version 1.0
 */
public class SignInServlet extends HttpServlet{
    /** Поле сервиса управления аккаунтами */
    private final AccountService accountService;

    /**
     * Конструктор - создание нового объекта
     * @param accountService - сервис управления аккаунтами
     */
    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Метод обрабатывающий doPost запросы
     * @param request - запрос
     * @param response - отклик на запрос
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        String sessionId = request.getSession().getId();
        if (!this.accountService.contains(request.getParameter("login"))) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Unauthorized");
            response.setStatus(401);
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Authorized: " + request.getParameter("login"));
            response.setStatus(200);
        }
    }
}
