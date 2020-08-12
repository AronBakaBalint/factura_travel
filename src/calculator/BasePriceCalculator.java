package calculator;

public class BasePriceCalculator extends PriceCalculator{

	
	public BasePriceCalculator(Float pretTotal, Float tva, Integer quantity) {
		super(pretTotal, tva, quantity);
	}

	@Override
	public String getUnitPrice() {
		if(quantity == 0) {
			return "";
		}
		Float unitPrice = pretTotal / (1 + tva / 100) / quantity;
		return String.format(FORMAT_MODE, unitPrice);
	}

	@Override
	public String getTVA() {
		if(quantity == 0) {
			return "0";
		}
		Float unitPrice = pretTotal/ (1 + tva / 100) /quantity;
		return String.format(FORMAT_MODE, unitPrice * quantity * tva / 100);
	}

	@Override
	public String getPriceWithoutTVA() {
		if(quantity == 0) {
			return "0";
		}
		return String.format(FORMAT_MODE, pretTotal / (1 + tva / 100));
	}

	@Override
	public String getNumeProduse() {
		return "\n";
	}

	@Override
	public String getTotalWithoutTVA() {
		if(quantity == 0) {
			return "0";
		}
		Float unitPrice = pretTotal / (1 + tva / 100) / quantity;
		return String.format(FORMAT_MODE, unitPrice * quantity);
	}

	@Override
	public String getQuantity() {
		if(quantity > 0) {
			return quantity+"";
		}
		return "";
	}

}
