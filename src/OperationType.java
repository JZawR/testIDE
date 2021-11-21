public class OperationType {
    private static int operation(CheckInput input){
        int x = input.getValues()[0];
        int y = input.getValues()[1];
        switch(input.getOperation()){
            case "+": return x+y;
            case "-": return x-y;
            case "*": return x*y;
            case "/": return x/y;
        }
        return 0;
    }

    public static String calculate(CheckInput checkInput){
        int z = operation(checkInput);
        String result;
        if(checkInput.roma()){
            result = (RomanNumber.parseToRoman((int) z));
        }
        else result = String.valueOf(z);
        return result;
    }

}
