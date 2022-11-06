import { ISymbol } from '@/shared/model/base/symbol.model';

export interface IKline {
  id?: number;
  time?: number | null;
  open?: string | null;
  close?: string | null;
  high?: string | null;
  low?: string | null;
  volume?: string | null;
  turnover?: string | null;
  timeType?: string | null;
  symbol?: ISymbol | null;
}

export class Kline implements IKline {
  constructor(
    public id?: number,
    public time?: number | null,
    public open?: string | null,
    public close?: string | null,
    public high?: string | null,
    public low?: string | null,
    public volume?: string | null,
    public turnover?: string | null,
    public timeType?: string | null,
    public symbol?: ISymbol | null
  ) {}
}
