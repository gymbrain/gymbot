<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="symbol">
        <h2 class="jh-entity-heading" data-cy="symbolDetailsHeading">
          <span v-text="$t('gymbotApp.symbol.detail.title')">Symbol</span> {{ symbol.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gymbotApp.symbol.symbol')">Symbol</span>
          </dt>
          <dd>
            <span>{{ symbol.symbol }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.name')">Name</span>
          </dt>
          <dd>
            <span>{{ symbol.name }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.baseCurrency')">Base Currency</span>
          </dt>
          <dd>
            <span>{{ symbol.baseCurrency }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.quoteCurrency')">Quote Currency</span>
          </dt>
          <dd>
            <span>{{ symbol.quoteCurrency }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.feeCurrency')">Fee Currency</span>
          </dt>
          <dd>
            <span>{{ symbol.feeCurrency }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.market')">Market</span>
          </dt>
          <dd>
            <span>{{ symbol.market }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.baseMinSize')">Base Min Size</span>
          </dt>
          <dd>
            <span>{{ symbol.baseMinSize }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.quoteMinSize')">Quote Min Size</span>
          </dt>
          <dd>
            <span>{{ symbol.quoteMinSize }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.baseMaxSize')">Base Max Size</span>
          </dt>
          <dd>
            <span>{{ symbol.baseMaxSize }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.quoteMaxSize')">Quote Max Size</span>
          </dt>
          <dd>
            <span>{{ symbol.quoteMaxSize }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.baseIncrement')">Base Increment</span>
          </dt>
          <dd>
            <span>{{ symbol.baseIncrement }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.quoteIncrement')">Quote Increment</span>
          </dt>
          <dd>
            <span>{{ symbol.quoteIncrement }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.priceIncrement')">Price Increment</span>
          </dt>
          <dd>
            <span>{{ symbol.priceIncrement }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.priceLimitRate')">Price Limit Rate</span>
          </dt>
          <dd>
            <span>{{ symbol.priceLimitRate }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.minFunds')">Min Funds</span>
          </dt>
          <dd>
            <span>{{ symbol.minFunds }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.isMarginEnabled')">Is Margin Enabled</span>
          </dt>
          <dd>
            <span>{{ symbol.isMarginEnabled }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.enableTrading')">Enable Trading</span>
          </dt>
          <dd>
            <span>{{ symbol.enableTrading }}</span>
          </dd>
          <dt>
            <span v-text="$t('gymbotApp.symbol.active')">Active</span>
          </dt>
          <dd>
            <span>{{ symbol.active }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="symbol.id" :to="{ name: 'SymbolEdit', params: { symbolId: symbol.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./symbol-details.component.ts"></script>
