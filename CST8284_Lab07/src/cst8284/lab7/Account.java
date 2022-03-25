
package cst8284.lab7;

import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class Account {
	private String accountNumber = "000-000000";  // branch number - customer account number
	private String firstName, lastName;  
	private static final Calendar ACCOUNTSTARTDATE = Calendar.getInstance();
	private DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
	
	public Account(String accountNumber, String firstName, String lastName, String startDate) {
		dateFormat.setLenient(false);
		setAccountNumber(accountNumber);
		setFirstName(firstName);
		setLastName(lastName);
		setAccountStartDate(startDate);
	}
	
	private void setAccountNumber(String accountNumber) {	
		// TODO #1: Run the QuestionGenerator and test for the error condition 
		// indicated.  If the condition exists, throw a BadAccountInputException 
		// displaying the message provided; this exception will be caught by the 
		// exception handler in the AccountLauncher class, and the user prompted 
		// for a new input.  Only if there is no error should the account number 
		// (in the line below) be set.  Note that in addition to the test indicated
		// in the QuestionGenerator, your code must also call the isCheckDigitCorrect()
		// method as well in determining whether to set the account number or not.

//		TODO #1: Bad account number entered.
//
//		Description of your code: Test for '-' between branch number and customer number.
//
//		Error message to output: "Format: XXX-YYYYYY"
//
//		Note that for this test you should only need to use the String methods indicated in the lab; 
//				under no circumstances should you need to dissect the account number character-by-character.  
//				You may use regular expressions (regex) if you find it convenient, but you should be able to 
//				perform this test using String methods only.	(3 marks)
		
		if(!Pattern.matches("[1-9][1-9][1-9][-]?[1-9]*", accountNumber)) {
			throw new BadAccountInputException("Format: XXX-YYYYY");
		}
		
		if(isCheckDigitCorrect(accountNumber)) {
			this.accountNumber = accountNumber;
		} else {
			throw new BadAccountInputException("Bad account number; check digit failed.");
		}
			
	}
	
	private static boolean isCheckDigitCorrect(String accountNumber ) {
		// TODO #2: Write the code here to test the account number, according to
		// the algorithm indicated in the QuestionGenerator.  If the check digit 
		// is correct then return true, otherwise false.  Use the result to throw
		// a new BadAccountInputException in the setAccountNumber() method above, with
		// the message "Bad account number; check digit failed." if the result of
		// this method returns false.	
		

		//TODO #2: Implement the following checksum algorithm and use it to trigger an exception
		//if the customer account number is incorrect.  Not only must your code work correctly with
		//any six-digit account number according to the following algorithm, (where the last digit 
		//		is always the check digit) it must also be scalable to any number of digits in the customer account number. 
		//Description of algorithm:
		//Every digit in an even-numbered position is multiplied by two, and added to the remaining digits in odd-numbered positions. 
		//Modulus the sum of all digits by 9.  Then check that this number equals the last (i.e. check) digit  Thus for the checksum 125537,
		//the calculation would be 2*1 + 2 + 2*5 + 5 + 2*3 = 25.  25%9 = 7.
		//[Note: all digit positions are treated as zero-based.  Thus for the checkdigits 123456, 1, 3, and 5 are at 
		//positions 0, 2, and 4 (the even-numbered positions), while the numbers 2, 4 and 6 (the checkdigit) are at positions
		//positions 1, 3, and 5 (the odd-numbered positions)].  
		//(10 marks)
		
		String accountNumberCheck = accountNumber.substring(4).trim();
		Integer.parseInt(accountNumberCheck);
		
		int checkDigit = Character.getNumericValue(accountNumberCheck.charAt(accountNumberCheck.length() -1));
		int x = 0;
		
		for(int i = 0; i < accountNumberCheck.length()-1; i++) {
			if(i % 2 == 0) {
				x += Character.getNumericValue(accountNumberCheck.charAt(i)) * 2;
			}else {
				x += Character.getNumericValue(accountNumberCheck.charAt(i));
			}
		}

		int algorithm = (Math.abs(x) % 9);
		
		if(checkDigit == algorithm) {
			return true;
		} else {
			return false;
		}

	}
	
	private static boolean isInputNameCorrect(String name)  {
		// TODO #3: Write the code here to test for the input name error condition indicated
		// in the Lab 7 QuestionsGenerator, and throw a new BadAccountInputException with
		// the message indicated.  This exception will be caught in the AccountLanucher 
		// class.  Only if this error does not occur should this function return true.
		// Note that this test is used in checking the setters for both the first
		// and last names, below.
		

		//TODO #3: Bad first or last name entered.
		//
		//Description of your code: Test if name consists of only spaces, i.e. "   ".
		//
		//Error message to output: "Name contains only spaces"
		//(3 marks)
		
		name = name.trim();
		
		if(Pattern.matches("\\W*", name)) {
			throw new BadAccountInputException("Name contains only spaces");
		} else {
			return true;
		}
	}
	
	public void setAccountStartDate(String startDate)  {
		
		try {	
		Date date = dateFormat.parse(startDate);
		ACCOUNTSTARTDATE.setTime(date);
		}

		catch (RuntimeException ex) {
			throw new BadAccountInputException("General runtime exception thrown setting start date");
		}
		
		catch (ParseException ex) {
			throw new BadAccountInputException("Format is YYYY-MM-DD");
		}
		// TODO #4: Wrap the above code in a try/catch block, and check the
		// QuestionGenerator for the two exceptions you'll need to test for. 
		
//		TODO #4: Bad account start date entered.
//
//		Description of your code: In separate catch blocks, check for the following two exceptions,
//		indicated below.  For each, throw a BadAccountInputException along with the message output indicated.
//
//		   Exception thrown		   Message output
//		  "RuntimeException"		"General runtime exception thrown setting start date"
//		  "ParseException"		"Format is YYYY-MM-DD"
//
//		(3 marks)
		
	}
	private void setFirstName(String firstName) {
		if (isInputNameCorrect(firstName)) this.firstName = firstName;
	}
	
	private void setLastName(String lastName) {
		if (isInputNameCorrect(lastName)) this.lastName = lastName;
	}
	
	public String getAccountNumber() {return accountNumber;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}	
	public Calendar getAccountStartDate() {return ACCOUNTSTARTDATE;}
	
	public String toString() {
		return "Customer name: " + getFirstName() + " " + getLastName() 
			+ "\nCustomer Account number: " + getAccountNumber()
			+ "\nAccount Created: " + getAccountStartDate().getTime().toString();
	}
	
}
