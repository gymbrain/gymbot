package ir.gymbot.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link ir.gymbot.domain.Symbol} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SymbolDTO implements Serializable {

    private Long id;

    @NotNull
    private String symbol;

    @NotNull
    private String name;

    private String baseCurrency;

    private String quoteCurrency;

    private String feeCurrency;

    private String market;

    private String baseMinSize;

    private String quoteMinSize;

    private String baseMaxSize;

    private String quoteMaxSize;

    private String baseIncrement;

    private String quoteIncrement;

    private String priceIncrement;

    private String priceLimitRate;

    private String minFunds;

    private Boolean isMarginEnabled;

    private Boolean enableTrading;

    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    public void setQuoteCurrency(String quoteCurrency) {
        this.quoteCurrency = quoteCurrency;
    }

    public String getFeeCurrency() {
        return feeCurrency;
    }

    public void setFeeCurrency(String feeCurrency) {
        this.feeCurrency = feeCurrency;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getBaseMinSize() {
        return baseMinSize;
    }

    public void setBaseMinSize(String baseMinSize) {
        this.baseMinSize = baseMinSize;
    }

    public String getQuoteMinSize() {
        return quoteMinSize;
    }

    public void setQuoteMinSize(String quoteMinSize) {
        this.quoteMinSize = quoteMinSize;
    }

    public String getBaseMaxSize() {
        return baseMaxSize;
    }

    public void setBaseMaxSize(String baseMaxSize) {
        this.baseMaxSize = baseMaxSize;
    }

    public String getQuoteMaxSize() {
        return quoteMaxSize;
    }

    public void setQuoteMaxSize(String quoteMaxSize) {
        this.quoteMaxSize = quoteMaxSize;
    }

    public String getBaseIncrement() {
        return baseIncrement;
    }

    public void setBaseIncrement(String baseIncrement) {
        this.baseIncrement = baseIncrement;
    }

    public String getQuoteIncrement() {
        return quoteIncrement;
    }

    public void setQuoteIncrement(String quoteIncrement) {
        this.quoteIncrement = quoteIncrement;
    }

    public String getPriceIncrement() {
        return priceIncrement;
    }

    public void setPriceIncrement(String priceIncrement) {
        this.priceIncrement = priceIncrement;
    }

    public String getPriceLimitRate() {
        return priceLimitRate;
    }

    public void setPriceLimitRate(String priceLimitRate) {
        this.priceLimitRate = priceLimitRate;
    }

    public String getMinFunds() {
        return minFunds;
    }

    public void setMinFunds(String minFunds) {
        this.minFunds = minFunds;
    }

    public Boolean getIsMarginEnabled() {
        return isMarginEnabled;
    }

    public void setIsMarginEnabled(Boolean isMarginEnabled) {
        this.isMarginEnabled = isMarginEnabled;
    }

    public Boolean getEnableTrading() {
        return enableTrading;
    }

    public void setEnableTrading(Boolean enableTrading) {
        this.enableTrading = enableTrading;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SymbolDTO)) {
            return false;
        }

        SymbolDTO symbolDTO = (SymbolDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, symbolDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SymbolDTO{" +
            "id=" + getId() +
            ", symbol='" + getSymbol() + "'" +
            ", name='" + getName() + "'" +
            ", baseCurrency='" + getBaseCurrency() + "'" +
            ", quoteCurrency='" + getQuoteCurrency() + "'" +
            ", feeCurrency='" + getFeeCurrency() + "'" +
            ", market='" + getMarket() + "'" +
            ", baseMinSize='" + getBaseMinSize() + "'" +
            ", quoteMinSize='" + getQuoteMinSize() + "'" +
            ", baseMaxSize='" + getBaseMaxSize() + "'" +
            ", quoteMaxSize='" + getQuoteMaxSize() + "'" +
            ", baseIncrement='" + getBaseIncrement() + "'" +
            ", quoteIncrement='" + getQuoteIncrement() + "'" +
            ", priceIncrement='" + getPriceIncrement() + "'" +
            ", priceLimitRate='" + getPriceLimitRate() + "'" +
            ", minFunds='" + getMinFunds() + "'" +
            ", isMarginEnabled='" + getIsMarginEnabled() + "'" +
            ", enableTrading='" + getEnableTrading() + "'" +
            ", active='" + getActive() + "'" +
            "}";
    }
}
