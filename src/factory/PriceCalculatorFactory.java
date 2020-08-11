package factory;

import calculator.BasePriceCalculator;
import calculator.OnePercentPriceCalculator;
import calculator.PriceCalculator;
import view.View;

public class PriceCalculatorFactory {

	public PriceCalculator getPriceCalculator(View view) {
		if(view.isOnePercentSelected()) {
			return new OnePercentPriceCalculator(view.getBaseTotal(), view.getTvaValue(), view.getQuantity());
		} else {
			return new BasePriceCalculator(view.getBaseTotal(), view.getTvaValue(), view.getQuantity());
		}
	}
	
}
