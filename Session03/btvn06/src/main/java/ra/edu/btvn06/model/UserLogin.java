package ra.edu.btvn06.model;

public class UserLogin {
    private boolean isLogin;

    public UserLogin() {
        this.isLogin = false;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
