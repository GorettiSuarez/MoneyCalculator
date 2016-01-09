package moneycalculator.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculator.model.Currency;
import moneycalculator.ui.CurrencyDialog;

public class ShowCurrencyDialog implements CurrencyDialog {

    @Override
    public Currency get() {
        System.out.println("¿A que divisa quieres cambiar tu moneda?(Introduzca uno a uno los siguientes datos: acronimo, Nombre, símbolo)");
        BufferedReader currency = new BufferedReader(new InputStreamReader(System.in));
        String acronimo="",nombre="",simbolo="";
        try {
            acronimo = currency.readLine();
            nombre=currency.readLine();
            simbolo=currency.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ShowCurrencyDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Currency(acronimo, nombre, simbolo);
    }

}
