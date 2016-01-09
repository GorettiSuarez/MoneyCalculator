package moneycalculator.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;

public class ShowMoneyDialog implements MoneyDialog {

    int valor;
    Currency divisa;
    String acronym, name, symbol;

    @Override
    public Money get() {
        System.out.println("¿Qué moneda desea cambiar? (Introduzca uno a uno los siguientes datos: valor, acronimo, Nombre, símbolo)");
        BufferedReader money = new BufferedReader(new InputStreamReader(System.in));
        try {
            valor = checkValue(Integer.parseInt(money.readLine()), money);
            acronym = CheckCurrencies.checkAcronym(money.readLine());
            name = CheckCurrencies.checkName(money.readLine());
            symbol = CheckCurrencies.checkSymbol(money.readLine());
            divisa = new Currency(acronym, name, symbol);
        } catch (IOException ex) {
            Logger.getLogger(ShowMoneyDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Money(valor, divisa);
    }

    private int checkValue(int valor, BufferedReader money) throws IOException {
        if (valor <= 0) {
            System.out.println("Por favor introduzca un valor positivo");
            int valor2 = Integer.parseInt(money.readLine());
            valor = checkValue(valor2, money);
        }
        return valor;
    }
}
