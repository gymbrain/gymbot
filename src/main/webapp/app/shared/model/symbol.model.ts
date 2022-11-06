export interface ISymbol {
  id?: number;
  symbol?: string;
  name?: string;
  baseCurrency?: string | null;
  quoteCurrency?: string | null;
  feeCurrency?: string | null;
  market?: string | null;
  baseMinSize?: string | null;
  quoteMinSize?: string | null;
  baseMaxSize?: string | null;
  quoteMaxSize?: string | null;
  baseIncrement?: string | null;
  quoteIncrement?: string | null;
  priceIncrement?: string | null;
  priceLimitRate?: string | null;
  minFunds?: string | null;
  isMarginEnabled?: boolean | null;
  enableTrading?: boolean | null;
  active?: boolean | null;
}

export class Symbol implements ISymbol {
  constructor(
    public id?: number,
    public symbol?: string,
    public name?: string,
    public baseCurrency?: string | null,
    public quoteCurrency?: string | null,
    public feeCurrency?: string | null,
    public market?: string | null,
    public baseMinSize?: string | null,
    public quoteMinSize?: string | null,
    public baseMaxSize?: string | null,
    public quoteMaxSize?: string | null,
    public baseIncrement?: string | null,
    public quoteIncrement?: string | null,
    public priceIncrement?: string | null,
    public priceLimitRate?: string | null,
    public minFunds?: string | null,
    public isMarginEnabled?: boolean | null,
    public enableTrading?: boolean | null,
    public active?: boolean | null
  ) {
    this.isMarginEnabled = this.isMarginEnabled ?? false;
    this.enableTrading = this.enableTrading ?? false;
    this.active = this.active ?? false;
  }
}
