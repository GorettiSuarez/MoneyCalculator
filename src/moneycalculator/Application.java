package moneycalculator;

import moneycalculator.control.ExchangeCommand;
import moneycalculator.persistence.MockExchangeRateReader;
import moneycalculator.ui.ShowCurrencyDialog;
import moneycalculator.ui.ShowMoneyDialog;
import moneycalculator.ui.ShowMoneyDisplay;

public class Application {

    public static void main(String[] args) {
        ExchangeCommand exchangeCommand = new ExchangeCommand(
                new ShowMoneyDialog(),
                new ShowCurrencyDialog(),
                new MockExchangeRateReader(), 
                new ShowMoneyDisplay()
        );
        exchangeCommand.execute();
                
    }
    
}
