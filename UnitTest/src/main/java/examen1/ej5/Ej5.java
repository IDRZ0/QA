package examen1.ej5;

public class Ej5 {
    private String message;

    public Ej5() {
    }

    public String saveInNewMoney(int amount, String monedaOriginal, String monedaDestino) {
        if (amount > 0) {
            message = "La cantidad convertida fue : [" + (amount * Util.obtenerTipoDeCambio(monedaOriginal, monedaDestino)) + "] " + monedaDestino;
        } else {
            message = "Cantidad incorrecta";
        }
        return message;
    }
}
