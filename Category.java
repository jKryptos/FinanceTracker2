import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 8L;

    private final String name;
    private BigDecimal funds;
    private final ArrayList<Transaction> history;

    public Category(String name, BigDecimal initialFunds){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be blank");
        }

        Objects.requireNonNull(initialFunds, "Amount cannot be null");

        if(initialFunds.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Initial funds cannot be negative");
        }

        this.name = name;
        this.funds = initialFunds;
        this.history = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public BigDecimal getFunds(){
        return this.funds;
    }

    public void deposit(BigDecimal amount, String description){
        Objects.requireNonNull(amount, "Amount cannot be null");

        if(amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        this.funds = this.funds.add(amount);
        history.add(new Transaction(description, amount));
    }

    public void withdraw(BigDecimal amount, String description){
        Objects.requireNonNull(amount, "Amount cannot be null");

        if(amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }

        if(this.funds.compareTo(amount) < 0){
            throw new IllegalArgumentException("Insufficient funds for withdrawal");
        }

        this.funds = this.funds.subtract(amount);
        history.add(new Transaction(description, amount.negate()));
    }

    public void getHistory(){
        for(Transaction t : this.history){
            System.out.println(t);
        }
    }

    @Override
    public String toString(){
        return String.format("%s: $%.2f", this.name, this.funds);
    }
}
