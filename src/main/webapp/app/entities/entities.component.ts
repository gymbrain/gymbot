import { Component, Provide, Vue } from 'vue-property-decorator';

import UserService from '@/entities/user/user.service';
import SymbolService from './symbol/symbol.service';
import KlineService from './kline/kline.service';
// jhipster-needle-add-entity-service-to-entities-component-import - JHipster will import entities services here

@Component
export default class Entities extends Vue {
  @Provide('userService') private userService = () => new UserService();
  @Provide('symbolService') private symbolService = () => new SymbolService();
  @Provide('klineService') private klineService = () => new KlineService();
  // jhipster-needle-add-entity-service-to-entities-component - JHipster will import entities services here
}
