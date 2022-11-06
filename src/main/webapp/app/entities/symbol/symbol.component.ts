import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ISymbol } from '@/shared/model/symbol.model';

import SymbolService from './symbol.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Symbol extends Vue {
  @Inject('symbolService') private symbolService: () => SymbolService;
  @Inject('alertService') private alertService: () => AlertService;

  public currentSearch = '';
  private removeId: number = null;
  public itemsPerPage = 20;
  public queryCount: number = null;
  public page = 1;
  public previousPage = 1;
  public propOrder = 'id';
  public reverse = false;
  public totalItems = 0;

  public symbols: ISymbol[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllSymbols();
  }

  public search(query): void {
    if (!query) {
      return this.clear();
    }
    this.currentSearch = query;
    this.retrieveAllSymbols();
  }

  public clear(): void {
    this.currentSearch = '';
    this.page = 1;
    this.retrieveAllSymbols();
  }

  public retrieveAllSymbols(): void {
    this.isFetching = true;
    const paginationQuery = {
      page: this.page - 1,
      size: this.itemsPerPage,
      sort: this.sort(),
    };
    if (this.currentSearch) {
      this.symbolService()
        .search(this.currentSearch, paginationQuery)
        .then(
          res => {
            this.symbols = res.data;
            this.totalItems = Number(res.headers['x-total-count']);
            this.queryCount = this.totalItems;
            this.isFetching = false;
          },
          err => {
            this.isFetching = false;
            this.alertService().showHttpError(this, err.response);
          }
        );
      return;
    }
    this.symbolService()
      .retrieve(paginationQuery)
      .then(
        res => {
          this.symbols = res.data;
          this.totalItems = Number(res.headers['x-total-count']);
          this.queryCount = this.totalItems;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
          this.alertService().showHttpError(this, err.response);
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public prepareRemove(instance: ISymbol): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeSymbol(): void {
    this.symbolService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('gymbotApp.symbol.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllSymbols();
        this.closeDialog();
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public sort(): Array<any> {
    const result = [this.propOrder + ',' + (this.reverse ? 'desc' : 'asc')];
    if (this.propOrder !== 'id') {
      result.push('id');
    }
    return result;
  }

  public loadPage(page: number): void {
    if (page !== this.previousPage) {
      this.previousPage = page;
      this.transition();
    }
  }

  public transition(): void {
    this.retrieveAllSymbols();
  }

  public changeOrder(propOrder): void {
    this.propOrder = propOrder;
    this.reverse = !this.reverse;
    this.transition();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
