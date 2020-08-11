package calculator;

public class BasePriceCalculator extends PriceCalculator{

	
	public BasePriceCalculator(Float pretTotal, Float tva, Integer quantity) {
		super(pretTotal, tva, quantity);
	}

	@Override
	public String getUnitPrice() {
		Float unitPrice = pretTotal / 1.05f / quantity;
		return String.format("%.2f", unitPrice);
	}

	@Override
	public String getTVA() {
		Float unitPrice = pretTotal/ 1.05f /quantity;
		return String.format("%.2f", unitPrice * quantity * tva / 100);
	}

	@Override
	public String getPriceWithoutTVA() {
		Float unitPrice = pretTotal / 1.05f / quantity;
		return String.format("%.2f", unitPrice * quantity);
	}

	@Override
	public String getNumeProduse() {
		return "\n\nTermen de plata:   5 zile";
	}

	@Override
	public String getTotalWithoutTVA() {
		Float unitPrice = pretTotal / 1.05f / quantity;
		return String.format("%.2f", unitPrice * quantity);
	}

	@Override
	public String getQuantity() {
		return quantity+"";
	}

}
