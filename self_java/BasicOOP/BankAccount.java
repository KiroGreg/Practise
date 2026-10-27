public class BankAccount {
    private String number;
    private double balance;
    private String customerName;
    private String phoneNumber;

    public void depositFounds(double depositAmount) {
        balance += depositAmount;
        System.out.println("Deposit on  $" + depositAmount + "made. New balance is  $" + balance);
    }

    public void withdrawFounds(double withdrawAmount) {
        if (balance - withdrawAmount < 0) {
            System.out.println("Not enough money! You only have $" + balance + " in your account.");
        } else {
            balance -= withdrawAmount;
            System.out.println("Withdraw of  $" + withdrawAmount + " processed, remaining in your account is $"
                    + balance + ".");
        }
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
