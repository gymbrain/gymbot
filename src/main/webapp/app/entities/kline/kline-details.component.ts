import { Component, Vue, Inject } from 'vue-property-decorator';

import { IKline } from '@/shared/model/kline.model';
import KlineService from './kline.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class KlineDetails extends Vue {
  @Inject('klineService') private klineService: () => KlineService;
  @Inject('alertService') private alertService: () => AlertService;

  public kline: IKline = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.klineId) {
        vm.retrieveKline(to.params.klineId);
      }
    });
  }

  public retrieveKline(klineId) {
    this.klineService()
      .find(klineId)
      .then(res => {
        this.kline = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
