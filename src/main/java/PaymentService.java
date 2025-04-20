 public class PaymentService {

    public boolean transferFunds(Wallet from, Wallet to, double amount) {
        if (from.getBalance() >= amount) {
            from.deductFunds(amount);
            to.addFunds(amount);
            return true;
        }
       return false;
    }
};