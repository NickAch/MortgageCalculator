


public class mortgage {

	public mortgage(int principal, double simpleRate, int termMonths , int compoundingPeriods){
		
		initPrincipal = principal;
		numberOfPayments = termMonths;
		
		effectiveRate = Math.pow(1 + (simpleRate/compoundingPeriods),compoundingPeriods);
		effectiveRate = Math.pow(effectiveRate, 1.0/12) - 1;
		//calculates effective interest rate when considering compounding using the simple rate
		payments = (initPrincipal * effectiveRate) / 
				( 1 - Math.pow((1 + effectiveRate),-numberOfPayments));
		//calculates the cost per payment by rearranging the present value of an annuity formula
		totInterest = payments * numberOfPayments - initPrincipal;
		//calculates the total interest paid over the life of the mortgage.
	}
	
	
	public double getPayment(){
		return payments;
	}
	
	public double getEffectiveRate(){
		
		return effectiveRate;
	}
	
	public double getTotalInterest(){
		
		return totInterest;
	}
	
	
	public double getCurrentInterest(int paymentNumber){
		double balance = initPrincipal;
		double interest = 0;	
		double principal = 0;	
			
			for(int i = 0; i < paymentNumber ; i++){
				
				interest = balance * effectiveRate;
				principal = payments - interest;
				balance -= principal;
			}

	    return interest;
	}
	
	
	public double getCurrentPrincipal(int paymentNumber){
		double balance = initPrincipal;
		double interest = 0;	
		double principal = 0;	
			
			for(int i = 0; i < paymentNumber ; i++){
				
				interest = balance * effectiveRate;
				principal = payments - interest;
				balance -= principal;
			}

	    return principal;
		
	}
	
	
	
	public double getPrincipalRemaining(int paymentNumber){
		
		double balance = initPrincipal;
		double interest = 0;	
		double principal = 0;	
			
			for(int i = 0; i < paymentNumber ; i++){
				
				interest = balance * effectiveRate;
				principal = payments - interest;
				balance -= principal;
			}

	    return balance;
	}
	
	
	public void printMortgageTable(){
		
		double balance = initPrincipal;
		double interest = 0;	
		double principal = 0;
		
		for(int i = 0; i <= numberOfPayments ; i++){
			
									
			if(i == 0){
				System.out.printf("%12s %12s %9s %12s %12s %12s\n" ,
						"Payment #" , "Beg. Balance" , "Payment",
						"Interest","Principal","End Balance");}
			
			else{
			
				interest = balance * effectiveRate;
				principal = payments - interest;
				balance -= principal;
				
				System.out.printf("%12d %9.2f %12.2f %11.2f %11.2f %12.2f\n" ,
						i , balance + principal , payments,
						interest, principal, balance);
			
			}
		}
	}
	
	//public void makeCSV(){}
	
	private double effectiveRate;
	private int numberOfPayments;
	private int initPrincipal;
	private double payments;
	private double totInterest;
}
