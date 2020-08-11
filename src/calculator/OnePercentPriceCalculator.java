package calculator;

public class OnePercentPriceCalculator extends PriceCalculator {

	public OnePercentPriceCalculator(Float pretTotal, Float tva, Integer quantity) {
		super(pretTotal, tva, quantity);
	}

	@Override
	public String getUnitPrice() {
		Float unitPrice = pretTotal / 1.06f / quantity;
		return String.format("%.2f", unitPrice) + "\n\n" + String.format("%.2f", quantity * unitPrice / 100);
	}

	@Override
	public String getPriceWithoutTVA() {
		Float unitPrice = pretTotal / 1.06f / quantity;
		return String.format("%.2f", unitPrice * quantity) + "\n\n" + String.format("%.2f", quantity * unitPrice / 100);
	}

	@Override
	public String getNumeProduse() {
		return "\n\nTaxa turism 1%\n" + "\n\nTermen de plata:   5 zile";
	}

	@Override
	public String getTVA() {
		Float unitPrice = pretTotal / 1.06f / quantity;
		return String.format("%.2f", unitPrice * quantity * tva / 100) + "\n\n-";
	}

	@Override
	public String getTotalWithoutTVA() {
		Float unitPrice = pretTotal / 1.06f / quantity;
		Float turismTVA = quantity * unitPrice / 100;
		return String.format("%.2f", unitPrice * quantity + turismTVA);
	}

	@Override
	public String getQuantity() {
		return quantity + "\n\n1";
	}

}
