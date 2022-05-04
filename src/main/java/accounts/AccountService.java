package accounts;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kirill Chausov
 * @version 1.0
 */
public class AccountService {
    /** Поле карты логин на профиль, отвечает за регестрацию */
    private final Map<String, UserProfile> loginToProfile;
    /** Поле карты сессия на профиль, отвечает за авторизацию */
    private final Map<String, UserProfile> sessionIdToProfile;

    /**
     * Конструктор - создание нового объекта
     */
    public AccountService() {
        loginToProfile = new HashMap<>();
        sessionIdToProfile = new HashMap<>();
    }

    /**
     * Метод добавления нового пользователя {@param UserProfile#userProfile}
     */
    public void addNewUser(UserProfile userProfile) {
        loginToProfile.put(userProfile.getLogin(), userProfile);
    }

    /**
     * Метод получения пользователя по логину {@param UserProfile#login}
     * @return возвращает пользователя
     */
    public UserProfile getUserByLogin(String login) {
        return loginToProfile.get(login);
    }

    /**
     * Метод получения пользователя по сессии {@param UserProfile#sessionId}
     * @return возвращает пользователя
     */
    public UserProfile getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    /**
     * Метод добавления новой сессии
     * @param sessionId
     * @param userProfile
     */
    public void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    /**
     * Метод удаления сессии
     * @param sessionId
     */
    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }

    /**
     * Метод проверяющий содержит ли карта логин на профиль проверяемого пользователя
     * @param login
     * @return возвращает результат проверки
     */
    public boolean contains(String login){
        if(loginToProfile.containsKey(login)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Переопределённый метод вывода строки, представляющей объект
     * @return возвращает строку, представляющую объект
     */
    @Override
    public String toString() {
        return "AccountService{" +
                "loginToProfile=" + loginToProfile +
                ", sessionIdToProfile=" + sessionIdToProfile +
                '}';
    }
}
