package main;

import accounts.AccountService;
import accounts.UserProfile;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignInServlet;
import servlets.SignUpServlet;

/**
 * @author Kirill Chausov
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        /** Создание сервиса работы с аккаунтами */
        AccountService accountService = new AccountService();
        /** Создание тестового пользователя и администратора */
        accountService.addNewUser(new UserProfile("admin"));
        accountService.addNewUser(new UserProfile("test"));

        /** Создание обработчика контекста сервлета */
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        /** Закладываем контекст, который слушает сервлет для отправки ресурсов */
        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");
        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");

        /** Создание объекта класса-обработчика шаблонов и страниц */
        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        /** Создание сервера на тестовом порту 8081 */
        Server server = new Server(8081);

        /** Задание серверу шаблона */
        server.setHandler(handlers);
        /** Запуск сервера */
        server.start();
        /** Логирование запуска сервера */
        java.util.logging.Logger.getGlobal().info("Server started");
        /** Не выходим из класса Main, а просоединяем его к Jetty */
        server.join();
    }
}
