import javax.swing.JOptionPane;

public class LogIn {
	private enum AccountType {Administrator, Staff, Student};
	static AccountType[] choicesAccount = {AccountType.Administrator, AccountType.Staff, AccountType.Student};
	static String[] startOption = {"Sign up", "Sign in"};
	
	static int trial = 0;
	static String uData, pwData;
	static AccountType atData;
	
	public static void main(String[] args) {
		int selectedStart = 0;
		do {
		selectedStart = JOptionPane.showOptionDialog(null,
				"                   Welcome to CSC 200!", "Message",
				JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null,
				startOption, null);
		
		if (selectedStart == 0) { signUp(); }
		else if (selectedStart == 1) {
			if (trial < 3) { signIn(); }
			else {
				JOptionPane.showMessageDialog(null,"Contact Admin","Message",JOptionPane.PLAIN_MESSAGE);
			}
		}
		else break;
		
		} while (true);
	}
	
	static void signUp() {
		uData = JOptionPane.showInputDialog(null,"Username",
				"Sign Up",JOptionPane.PLAIN_MESSAGE);
		pwData = JOptionPane.showInputDialog(null,"Password",
				"Sign Up",JOptionPane.PLAIN_MESSAGE);
		atData = (AccountType) JOptionPane.showInputDialog(null,"Select your account type.", "Sign up", 
 				JOptionPane.PLAIN_MESSAGE,null, choicesAccount, choicesAccount[0]);
	}
	
	static void signIn() {
		String uInput = JOptionPane.showInputDialog(null,"Username",
				"Sign In",JOptionPane.PLAIN_MESSAGE);
		
		if (!uInput.equals(uData)) {
			JOptionPane.showMessageDialog(null,"Invalid Username",
				"Message",JOptionPane.PLAIN_MESSAGE);
			trial++;
			return;
		}
		
		String pwInput = JOptionPane.showInputDialog(null,"Password",
				"Sign In",JOptionPane.PLAIN_MESSAGE);
		
		if (!pwInput.equals(pwData)) {
			JOptionPane.showMessageDialog(null,"Invalid password",
					"Message",JOptionPane.PLAIN_MESSAGE);
				trial++;
				return;
		}
		
		AccountType atInput = (AccountType) JOptionPane.showInputDialog(null,"Select your account type.", "Sign up", 
 				JOptionPane.PLAIN_MESSAGE,null, choicesAccount, choicesAccount[0]);
		while (!atInput.equals(atData)) {
			atInput = (AccountType) JOptionPane.showInputDialog(null,"Select your account type.", "Sign up", 
	 				JOptionPane.PLAIN_MESSAGE,null, choicesAccount, choicesAccount[0]);
		}
		
		switch (atInput) {
		case Administrator: JOptionPane.showMessageDialog(null,"Welcome Admin! You can update and read file",
							"Message",JOptionPane.PLAIN_MESSAGE); break;
		case Student: JOptionPane.showMessageDialog(null,"Welcome Student! You can only read file",
					  "Message",JOptionPane.PLAIN_MESSAGE); break;
		case Staff: JOptionPane.showMessageDialog(null,"Welcome Staff! You can update, read, add and delete file",
					"Message",JOptionPane.PLAIN_MESSAGE); break;
		}
		
	}
	
	
}