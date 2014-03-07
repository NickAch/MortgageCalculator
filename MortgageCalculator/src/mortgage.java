


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
	
	//return the value of each mortgage payment
	public double getPayment(){
		return payments;
	}
	
	//returns the effective monthly rate of interest
	public double getEffectiveRate(){
		
		return effectiveRate;
	}
	
	//returns the total interest payments over the term of the mortgage
	public double getTotalInterest(){
		
		return totInterest;
	}
	
	/*returns the $ value of the interest portition of the payment
	 *  at the payment  number paymentNumber
	*/
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
	
	/*
	 * returns the $ value of principal porition of 
	 * the payment , payment number paymentNumber
	 */
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
	
	/*
	 * returns the principal remaining to be paid after the 
	 * 'paymentNumber'th payment
	 */
	
	public double getPrincipalRemaining(int paymentNumber){
		
		double balance = initPrincipal;
		double interest = 0;	
		double principal = 0;	
			
			for(int i = 0; i < paymentNumber ; i++){
				//calculates interest payment, principal payment and ending balance
				interest = balance * effectiveRate;
				principal = payments - interest;
				balance -= principal;
			}
			//returns the ending balance after paymentNumber payments
	    return balance;
	}
	
	/*
	 * Prints a table containing the payment #, balance before that
	 * payment, $ value of payment, how much of it is going towards
	 * interest and how much is going towards paying principal
	 * and the ending principal balance after the payment.
	 */
	public void printMortgageTable(){
		
		//instance variables
		double balance = initPrincipal;
		double interest = 0;	
		double principal = 0;
		
		/*prints a title for the columns and a line that
		*correspond to each payment for a total of
		*numberOfPayments + 1 lines.
		*/
		for(int i = 0; i <= numberOfPayments ; i++){
			
			//if its the first line print the title						
			if(i == 0){
				System.out.printf("%12s %12s %9s %12s %12s %12s\n" ,
						"Payment #" , "Beg. Balance" , "Payment",
						"Interest","Principal","End Balance");}
			
			//else calculate appropriate values and print them
			else{
				
				interest = balance * effectiveRate; //calculates interest
				principal = payments - interest; //calculates principal
				balance -= principal; //calculates end balance
				
				System.out.printf("%12d %9.2f %12.2f %11.2f %11.2f %12.2f\n" ,
						i , balance + principal , payments,
						interest, principal, balance);
			
			}
		}
	}
	
	//make spreadsheet function
	//public void makeCSV(){}
	
	//global variables
	private double effectiveRate;
	private int numberOfPayments;
	private int initPrincipal;
	private double payments;
	private double totInterest;
}
