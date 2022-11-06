package ir.gymbot.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Symbol.
 */
@Entity
@Table(name = "symbol")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "symbol")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Symbol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "symbol", nullable = false)
    private String symbol;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "base_currency")
    private String baseCurrency;

    @Column(name = "quote_currency")
    private String quoteCurrency;

    @Column(name = "fee_currency")
    private String feeCurrency;

    @Column(name = "market")
    private String market;

    @Column(name = "base_min_size")
    private String baseMinSize;

    @Column(name = "quote_min_size")
    private String quoteMinSize;

    @Column(name = "base_max_size")
    private String baseMaxSize;

    @Column(name = "quote_max_size")
    private String quoteMaxSize;

    @Column(name = "base_increment")
    private String baseIncrement;

    @Column(name = "quote_increment")
    private String quoteIncrement;

    @Column(name = "price_increment")
    private String priceIncrement;

    @Column(name = "price_limit_rate")
    private String priceLimitRate;

    @Column(name = "min_funds")
    private String minFunds;

    @Column(name = "is_margin_enabled")
    private Boolean isMarginEnabled;

    @Column(name = "enable_trading")
    private Boolean enableTrading;

    @Column(name = "active")
    private Boolean active;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Symbol id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public Symbol symbol(String symbol) {
        this.setSymbol(symbol);
        return this;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return this.name;
    }

    public Symbol name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public Symbol baseCurrency(String baseCurrency) {
        this.setBaseCurrency(baseCurrency);
        return this;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public Symbol quoteCurrency(String quoteCurrency) {
        this.setQuoteCurrency(quoteCurrency);
        return this;
    }

    public void setQuoteCurrency(String quoteCurrency) {
        this.quoteCurrency = quoteCurrency;
    }

    public String getFeeCurrency() {
        return this.feeCurrency;
    }

    public Symbol feeCurrency(String feeCurrency) {
        this.setFeeCurrency(feeCurrency);
        return this;
    }

    public void setFeeCurrency(String feeCurrency) {
        this.feeCurrency = feeCurrency;
    }

    public String getMarket() {
        return this.market;
    }

    public Symbol market(String market) {
        this.setMarket(market);
        return this;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getBaseMinSize() {
        return this.baseMinSize;
    }

    public Symbol baseMinSize(String baseMinSize) {
        this.setBaseMinSize(baseMinSize);
        return this;
    }

    public void setBaseMinSize(String baseMinSize) {
        this.baseMinSize = baseMinSize;
    }

    public String getQuoteMinSize() {
        return this.quoteMinSize;
    }

    public Symbol quoteMinSize(String quoteMinSize) {
        this.setQuoteMinSize(quoteMinSize);
        return this;
    }

    public void setQuoteMinSize(String quoteMinSize) {
        this.quoteMinSize = quoteMinSize;
    }

    public String getBaseMaxSize() {
        return this.baseMaxSize;
    }

    public Symbol baseMaxSize(String baseMaxSize) {
        this.setBaseMaxSize(baseMaxSize);
        return this;
    }

    public void setBaseMaxSize(String baseMaxSize) {
        this.baseMaxSize = baseMaxSize;
    }

    public String getQuoteMaxSize() {
        return this.quoteMaxSize;
    }

    public Symbol quoteMaxSize(String quoteMaxSize) {
        this.setQuoteMaxSize(quoteMaxSize);
        return this;
    }

    public void setQuoteMaxSize(String quoteMaxSize) {
        this.quoteMaxSize = quoteMaxSize;
    }

    public String getBaseIncrement() {
        return this.baseIncrement;
    }

    public Symbol baseIncrement(String baseIncrement) {
        this.setBaseIncrement(baseIncrement);
        return this;
    }

    public void setBaseIncrement(String baseIncrement) {
        this.baseIncrement = baseIncrement;
    }

    public String getQuoteIncrement() {
        return this.quoteIncrement;
    }

    public Symbol quoteIncrement(String quoteIncrement) {
        this.setQuoteIncrement(quoteIncrement);
        return this;
    }

    public void setQuoteIncrement(String quoteIncrement) {
        this.quoteIncrement = quoteIncrement;
    }

    public String getPriceIncrement() {
        return this.priceIncrement;
    }

    public Symbol priceIncrement(String priceIncrement) {
        this.setPriceIncrement(priceIncrement);
        return this;
    }

    public void setPriceIncrement(String priceIncrement) {
        this.priceIncrement = priceIncrement;
    }

    public String getPriceLimitRate() {
        return this.priceLimitRate;
    }

    public Symbol priceLimitRate(String priceLimitRate) {
        this.setPriceLimitRate(priceLimitRate);
        return this;
    }

    public void setPriceLimitRate(String priceLimitRate) {
        this.priceLimitRate = priceLimitRate;
    }

    public String getMinFunds() {
        return this.minFunds;
    }

    public Symbol minFunds(String minFunds) {
        this.setMinFunds(minFunds);
        return this;
    }

    public void setMinFunds(String minFunds) {
        this.minFunds = minFunds;
    }

    public Boolean getIsMarginEnabled() {
        return this.isMarginEnabled;
    }

    public Symbol isMarginEnabled(Boolean isMarginEnabled) {
        this.setIsMarginEnabled(isMarginEnabled);
        return this;
    }

    public void setIsMarginEnabled(Boolean isMarginEnabled) {
        this.isMarginEnabled = isMarginEnabled;
    }

    public Boolean getEnableTrading() {
        return this.enableTrading;
    }

    public Symbol enableTrading(Boolean enableTrading) {
        this.setEnableTrading(enableTrading);
        return this;
    }

    public void setEnableTrading(Boolean enableTrading) {
        this.enableTrading = enableTrading;
    }

    public Boolean getActive() {
        return this.active;
    }

    public Symbol active(Boolean active) {
        this.setActive(active);
        return this;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Symbol)) {
            return false;
        }
        return id != null && id.equals(((Symbol) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Symbol{" +
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
