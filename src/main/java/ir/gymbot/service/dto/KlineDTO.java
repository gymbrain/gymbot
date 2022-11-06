package ir.gymbot.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ir.gymbot.domain.Kline} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class KlineDTO implements Serializable {

    private Long id;

    private Long time;

    private String open;

    private String close;

    private String high;

    private String low;

    private String volume;

    private String turnover;

    private String timeType;

    private SymbolDTO symbol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public SymbolDTO getSymbol() {
        return symbol;
    }

    public void setSymbol(SymbolDTO symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KlineDTO)) {
            return false;
        }

        KlineDTO klineDTO = (KlineDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, klineDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "KlineDTO{" +
            "id=" + getId() +
            ", time=" + getTime() +
            ", open='" + getOpen() + "'" +
            ", close='" + getClose() + "'" +
            ", high='" + getHigh() + "'" +
            ", low='" + getLow() + "'" +
            ", volume='" + getVolume() + "'" +
            ", turnover='" + getTurnover() + "'" +
            ", timeType='" + getTimeType() + "'" +
            ", symbol=" + getSymbol() +
            "}";
    }
}
