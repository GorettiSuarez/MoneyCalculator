package moneycalculator.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculator.model.Currency;

public class ShowCurrencyDialog implements CurrencyDialog {
    String acronym,name,symbol;
    @Override
    public Currency get() {
        System.out.println("¿A que divisa quieres cambiar tu moneda?(Introduzca uno a uno los siguientes datos: acronimo, Nombre, símbolo)");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        try {
            acronym = CheckCurrencies.checkAcronym(buffer.readLine());
            name = CheckCurrencies.checkName(buffer.readLine());
            symbol = CheckCurrencies.checkSymbol(buffer.readLine());
        } catch (IOException ex) {
            Logger.getLogger(ShowCurrencyDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ShowCurrencyDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShowCurrencyDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Currency(acronym, name, symbol);
    }

}
