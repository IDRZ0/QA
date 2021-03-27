package examen1.ej4;

public class Ej4 {
    Util2 util2 = new Util2();
    Util util = new Util();
    String message;

    public Ej4(Util util, Util2 util2) {
        this.util = util;
        this.util2 = util2;
    }

    public String roleUser(String user, String pwd) {
        if (util2.isUserValid(user, pwd)) {
            message = "PERMISSION ROLE " + util.getPermision(user, pwd);
        } else {
            message = "Incorrect USER and PWD";
        }

        return message;
    }
}
