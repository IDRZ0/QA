package ejercicio1;

public class CalcularNota {
    public String notaFinal(int nota1, int nota2, int nota3) {
        String message;
        if (nota1 < 0 || nota1 > 100 || nota2 < 0 || nota2 > 100 || nota3 < 0 || nota3 > 100) {
            message = "*** INGRESE DATOS CORRECTOS ***";
        } else {
            int result = (nota1 + nota2 + nota3) / 3;
            if (result >= 90 && result <= 100) {
                message = "Excelente su nota es : " + result;
            } else if (result >= 80 && result < 90) {
                message = "Muy Bien su nota es : " + result;
            } else if (result >= 71 && result < 80) {
                message = "Bien su nota es : " + result;
            } else {
                message = "Esfuerzate mas, su nota es : " + result;
            }
        }
        return message;
    }
}
