package ir.gymbot.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Kline.
 */
@Entity
@Table(name = "kline")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "kline")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Kline implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "time")
    private Long time;

    @Column(name = "open")
    private String open;

    @Column(name = "close")
    private String close;

    @Column(name = "high")
    private String high;

    @Column(name = "low")
    private String low;

    @Column(name = "volume")
    private String volume;

    @Column(name = "turnover")
    private String turnover;

    @Column(name = "time_type")
    private String timeType;

    @ManyToOne
    private Symbol symbol;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Kline id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTime() {
        return this.time;
    }

    public Kline time(Long time) {
        this.setTime(time);
        return this;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getOpen() {
        return this.open;
    }

    public Kline open(String open) {
        this.setOpen(open);
        return this;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return this.close;
    }

    public Kline close(String close) {
        this.setClose(close);
        return this;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getHigh() {
        return this.high;
    }

    public Kline high(String high) {
        this.setHigh(high);
        return this;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return this.low;
    }

    public Kline low(String low) {
        this.setLow(low);
        return this;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getVolume() {
        return this.volume;
    }

    public Kline volume(String volume) {
        this.setVolume(volume);
        return this;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTurnover() {
        return this.turnover;
    }

    public Kline turnover(String turnover) {
        this.setTurnover(turnover);
        return this;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getTimeType() {
        return this.timeType;
    }

    public Kline timeType(String timeType) {
        this.setTimeType(timeType);
        return this;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Kline symbol(Symbol symbol) {
        this.setSymbol(symbol);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Kline)) {
            return false;
        }
        return id != null && id.equals(((Kline) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Kline{" +
            "id=" + getId() +
            ", time=" + getTime() +
            ", open='" + getOpen() + "'" +
            ", close='" + getClose() + "'" +
            ", high='" + getHigh() + "'" +
            ", low='" + getLow() + "'" +
            ", volume='" + getVolume() + "'" +
            ", turnover='" + getTurnover() + "'" +
            ", timeType='" + getTimeType() + "'" +
            "}";
    }
}
