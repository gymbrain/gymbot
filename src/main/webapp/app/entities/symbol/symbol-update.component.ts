import { Component, Vue, Inject } from 'vue-property-decorator';

import { required } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import { ISymbol, Symbol } from '@/shared/model/symbol.model';
import SymbolService from './symbol.service';

const validations: any = {
  symbol: {
    symbol: {
      required,
    },
    name: {
      required,
    },
    baseCurrency: {},
    quoteCurrency: {},
    feeCurrency: {},
    market: {},
    baseMinSize: {},
    quoteMinSize: {},
    baseMaxSize: {},
    quoteMaxSize: {},
    baseIncrement: {},
    quoteIncrement: {},
    priceIncrement: {},
    priceLimitRate: {},
    minFunds: {},
    isMarginEnabled: {},
    enableTrading: {},
    active: {},
  },
};

@Component({
  validations,
})
export default class SymbolUpdate extends Vue {
  @Inject('symbolService') private symbolService: () => SymbolService;
  @Inject('alertService') private alertService: () => AlertService;

  public symbol: ISymbol = new Symbol();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.symbolId) {
        vm.retrieveSymbol(to.params.symbolId);
      }
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.symbol.id) {
      this.symbolService()
        .update(this.symbol)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gymbotApp.symbol.updated', { param: param.id });
          return (this.$root as any).$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        })
        .catch(error => {
          this.isSaving = false;
          this.alertService().showHttpError(this, error.response);
        });
    } else {
      this.symbolService()
        .create(this.symbol)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gymbotApp.symbol.created', { param: param.id });
          (this.$root as any).$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Success',
            variant: 'success',
            solid: true,
            autoHideDelay: 5000,
          });
        })
        .catch(error => {
          this.isSaving = false;
          this.alertService().showHttpError(this, error.response);
        });
    }
  }

  public retrieveSymbol(symbolId): void {
    this.symbolService()
      .find(symbolId)
      .then(res => {
        this.symbol = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
