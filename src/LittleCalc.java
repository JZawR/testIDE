import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LittleCalc {
    public static void main(String[] args) {
        boolean u = true;
        System.out.println("Введите выражение из целых натуральных арабских или римских чисел ");
        do {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));



            try {
                CheckInput check = new CheckInput(input.readLine());
                System.out.println(OperationType.calculate(check));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while(u == true);

    }
}




