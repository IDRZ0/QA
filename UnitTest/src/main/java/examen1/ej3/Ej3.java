package examen1.ej3;

public class Ej3 {
    public boolean isCorrectCI(String ci) throws Exception {
        boolean isCorrect;
        if (ci.isEmpty())
            throw new Exception("ci no puede ser vacia");
        if (ci.equals("0"))
            throw new Exception("ci no puede ser 0");
        if (Integer.parseInt(ci) > 0) {
            Thread.sleep(1500);
            isCorrect = true;
        } else {
            isCorrect = false;
        }
        return isCorrect;
    }
}
