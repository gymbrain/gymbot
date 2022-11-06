import { Component, Vue, Inject } from 'vue-property-decorator';

import { ISymbol } from '@/shared/model/symbol.model';
import SymbolService from './symbol.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class SymbolDetails extends Vue {
  @Inject('symbolService') private symbolService: () => SymbolService;
  @Inject('alertService') private alertService: () => AlertService;

  public symbol: ISymbol = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.symbolId) {
        vm.retrieveSymbol(to.params.symbolId);
      }
    });
  }

  public retrieveSymbol(symbolId) {
    this.symbolService()
      .find(symbolId)
      .then(res => {
        this.symbol = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
