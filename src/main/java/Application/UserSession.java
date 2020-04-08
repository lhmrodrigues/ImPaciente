package Application;

import Domain.Model.Users.User;

public class UserSession {
    private static UserSession INSTANCE = null;
    private User userLogado;

    private UserSession() {
    }

    public static UserSession getInstance() {
        if (INSTANCE == null)
            INSTANCE = new UserSession();

        return INSTANCE;

    }

    public User getUsuarioLogado() {
        return userLogado;
    }

    public void setUserLogado(User user) {
        userLogado = user;
    }
}
