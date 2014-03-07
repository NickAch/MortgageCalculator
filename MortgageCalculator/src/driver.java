 
public class driver {

	public static void main(String[] args) {
		Mortgage bill = new Mortgage(600000,0.05,300,2);
		//System.out.println(bill.getPayment());
		//System.out.println(bill.getEffectiveRate());
		bill.printMortgageTable();
		
	}

}
