package accountparser;

public class AccountTest {
	public static void main(String[] args) {
		
		Account account = new Account();
		
		String line="601;Kasa Hesabı;23560";
		String[] token = line.split(";");
		account.setAccountId(Long.parseLong(token[0]));
		account.setAccountName(token[1]);
		account.setAmountLocal(Double.parseDouble(token[2]));
		System.out.println(account.getAccountId()+";"+account.getAccountName()+";"+account.getAmountLocal());
		
		String string = new StringBuilder(account.getAccountId()+";")
				.append(account.getAccountName()+";")
				.append(account.getAmountLocal())
				.toString();
		System.out.println(string);

	}
}
