package calculator;

public abstract class PriceCalculator {
	
	protected Float pretTotal;
	protected Float tva;
	protected Integer quantity;
	
	public PriceCalculator(Float pretTotal, Float tva, Integer quantity) {
		super();
		this.pretTotal = pretTotal;
		this.tva = tva;
		this.quantity = quantity;
	}
	public abstract String getUnitPrice();
	public abstract String getTVA();
	public abstract String getPriceWithoutTVA();
	public abstract String getNumeProduse();
	public abstract String getTotalWithoutTVA();
	public abstract String getQuantity();
	
	public Float getTotalPrice() {
		return pretTotal;
	}

}
