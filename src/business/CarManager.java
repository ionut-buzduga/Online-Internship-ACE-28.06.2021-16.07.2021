package business;


import xml.ReadXMLFileUsingDOM;

public class CarManager {
	
	//BusinessTax taxpayer=new BusinessTax();
	final ReadXMLFileUsingDOM displayer= new ReadXMLFileUsingDOM();
	
	private double carTax = 1;
	
	

	 LandTax taxpayer=new LandTax(carTax);
	  public void setTax(double tax) {
	    	taxpayer.setTax(tax);
	    }
	
	public double taxForOnePayer(int ID)
	{   displayer.display();
		double d1=Double.parseDouble(displayer.getCars().get(ID));
		
	 return	taxpayer.computeTaxForTaxPayer(d1);
		
	}
	
	public double taxForAllPayers()
	{   displayer.display();
	    double taxSum=0;  
	  for(int index=0;index<displayer.getCars().size();index++)
	  {
		double d1=Double.parseDouble(displayer.getCars().get(index));
		taxSum=taxSum+taxpayer.computeTaxForTaxPayer(d1);
	  }
	 return	taxSum;
		
	}


}