package ir.gymbot.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link ir.gymbot.domain.Kline} entity. This class is used
 * in {@link ir.gymbot.web.rest.KlineResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /klines?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class KlineCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private LongFilter time;

    private StringFilter open;

    private StringFilter close;

    private StringFilter high;

    private StringFilter low;

    private StringFilter volume;

    private StringFilter turnover;

    private StringFilter timeType;

    private LongFilter symbolId;

    private Boolean distinct;

    public KlineCriteria() {}

    public KlineCriteria(KlineCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.time = other.time == null ? null : other.time.copy();
        this.open = other.open == null ? null : other.open.copy();
        this.close = other.close == null ? null : other.close.copy();
        this.high = other.high == null ? null : other.high.copy();
        this.low = other.low == null ? null : other.low.copy();
        this.volume = other.volume == null ? null : other.volume.copy();
        this.turnover = other.turnover == null ? null : other.turnover.copy();
        this.timeType = other.timeType == null ? null : other.timeType.copy();
        this.symbolId = other.symbolId == null ? null : other.symbolId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public KlineCriteria copy() {
        return new KlineCriteria(this);
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

    public LongFilter getTime() {
        return time;
    }

    public LongFilter time() {
        if (time == null) {
            time = new LongFilter();
        }
        return time;
    }

    public void setTime(LongFilter time) {
        this.time = time;
    }

    public StringFilter getOpen() {
        return open;
    }

    public StringFilter open() {
        if (open == null) {
            open = new StringFilter();
        }
        return open;
    }

    public void setOpen(StringFilter open) {
        this.open = open;
    }

    public StringFilter getClose() {
        return close;
    }

    public StringFilter close() {
        if (close == null) {
            close = new StringFilter();
        }
        return close;
    }

    public void setClose(StringFilter close) {
        this.close = close;
    }

    public StringFilter getHigh() {
        return high;
    }

    public StringFilter high() {
        if (high == null) {
            high = new StringFilter();
        }
        return high;
    }

    public void setHigh(StringFilter high) {
        this.high = high;
    }

    public StringFilter getLow() {
        return low;
    }

    public StringFilter low() {
        if (low == null) {
            low = new StringFilter();
        }
        return low;
    }

    public void setLow(StringFilter low) {
        this.low = low;
    }

    public StringFilter getVolume() {
        return volume;
    }

    public StringFilter volume() {
        if (volume == null) {
            volume = new StringFilter();
        }
        return volume;
    }

    public void setVolume(StringFilter volume) {
        this.volume = volume;
    }

    public StringFilter getTurnover() {
        return turnover;
    }

    public StringFilter turnover() {
        if (turnover == null) {
            turnover = new StringFilter();
        }
        return turnover;
    }

    public void setTurnover(StringFilter turnover) {
        this.turnover = turnover;
    }

    public StringFilter getTimeType() {
        return timeType;
    }

    public StringFilter timeType() {
        if (timeType == null) {
            timeType = new StringFilter();
        }
        return timeType;
    }

    public void setTimeType(StringFilter timeType) {
        this.timeType = timeType;
    }

    public LongFilter getSymbolId() {
        return symbolId;
    }

    public LongFilter symbolId() {
        if (symbolId == null) {
            symbolId = new LongFilter();
        }
        return symbolId;
    }

    public void setSymbolId(LongFilter symbolId) {
        this.symbolId = symbolId;
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
        final KlineCriteria that = (KlineCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(time, that.time) &&
            Objects.equals(open, that.open) &&
            Objects.equals(close, that.close) &&
            Objects.equals(high, that.high) &&
            Objects.equals(low, that.low) &&
            Objects.equals(volume, that.volume) &&
            Objects.equals(turnover, that.turnover) &&
            Objects.equals(timeType, that.timeType) &&
            Objects.equals(symbolId, that.symbolId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, open, close, high, low, volume, turnover, timeType, symbolId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "KlineCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (time != null ? "time=" + time + ", " : "") +
            (open != null ? "open=" + open + ", " : "") +
            (close != null ? "close=" + close + ", " : "") +
            (high != null ? "high=" + high + ", " : "") +
            (low != null ? "low=" + low + ", " : "") +
            (volume != null ? "volume=" + volume + ", " : "") +
            (turnover != null ? "turnover=" + turnover + ", " : "") +
            (timeType != null ? "timeType=" + timeType + ", " : "") +
            (symbolId != null ? "symbolId=" + symbolId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
