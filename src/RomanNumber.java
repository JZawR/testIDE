import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumber {
    I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100);
    private int value;

    RomanNumber(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static List<RomanNumber> reversedRomanNumber(){
        return Arrays.stream(values()).sorted(Comparator.comparing(RomanNumber::getValue).reversed()).collect(Collectors.toList());
    }

    public static String parseToRoman(int number){
        if(number<1) throw new IllegalArgumentException("Результат меньше 1");
        StringBuilder result = new StringBuilder();
        for (RomanNumber RN : reversedRomanNumber()){
            while (number> RN.getValue()-1){
                result.append(RN);
                number -= RN.getValue();
            }
        }
        return result.toString();
    }

    public static int parseToArab(String s){
        if (s.isEmpty()) throw new IllegalArgumentException("Строка пуста");
    int i = 0;
    int result = 0;
        //System.out.println(s);
    while ((s.length()>0) && (i<RomanNumber.values().length))
    if (s.startsWith(String.valueOf(reversedRomanNumber().get(i)))){
        result += reversedRomanNumber().get(i).getValue();
        s = s.substring(String.valueOf(reversedRomanNumber().get(i)).length());
    }
    else i++;
    if (s.length()>0) throw new IllegalArgumentException("Вы ввели что-то очень длинное");
    return result;
    }
}
