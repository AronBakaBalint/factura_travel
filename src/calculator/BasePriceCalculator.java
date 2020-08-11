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
		return String.format("%.2f", unitPrice);
	}

	@Override
	public String getTVA() {
		if(quantity == 0) {
			return "";
		}
		Float unitPrice = pretTotal/ (1 + tva / 100) /quantity;
		return String.format("%.2f", unitPrice * quantity * tva / 100);
	}

	@Override
	public String getPriceWithoutTVA() {
		if(quantity == 0) {
			return "";
		}
		Float unitPrice = pretTotal / (1 + tva / 100) / quantity;
		return String.format("%.2f", unitPrice * quantity);
	}

	@Override
	public String getNumeProduse() {
		return "";
	}

	@Override
	public String getTotalWithoutTVA() {
		if(quantity == 0) {
			return "";
		}
		Float unitPrice = pretTotal / (1 + tva / 100) / quantity;
		return String.format("%.2f", unitPrice * quantity);
	}

	@Override
	public String getQuantity() {
		if(quantity > 0) {
			return quantity+"";
		}
		return "";
	}

}
