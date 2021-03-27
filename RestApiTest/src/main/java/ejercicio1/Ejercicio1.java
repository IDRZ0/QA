package ejercicio1;

public class Ejercicio1 {
    public static boolean compareJson(String actual, String expected) {
        boolean flag = true;
        String key = "";

        String a1 = actual.replace("{", "");
        String b1 = a1.replace("}", "");
        String a2 = expected.replace("{", "");
        String b2 = a2.replace("}", "");

        String[] c1 = b1.split(",");
        String[] c2 = b2.split(",");

        for (int x = 0; x < c1.length; x++) {
            String[] d1 = c1[x].split(":");
            String[] d2 = c2[x].split(":");
            if (!d1[1].equals(d2[1]) && !d2[1].equals("\"IGNORE\"")) {
                flag = false;
                key = d1[0];
                break;
            }
        }
        if (!flag) {
            System.out.println("Los valores no son iguales en el atributo: " + key);
        }
        return flag;
    }
}
