package examen1.ej2;

public class Ej2 {
    String message;

    public String notasCualitativas(int notaFinal) {
        if (notaFinal < 0 || notaFinal > 10)
            message = "VALOR INCORRECTO";
        if (notaFinal > 0 && notaFinal <= 5)
            message = "F";
        if (notaFinal > 5 && notaFinal <= 7)
            message = "C";
        if (notaFinal > 7 && notaFinal <= 9)
            message = "B";
        if (notaFinal > 9 && notaFinal <= 10)
            message = "A";
        return message;
    }
}
