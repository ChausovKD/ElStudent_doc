package accounts;

/**
 * @author Kirill Chausov
 * @version 1.0
 */
public class UserProfile {
    /** Поле логин */
    private final String login;
    /** Поле пароль */
    private final String pass;
    /** Поле адрес почты */
    private final String email;

    /**
     * Конструктор - создание нового объекта
     * @param login - логин пользователя
     * @param pass - пароль пользователя
     * @param email - адрес почты пользователя
     * @see UserProfile#UserProfile(String)
     */
    public UserProfile(String login, String pass, String email) {
        this.login = login;
        this.pass = pass;
        this.email = email;
    }

    /**
     * Конструктор - создание нового объекта
     * @param login - логин пользователя
     * @see UserProfile#UserProfile(String)
     */
    public UserProfile(String login) {
        this.login = login;
        this.pass = login;
        this.email = login;
    }

    /**
     * Метод получения значения поля {@link UserProfile#login}
     * @return возвращает логин производителя
     */
    public String getLogin() {
        return login;
    }

    /**
     * Метод получения значения поля {@link UserProfile#pass}
     * @return возвращает пароль производителя
     */
    public String getPass() {
        return pass;
    }

    /**
     * Метод получения значения поля {@link UserProfile#email}
     * @return возвращает почтовый адрес производителя
     */
    public String getEmail() {
        return email;
    }
}
