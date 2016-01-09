package moneycalculator.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckCurrencies {

    public static String checkAcronym(String acronym) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        if (!acronym.equals("EUR")){
            System.out.println("Por favor introduzca un acronimo válido:");
            String acronym2 = buffer.readLine();
            acronym = checkAcronym(acronym2);
        }
        return acronym;
    }
    public static String checkName(String name) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        if (!name.equals("euro")){
            System.out.println("Por favor introduzca un nombre válido:");
            String name2 = buffer.readLine();
            name = checkName(name2);
        }
        return name;
    }
    public static String checkSymbol(String symbol) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        if (!symbol.equals("$")){
            System.out.println("Por favor introduzca un símbolo válido:");
            String symbol2 = buffer.readLine();
            symbol = checkSymbol(symbol2);
        }
        return symbol;
    }
}
