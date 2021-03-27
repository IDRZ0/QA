package ejercicio2;

public class CalcularFecha {
    public String calcularSiguiente(int day, String month, int year, int hour, int minute, int second) {
        String message;
        String[] months = months();
        if (day < 1 || day > 31) {
            message = "Invalid day: " + day;
        } else if (month.equals("Febrero") && (day == 30 || day == 31)) {
            message = "Invalid day: " + day;
        } else if (month.equals("Febrero") && day == 29 && year % 4 != 0) {
            message = "Invalid day: " + day;
        } else if (day == 31 && (month.equals("Abril") || month.equals("Junio") || month.equals("Septiembre") || month.equals("Noviembre"))) {
            message = "Invalid day: " + day;
        } else if (!month.equals(months[0]) && !month.equals(months[1]) && !month.equals(months[2]) && !month.equals(months[3])
                && !month.equals(months[4]) && !month.equals(months[5]) && !month.equals(months[6]) && !month.equals(months[7])
                && !month.equals(months[8]) && !month.equals(months[9]) && !month.equals(months[10]) && !month.equals(months[11])) {
            message = "Invalid month: " + month;
        } else if (year < 0) {
            message = "Invalid year: " + year;
        } else if (hour < 0 || hour > 23) {
            message = "Invalid hour: " + hour;
        } else if (minute < 0 || minute > 59) {
            message = "Invalid minute: " + minute;
        } else if (second < 0 || second > 59) {
            message = "Invalid second: " + second;
        } else if (second != 59) {
            int temp = second + 1;
            message = day + " " + month + " " + year + " " + hour + ":" + minute + ":" + temp;
        } else if (minute != 59) {
            int temp = minute + 1;
            message = day + " " + month + " " + year + " " + hour + ":" + temp + ":0";
        } else if (hour != 23) {
            int temp = hour + 1;
            message = day + " " + month + " " + year + " " + temp + ":0:0";
        } else if (day < 28) {
            int temp = day + 1;
            message = temp + " " + month + " " + year + " 0:0:0";
        } else if (day == 28 && month.equals("Febrero")) {
            if (year % 4 != 0) {
                message = "1 Marzo " + year + " 0:0:0";
            } else {
                message = "29 Febrero " + year + " 0:0:0";
            }
        } else if (day == 28) {
            int temp = day + 1;
            message = temp + " " + month + " " + year + " 0:0:0";
        } else if (day == 29 && month.equals("Febrero")) {
            message = "1 Marzo " + year + " 0:0:0";
        } else if (day == 29) {
            int temp = day + 1;
            message = temp + " " + month + " " + year + " 0:0:0";
        } else if (day == 30 && (month.equals("Abril") || month.equals("Junio") || month.equals("Septiembre") || month.equals("Noviembre"))) {
            int temp = 0;
            for (int i = 0; i < months.length; i++) {
                if (months[i].equals(month)) {
                    temp = i + 1;
                }
            }
            message = "1 " + months[temp] + " " + year + " 0:0:0";
        } else if (day == 30) {
            int temp = day + 1;
            message = temp + " " + month + " " + year + " 0:0:0";
        } else if (day == 31 && !month.equals("Diciembre")) {
            int temp = 0;
            for (int i = 0; i < months.length; i++) {
                if (months[i].equals(month)) {
                    temp = i + 1;
                }
            }
            message = "1 " + months[temp] + " " + year + " 0:0:0";
        } else {
            int temp = year + 1;
            message = "1 Enero " + temp + " 0:0:0";
        }
        return message;
    }

    public String[] months() {
        String[] months = new String[12];
        months[0] = "Enero";
        months[1] = "Febrero";
        months[2] = "Marzo";
        months[3] = "Abril";
        months[4] = "Mayo";
        months[5] = "Junio";
        months[6] = "Julio";
        months[7] = "Agosto";
        months[8] = "Septiembre";
        months[9] = "Octubre";
        months[10] = "Noviembre";
        months[11] = "Diciembre";
        return months;
    }
}
