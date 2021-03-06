package calculator;

public class OnePercentPriceCalculator extends PriceCalculator {

	
	public OnePercentPriceCalculator(Float pretTotal, Float tva, Integer quantity) {
		super(pretTotal, tva, quantity);
	}

	@Override
	public String getUnitPrice() {
		Float unitPrice = pretTotal / (1 + tva / 100 + 0.01f) / quantity;
		return String.format(FORMAT_MODE, unitPrice) + "\n\n" + String.format(FORMAT_MODE, quantity * unitPrice / 100);
	}

	@Override
	public String getPriceWithoutTVA() {
		Float unitPrice = pretTotal / (1 + tva / 100 + 0.01f) / quantity;
		return String.format(FORMAT_MODE, unitPrice * quantity) + "\n\n" + String.format(FORMAT_MODE, quantity * unitPrice / 100);
	}

	@Override
	public String getNumeProduse() {
		return "\n\nTaxa turism 1%\n";
	}

	@Override
	public String getTVA() {
		Float unitPrice = pretTotal / (1 + tva / 100 + 0.01f) / quantity;
		return String.format(FORMAT_MODE, unitPrice * quantity * tva / 100) + "\n\n-";
	}

	@Override
	public String getTotalWithoutTVA() {
		Float unitPrice = pretTotal / (1 + tva / 100 + 0.01f) / quantity;
		Float turismTVA = quantity * unitPrice / 100;
		return String.format(FORMAT_MODE, unitPrice * quantity + turismTVA);
	}

	@Override
	public String getQuantity() {
		return quantity + "\n\n1";
	}

}
