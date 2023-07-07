package caseThird;

public class Money {
    private Integer amount;
    private Currency currency;
    
    public enum Currency {                                           
        EUR (978),
        USD (840),
        MDL (498);
        private final int CURRENCY_NUMBER;

        private Currency(final int CURRENCY_NUMBER) {
            this.CURRENCY_NUMBER = CURRENCY_NUMBER;
        }

        public int getCURRENCY_NUMBER() {
            return CURRENCY_NUMBER;
        }
    }

    public Money(Integer amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    
    @Override
    public String toString() {
        return "Money [amount=" + amount + ", currency=" + currency + "]";
    }

}
