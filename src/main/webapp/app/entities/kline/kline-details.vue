<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="kline">
        <h2 class="jh-entity-heading" data-cy="klineDetailsHeading">
          <span v-text="$t('gymbotApp.kline.detail.title')">Kline</span> {{ kline.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gymbotApp.kline.time')">Time</span>
          </dt>
          <dd>
            <span>{{ kline.time }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.kline.open')">Open</span>
          </dt>
          <dd>
            <span>{{ kline.open }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.kline.close')">Close</span>
          </dt>
          <dd>
            <span>{{ kline.close }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.kline.high')">High</span>
          </dt>
          <dd>
            <span>{{ kline.high }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.kline.low')">Low</span>
          </dt>
          <dd>
            <span>{{ kline.low }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.kline.volume')">Volume</span>
          </dt>
          <dd>
            <span>{{ kline.volume }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.kline.turnover')">Turnover</span>
          </dt>
          <dd>
            <span>{{ kline.turnover }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.kline.timeType')">Time Type</span>
          </dt>
          <dd>
            <span>{{ kline.timeType }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.kline.symbol')">Symbol</span>
          </dt>
          <dd>
            <div v-if="kline.symbol">
              <router-link :to="{ name: 'SymbolView', params: { symbolId: kline.symbol.id } }">{{ kline.symbol.symbol }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="kline.id" :to="{ name: 'KlineEdit', params: { klineId: kline.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./kline-details.component.ts"></script>
