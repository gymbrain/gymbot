import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import SymbolService from '@/entities/base/symbol/symbol.service';
import { ISymbol } from '@/shared/model/base/symbol.model';

import { IKline, Kline } from '@/shared/model/kline.model';
import KlineService from './kline.service';

const validations: any = {
  kline: {
    time: {},
    open: {},
    close: {},
    high: {},
    low: {},
    volume: {},
    turnover: {},
    timeType: {},
  },
};

@Component({
  validations,
})
export default class KlineUpdate extends Vue {
  @Inject('klineService') private klineService: () => KlineService;
  @Inject('alertService') private alertService: () => AlertService;

  public kline: IKline = new Kline();

  @Inject('symbolService') private symbolService: () => SymbolService;

  public symbols: ISymbol[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.klineId) {
        vm.retrieveKline(to.params.klineId);
      }
      vm.initRelationships();
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
    if (this.kline.id) {
      this.klineService()
        .update(this.kline)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gymbotApp.kline.updated', { param: param.id });
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
      this.klineService()
        .create(this.kline)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gymbotApp.kline.created', { param: param.id });
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

  public retrieveKline(klineId): void {
    this.klineService()
      .find(klineId)
      .then(res => {
        this.kline = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.symbolService()
      .retrieve()
      .then(res => {
        this.symbols = res.data;
      });
  }
}
