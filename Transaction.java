import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction implements Serializable {

    @Serial
    private static final long serialVersionUID = 8L;

    private final String descriptionOfEvent;
    private final BigDecimal fundsDelta;
    private final LocalDate timestamp;

    public Transaction(String descriptionOfEvent, BigDecimal fundsDelta){
        this.descriptionOfEvent = descriptionOfEvent;
        this.fundsDelta = fundsDelta;
        this.timestamp = LocalDate.now();
    }

    @Override
    public String toString(){
        String sign = fundsDelta.compareTo(BigDecimal.ZERO) >= 0 ? "+" : "-";
        return String.format("%s$%.2f : %s - %s", sign, fundsDelta.abs(), descriptionOfEvent, timestamp);
    }
}
