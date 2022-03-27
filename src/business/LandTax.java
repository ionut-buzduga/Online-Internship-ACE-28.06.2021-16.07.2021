package business;

public class LandTax implements ITax{
	
	private double businessTax;

    public LandTax(double businessTax) {
        this.businessTax=businessTax;
    }
	
    public void setTax(double tax) {
    	businessTax=tax;
    }
    
	@Override
    public double computeTaxForTaxPayer(double land) {
        return land * businessTax;
    }
}
