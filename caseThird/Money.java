package caseThird;

public class Money {
    private Integer amount;
    private Currency currency;
    
    public enum Currency {                                           // <---------HW1. It can be created in a separate file,
        EUR (978),                                   // but then in main() we should call the package first instead
        USD (840),                                   // of the Money class every time we need to call Currency, so
        MDL (498);                                   // at this level I think it's more intuitive to call in main()
                                                                     // "Money.Currency.EUR" instead of "caseThird.Currency.EUR".
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
