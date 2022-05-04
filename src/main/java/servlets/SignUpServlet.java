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
public class SignUpServlet extends HttpServlet {
    /** Поле сервиса управления аккаунтами */
    private final AccountService accountService;

    /**
     * Конструктор - создание нового объекта
     * @param accountService - сервис управления аккаунтами
     */
    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Метод обрабатывающий doPost запросы
     * @param request - запрос
     * @param response - отклик на запрос
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login == null || password == null) { // проверка запроса на пустоту полей параметров
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        if(accountService.getUserByLogin(login) == null){
            UserProfile userProfile = new UserProfile(login);
            accountService.addNewUser(userProfile);
            accountService.addSession(request.getSession().getId(), userProfile);
        }

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
