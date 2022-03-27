package business;

public class CarTax implements ITax{
	
	private  double carTax;

    public CarTax(double carTax) {
        this.carTax=carTax;
    }
	
    public void setTax(double tax) {
    	carTax=tax;
    }
    
	@Override
    public double computeTaxForTaxPayer(double capacity) {
        return capacity * carTax;
    }
}
