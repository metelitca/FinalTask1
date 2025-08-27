import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inputStream = new Scanner(System.in);

        double rate = 0, amount = 0;

        while(true){
            System.out.println("Введите текущий курс доллара:");
            rate = convertToDouble(inputStream.nextLine());

            if(rate > 0)
                break;

            System.out.println("Курс валют не может быть меньше 0.");
        }

        System.out.println("Введите количество рублей для конвертации:");
        amount = convertToDouble(inputStream.nextLine());

        if(amount <=0){
            System.out.println("Возвращайтесь когда у вас появятся рубли.");
            return;
        }

        double result = Math.round((amount/rate) * 100.0) / 100.0;
        String dollarForm = getDollarForm(result);

        System.out.println("Итого:" + result + dollarForm);
    }

    private static double convertToDouble(String line){
        return Double.parseDouble(line.replace(',','.'));
    }

    private static String getDollarForm(double result){
        int mainPart = (int)result;
        int lastNumero = mainPart % 10;
        int secondLastNumero = (mainPart / 10) % 10;

        if(secondLastNumero != 1 && lastNumero == 1)
            return " доллар.";
        else if ((lastNumero >= 2 && lastNumero <=4) && secondLastNumero != 1)
            return " доллара.";
        else
            return " долларов.";
    }
}