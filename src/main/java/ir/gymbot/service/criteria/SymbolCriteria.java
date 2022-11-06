package ir.gymbot.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link ir.gymbot.domain.Symbol} entity. This class is used
 * in {@link ir.gymbot.web.rest.SymbolResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /symbols?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SymbolCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter symbol;

    private StringFilter name;

    private StringFilter baseCurrency;

    private StringFilter quoteCurrency;

    private StringFilter feeCurrency;

    private StringFilter market;

    private StringFilter baseMinSize;

    private StringFilter quoteMinSize;

    private StringFilter baseMaxSize;

    private StringFilter quoteMaxSize;

    private StringFilter baseIncrement;

    private StringFilter quoteIncrement;

    private StringFilter priceIncrement;

    private StringFilter priceLimitRate;

    private StringFilter minFunds;

    private BooleanFilter isMarginEnabled;

    private BooleanFilter enableTrading;

    private BooleanFilter active;

    private Boolean distinct;

    public SymbolCriteria() {}

    public SymbolCriteria(SymbolCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.symbol = other.symbol == null ? null : other.symbol.copy();
        this.name = other.name == null ? null : other.name.copy();
        this.baseCurrency = other.baseCurrency == null ? null : other.baseCurrency.copy();
        this.quoteCurrency = other.quoteCurrency == null ? null : other.quoteCurrency.copy();
        this.feeCurrency = other.feeCurrency == null ? null : other.feeCurrency.copy();
        this.market = other.market == null ? null : other.market.copy();
        this.baseMinSize = other.baseMinSize == null ? null : other.baseMinSize.copy();
        this.quoteMinSize = other.quoteMinSize == null ? null : other.quoteMinSize.copy();
        this.baseMaxSize = other.baseMaxSize == null ? null : other.baseMaxSize.copy();
        this.quoteMaxSize = other.quoteMaxSize == null ? null : other.quoteMaxSize.copy();
        this.baseIncrement = other.baseIncrement == null ? null : other.baseIncrement.copy();
        this.quoteIncrement = other.quoteIncrement == null ? null : other.quoteIncrement.copy();
        this.priceIncrement = other.priceIncrement == null ? null : other.priceIncrement.copy();
        this.priceLimitRate = other.priceLimitRate == null ? null : other.priceLimitRate.copy();
        this.minFunds = other.minFunds == null ? null : other.minFunds.copy();
        this.isMarginEnabled = other.isMarginEnabled == null ? null : other.isMarginEnabled.copy();
        this.enableTrading = other.enableTrading == null ? null : other.enableTrading.copy();
        this.active = other.active == null ? null : other.active.copy();
        this.distinct = other.distinct;
    }

    @Override
    public SymbolCriteria copy() {
        return new SymbolCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getSymbol() {
        return symbol;
    }

    public StringFilter symbol() {
        if (symbol == null) {
            symbol = new StringFilter();
        }
        return symbol;
    }

    public void setSymbol(StringFilter symbol) {
        this.symbol = symbol;
    }

    public StringFilter getName() {
        return name;
    }

    public StringFilter name() {
        if (name == null) {
            name = new StringFilter();
        }
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public StringFilter getBaseCurrency() {
        return baseCurrency;
    }

    public StringFilter baseCurrency() {
        if (baseCurrency == null) {
            baseCurrency = new StringFilter();
        }
        return baseCurrency;
    }

    public void setBaseCurrency(StringFilter baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public StringFilter getQuoteCurrency() {
        return quoteCurrency;
    }

    public StringFilter quoteCurrency() {
        if (quoteCurrency == null) {
            quoteCurrency = new StringFilter();
        }
        return quoteCurrency;
    }

    public void setQuoteCurrency(StringFilter quoteCurrency) {
        this.quoteCurrency = quoteCurrency;
    }

    public StringFilter getFeeCurrency() {
        return feeCurrency;
    }

    public StringFilter feeCurrency() {
        if (feeCurrency == null) {
            feeCurrency = new StringFilter();
        }
        return feeCurrency;
    }

    public void setFeeCurrency(StringFilter feeCurrency) {
        this.feeCurrency = feeCurrency;
    }

    public StringFilter getMarket() {
        return market;
    }

    public StringFilter market() {
        if (market == null) {
            market = new StringFilter();
        }
        return market;
    }

    public void setMarket(StringFilter market) {
        this.market = market;
    }

    public StringFilter getBaseMinSize() {
        return baseMinSize;
    }

    public StringFilter baseMinSize() {
        if (baseMinSize == null) {
            baseMinSize = new StringFilter();
        }
        return baseMinSize;
    }

    public void setBaseMinSize(StringFilter baseMinSize) {
        this.baseMinSize = baseMinSize;
    }

    public StringFilter getQuoteMinSize() {
        return quoteMinSize;
    }

    public StringFilter quoteMinSize() {
        if (quoteMinSize == null) {
            quoteMinSize = new StringFilter();
        }
        return quoteMinSize;
    }

    public void setQuoteMinSize(StringFilter quoteMinSize) {
        this.quoteMinSize = quoteMinSize;
    }

    public StringFilter getBaseMaxSize() {
        return baseMaxSize;
    }

    public StringFilter baseMaxSize() {
        if (baseMaxSize == null) {
            baseMaxSize = new StringFilter();
        }
        return baseMaxSize;
    }

    public void setBaseMaxSize(StringFilter baseMaxSize) {
        this.baseMaxSize = baseMaxSize;
    }

    public StringFilter getQuoteMaxSize() {
        return quoteMaxSize;
    }

    public StringFilter quoteMaxSize() {
        if (quoteMaxSize == null) {
            quoteMaxSize = new StringFilter();
        }
        return quoteMaxSize;
    }

    public void setQuoteMaxSize(StringFilter quoteMaxSize) {
        this.quoteMaxSize = quoteMaxSize;
    }

    public StringFilter getBaseIncrement() {
        return baseIncrement;
    }

    public StringFilter baseIncrement() {
        if (baseIncrement == null) {
            baseIncrement = new StringFilter();
        }
        return baseIncrement;
    }

    public void setBaseIncrement(StringFilter baseIncrement) {
        this.baseIncrement = baseIncrement;
    }

    public StringFilter getQuoteIncrement() {
        return quoteIncrement;
    }

    public StringFilter quoteIncrement() {
        if (quoteIncrement == null) {
            quoteIncrement = new StringFilter();
        }
        return quoteIncrement;
    }

    public void setQuoteIncrement(StringFilter quoteIncrement) {
        this.quoteIncrement = quoteIncrement;
    }

    public StringFilter getPriceIncrement() {
        return priceIncrement;
    }

    public StringFilter priceIncrement() {
        if (priceIncrement == null) {
            priceIncrement = new StringFilter();
        }
        return priceIncrement;
    }

    public void setPriceIncrement(StringFilter priceIncrement) {
        this.priceIncrement = priceIncrement;
    }

    public StringFilter getPriceLimitRate() {
        return priceLimitRate;
    }

    public StringFilter priceLimitRate() {
        if (priceLimitRate == null) {
            priceLimitRate = new StringFilter();
        }
        return priceLimitRate;
    }

    public void setPriceLimitRate(StringFilter priceLimitRate) {
        this.priceLimitRate = priceLimitRate;
    }

    public StringFilter getMinFunds() {
        return minFunds;
    }

    public StringFilter minFunds() {
        if (minFunds == null) {
            minFunds = new StringFilter();
        }
        return minFunds;
    }

    public void setMinFunds(StringFilter minFunds) {
        this.minFunds = minFunds;
    }

    public BooleanFilter getIsMarginEnabled() {
        return isMarginEnabled;
    }

    public BooleanFilter isMarginEnabled() {
        if (isMarginEnabled == null) {
            isMarginEnabled = new BooleanFilter();
        }
        return isMarginEnabled;
    }

    public void setIsMarginEnabled(BooleanFilter isMarginEnabled) {
        this.isMarginEnabled = isMarginEnabled;
    }

    public BooleanFilter getEnableTrading() {
        return enableTrading;
    }

    public BooleanFilter enableTrading() {
        if (enableTrading == null) {
            enableTrading = new BooleanFilter();
        }
        return enableTrading;
    }

    public void setEnableTrading(BooleanFilter enableTrading) {
        this.enableTrading = enableTrading;
    }

    public BooleanFilter getActive() {
        return active;
    }

    public BooleanFilter active() {
        if (active == null) {
            active = new BooleanFilter();
        }
        return active;
    }

    public void setActive(BooleanFilter active) {
        this.active = active;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SymbolCriteria that = (SymbolCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(symbol, that.symbol) &&
            Objects.equals(name, that.name) &&
            Objects.equals(baseCurrency, that.baseCurrency) &&
            Objects.equals(quoteCurrency, that.quoteCurrency) &&
            Objects.equals(feeCurrency, that.feeCurrency) &&
            Objects.equals(market, that.market) &&
            Objects.equals(baseMinSize, that.baseMinSize) &&
            Objects.equals(quoteMinSize, that.quoteMinSize) &&
            Objects.equals(baseMaxSize, that.baseMaxSize) &&
            Objects.equals(quoteMaxSize, that.quoteMaxSize) &&
            Objects.equals(baseIncrement, that.baseIncrement) &&
            Objects.equals(quoteIncrement, that.quoteIncrement) &&
            Objects.equals(priceIncrement, that.priceIncrement) &&
            Objects.equals(priceLimitRate, that.priceLimitRate) &&
            Objects.equals(minFunds, that.minFunds) &&
            Objects.equals(isMarginEnabled, that.isMarginEnabled) &&
            Objects.equals(enableTrading, that.enableTrading) &&
            Objects.equals(active, that.active) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            symbol,
            name,
            baseCurrency,
            quoteCurrency,
            feeCurrency,
            market,
            baseMinSize,
            quoteMinSize,
            baseMaxSize,
            quoteMaxSize,
            baseIncrement,
            quoteIncrement,
            priceIncrement,
            priceLimitRate,
            minFunds,
            isMarginEnabled,
            enableTrading,
            active,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SymbolCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (symbol != null ? "symbol=" + symbol + ", " : "") +
            (name != null ? "name=" + name + ", " : "") +
            (baseCurrency != null ? "baseCurrency=" + baseCurrency + ", " : "") +
            (quoteCurrency != null ? "quoteCurrency=" + quoteCurrency + ", " : "") +
            (feeCurrency != null ? "feeCurrency=" + feeCurrency + ", " : "") +
            (market != null ? "market=" + market + ", " : "") +
            (baseMinSize != null ? "baseMinSize=" + baseMinSize + ", " : "") +
            (quoteMinSize != null ? "quoteMinSize=" + quoteMinSize + ", " : "") +
            (baseMaxSize != null ? "baseMaxSize=" + baseMaxSize + ", " : "") +
            (quoteMaxSize != null ? "quoteMaxSize=" + quoteMaxSize + ", " : "") +
            (baseIncrement != null ? "baseIncrement=" + baseIncrement + ", " : "") +
            (quoteIncrement != null ? "quoteIncrement=" + quoteIncrement + ", " : "") +
            (priceIncrement != null ? "priceIncrement=" + priceIncrement + ", " : "") +
            (priceLimitRate != null ? "priceLimitRate=" + priceLimitRate + ", " : "") +
            (minFunds != null ? "minFunds=" + minFunds + ", " : "") +
            (isMarginEnabled != null ? "isMarginEnabled=" + isMarginEnabled + ", " : "") +
            (enableTrading != null ? "enableTrading=" + enableTrading + ", " : "") +
            (active != null ? "active=" + active + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
