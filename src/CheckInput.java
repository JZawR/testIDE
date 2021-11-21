import java.util.Locale;

public class CheckInput {
    private String inputS, s1, s2, operation;
    private boolean roma, end;

    public CheckInput (String inputS){
        this.inputS = inputS;
        String strings[] = inputS.trim().split("[+\\-*/]");
        this.operation = inputS.replaceAll("[\\d,\\w]","").trim();
        //System.out.println(operation);
        if(this.operation.length()>1){
            throw new IllegalArgumentException("Калькулятор не выполняет действия с двумя и более операторами");
        }
        if(!(this.operation.matches("[+\\-*/]"))) {
            throw new IllegalArgumentException("строка не является математической операцией");
        }

        if (strings.length!=2){
            throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        this.s1 = strings[0].trim();
        //System.out.println(s1);
        this.s2 = strings[1].trim();
        //System.out.println(s2);
        setRoma();
        }

    private void setRoma(){
        String arabicRegexp = "[0-9]|10";
        String romeRegexp = "I{0,3}|IV|V?I{0,3}|IX|X";
        s1 = s1.toUpperCase();
        s2 = s2.toUpperCase();
        if ((s1.matches(arabicRegexp)) && s2.matches(arabicRegexp)){
            this.roma = false;
            //System.out.println("Арабские "+!this.roma);
        }
        else if ((s1.matches(romeRegexp)) && s2.matches((romeRegexp))){
            this.roma = true;
            //System.out.println("Римские "+this.roma);
        }
        else if (((s1.matches(arabicRegexp)) && s2.matches((romeRegexp))) || ((s1.matches(romeRegexp)) && s2.matches((arabicRegexp)))) {
            throw new IllegalArgumentException("используются одновременно разные системы счисления");
        }
        else throw new IllegalArgumentException("Введенные данные не являются арабскими или римскими числами в пределах допустимых значений");
    }

    public boolean roma(){
        return roma;
    }

    public int[] getValues(){
        int first = 0;
        int second = 0;
        if(!this.roma){
            first = Integer.parseInt(this.s1);
            second = Integer.parseInt(this.s2);
            //System.out.println("Арабские записались успешно");
        }
        else if (this.roma){
            //System.out.println("Римские пытаются записаться");
            first = RomanNumber.parseToArab(this.s1);
            second = RomanNumber.parseToArab(this.s2);
            //System.out.println("Римские записались успешно");
        }
        int[] result = new int[]{first, second};
        return result;
    }

    public String getOperation(){
        return operation;
    }


}
