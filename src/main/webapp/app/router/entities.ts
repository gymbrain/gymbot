import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore
const Entities = () => import('@/entities/entities.vue');

// prettier-ignore
const Symbol = () => import('@/entities/symbol/symbol.vue');
// prettier-ignore
const SymbolUpdate = () => import('@/entities/symbol/symbol-update.vue');
// prettier-ignore
const SymbolDetails = () => import('@/entities/symbol/symbol-details.vue');
// prettier-ignore
const Kline = () => import('@/entities/kline/kline.vue');
// prettier-ignore
const KlineUpdate = () => import('@/entities/kline/kline-update.vue');
// prettier-ignore
const KlineDetails = () => import('@/entities/kline/kline-details.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default {
  path: '/',
  component: Entities,
  children: [
    {
      path: 'symbol',
      name: 'Symbol',
      component: Symbol,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'symbol/new',
      name: 'SymbolCreate',
      component: SymbolUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'symbol/:symbolId/edit',
      name: 'SymbolEdit',
      component: SymbolUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'symbol/:symbolId/view',
      name: 'SymbolView',
      component: SymbolDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'kline',
      name: 'Kline',
      component: Kline,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'kline/new',
      name: 'KlineCreate',
      component: KlineUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'kline/:klineId/edit',
      name: 'KlineEdit',
      component: KlineUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'kline/:klineId/view',
      name: 'KlineView',
      component: KlineDetails,
      meta: { authorities: [Authority.USER] },
    },
    // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
  ],
};
