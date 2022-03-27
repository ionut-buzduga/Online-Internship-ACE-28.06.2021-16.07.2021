package business;


import xml.ReadXMLFileUsingDOM;

public class LandManager {
	
	//BusinessTax taxpayer=new BusinessTax();
	final ReadXMLFileUsingDOM displayer= new ReadXMLFileUsingDOM();
	
	private double landTax = 1;
	
	

	 LandTax taxpayer=new LandTax(landTax);
	  public void setTax(double tax) {
	    	taxpayer.setTax(tax);
	    }
	
	public double taxForOnePayer(int ID)
	{   displayer.display();
	
		double d1=Double.parseDouble(displayer.getLands().get(ID));
		
	 return	taxpayer.computeTaxForTaxPayer(d1);
		
	}
	
	
	
	public double taxForAllPayers()
	{   
		 double taxSum=0; 
		 displayer.display();
		
		  for(int index=0;index<displayer.getLands().size();index++)
		  {
			double d1=Double.parseDouble(displayer.getLands().get(index));
			taxSum=taxSum+taxpayer.computeTaxForTaxPayer(d1);
		  }
		 return	taxSum;
		
	}


}
