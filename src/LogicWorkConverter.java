import java.util.List;
import java.util.Scanner;

public class LogicWorkConverter {

    private List<ValueCurs> mValueCurs;
    private ParseXmlCurrency mParseXmlCurrency;
    private String valuteName;

    // Валюта которую меняют.
    private String valueCurs;
    private int nominalValute;

    private String finalValueCurs;
    private int finalNominalValute;

    private double valueSumChange = 0;

    // Значение курсов валют в формате double
    private double valueCursDouble = 0;
    private double finalValueCursDouble = 0;

    public LogicWorkConverter(ParseXmlCurrency pxc){
        mParseXmlCurrency = pxc;
        mValueCurs = mParseXmlCurrency.getValueCurs();
    }

    public void calculateCurrency(){
        boolean exit = true;
        double finalSum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму для размена");
        valueSumChange = scanner.nextDouble();

        System.out.println("Выберите исходную валюту валюту");

        valuteName = scanner.next();

        while(exit){

            for(ValueCurs curs : mValueCurs){
                if(valuteName.equals(curs.getCode())){
                    System.out.println("Вы выбрали исходную валюту " + curs.getNameValRus());
                    valueCurs = curs.getValue();
                    nominalValute = curs.getNominalVal();
                    break;
                }

            }

            System.out.println("Выберите конечную валюту ");
            valuteName = scanner.next();
            for(ValueCurs curs : mValueCurs){
                if(valuteName.equals(curs.getCode())){
                    System.out.println("Вы выбрали конечную валюту " + curs.getNameValRus());
                    finalValueCurs = curs.getValue();
                    finalNominalValute = curs.getNominalVal();
                    finalSum = calculateSum();
                }
            }
            System.out.println("Итого сумма размена состовляет " + finalSum);
            System.out.println("Вы закончили? " + "\n" + "Для выхода нажмите 0 " + "\n" + "Чтобы продолжить работу нажмите 1" );
            int ex = scanner.nextInt();
            if(ex == 0){
                break;
            }
            else{
                System.out.println("Выберите валюту");
                valuteName = scanner.next();
            }
        }
    }

    private double calculateSum(){
        double sum = 0;

        parseValueToDouble();

        if(nominalValute == finalNominalValute){
            sum = (valueSumChange * valueCursDouble) / finalValueCursDouble;
        }
        else if(nominalValute < finalNominalValute){
            sum = (valueSumChange * valueCursDouble) / (finalValueCursDouble/ finalNominalValute);
        }
        else if(nominalValute > finalNominalValute){
            sum = ((valueCursDouble / 100) * 1000) / (finalValueCursDouble);
        }

        return sum;
    }

    private void parseValueToDouble(){
        String newStrValue = "";
        String newStrFinalValue = "";
        int i = 0;
        while (i < valueCurs.length()){
            if(valueCurs.charAt(i) == ','){
                newStrValue = newStrValue + ".";
            }
            else{
                newStrValue = newStrValue + valueCurs.charAt(i);
            }
            i++;
        }

        valueCursDouble = Double.parseDouble(newStrValue);
        i = 0;

        while (i < finalValueCurs.length()){
            if(finalValueCurs.charAt(i) == ','){
                newStrFinalValue = newStrFinalValue + '.';
            }
            else {
                newStrFinalValue = newStrFinalValue + finalValueCurs.charAt(i);
            }
            i++;
        }

        finalValueCursDouble = Double.parseDouble(newStrFinalValue);
    }

}
