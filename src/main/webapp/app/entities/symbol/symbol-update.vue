<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gymbotApp.symbol.home.createOrEditLabel"
          data-cy="SymbolCreateUpdateHeading"
          v-text="$t('gymbotApp.symbol.home.createOrEditLabel')"
        >
          Create or edit a Symbol
        </h2>
        <div>
          <div class="form-group" v-if="symbol.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="symbol.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.symbol')" for="symbol-symbol">Symbol</label>
            <input
              type="text"
              class="form-control"
              name="symbol"
              id="symbol-symbol"
              data-cy="symbol"
              :class="{ valid: !$v.symbol.symbol.$invalid, invalid: $v.symbol.symbol.$invalid }"
              v-model="$v.symbol.symbol.$model"
              required
            />
            <div v-if="$v.symbol.symbol.$anyDirty && $v.symbol.symbol.$invalid">
              <small class="form-text text-danger" v-if="!$v.symbol.symbol.required" v-text="$t('entity.validation.required')">
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.name')" for="symbol-name">Name</label>
            <input
              type="text"
              class="form-control"
              name="name"
              id="symbol-name"
              data-cy="name"
              :class="{ valid: !$v.symbol.name.$invalid, invalid: $v.symbol.name.$invalid }"
              v-model="$v.symbol.name.$model"
              required
            />
            <div v-if="$v.symbol.name.$anyDirty && $v.symbol.name.$invalid">
              <small class="form-text text-danger" v-if="!$v.symbol.name.required" v-text="$t('entity.validation.required')">
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.baseCurrency')" for="symbol-baseCurrency">Base Currency</label>
            <input
              type="text"
              class="form-control"
              name="baseCurrency"
              id="symbol-baseCurrency"
              data-cy="baseCurrency"
              :class="{ valid: !$v.symbol.baseCurrency.$invalid, invalid: $v.symbol.baseCurrency.$invalid }"
              v-model="$v.symbol.baseCurrency.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.quoteCurrency')" for="symbol-quoteCurrency"
              >Quote Currency</label
            >
            <input
              type="text"
              class="form-control"
              name="quoteCurrency"
              id="symbol-quoteCurrency"
              data-cy="quoteCurrency"
              :class="{ valid: !$v.symbol.quoteCurrency.$invalid, invalid: $v.symbol.quoteCurrency.$invalid }"
              v-model="$v.symbol.quoteCurrency.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.feeCurrency')" for="symbol-feeCurrency">Fee Currency</label>
            <input
              type="text"
              class="form-control"
              name="feeCurrency"
              id="symbol-feeCurrency"
              data-cy="feeCurrency"
              :class="{ valid: !$v.symbol.feeCurrency.$invalid, invalid: $v.symbol.feeCurrency.$invalid }"
              v-model="$v.symbol.feeCurrency.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.market')" for="symbol-market">Market</label>
            <input
              type="text"
              class="form-control"
              name="market"
              id="symbol-market"
              data-cy="market"
              :class="{ valid: !$v.symbol.market.$invalid, invalid: $v.symbol.market.$invalid }"
              v-model="$v.symbol.market.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.baseMinSize')" for="symbol-baseMinSize">Base Min Size</label>
            <input
              type="text"
              class="form-control"
              name="baseMinSize"
              id="symbol-baseMinSize"
              data-cy="baseMinSize"
              :class="{ valid: !$v.symbol.baseMinSize.$invalid, invalid: $v.symbol.baseMinSize.$invalid }"
              v-model="$v.symbol.baseMinSize.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.quoteMinSize')" for="symbol-quoteMinSize">Quote Min Size</label>
            <input
              type="text"
              class="form-control"
              name="quoteMinSize"
              id="symbol-quoteMinSize"
              data-cy="quoteMinSize"
              :class="{ valid: !$v.symbol.quoteMinSize.$invalid, invalid: $v.symbol.quoteMinSize.$invalid }"
              v-model="$v.symbol.quoteMinSize.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.baseMaxSize')" for="symbol-baseMaxSize">Base Max Size</label>
            <input
              type="text"
              class="form-control"
              name="baseMaxSize"
              id="symbol-baseMaxSize"
              data-cy="baseMaxSize"
              :class="{ valid: !$v.symbol.baseMaxSize.$invalid, invalid: $v.symbol.baseMaxSize.$invalid }"
              v-model="$v.symbol.baseMaxSize.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.quoteMaxSize')" for="symbol-quoteMaxSize">Quote Max Size</label>
            <input
              type="text"
              class="form-control"
              name="quoteMaxSize"
              id="symbol-quoteMaxSize"
              data-cy="quoteMaxSize"
              :class="{ valid: !$v.symbol.quoteMaxSize.$invalid, invalid: $v.symbol.quoteMaxSize.$invalid }"
              v-model="$v.symbol.quoteMaxSize.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.baseIncrement')" for="symbol-baseIncrement"
              >Base Increment</label
            >
            <input
              type="text"
              class="form-control"
              name="baseIncrement"
              id="symbol-baseIncrement"
              data-cy="baseIncrement"
              :class="{ valid: !$v.symbol.baseIncrement.$invalid, invalid: $v.symbol.baseIncrement.$invalid }"
              v-model="$v.symbol.baseIncrement.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.quoteIncrement')" for="symbol-quoteIncrement"
              >Quote Increment</label
            >
            <input
              type="text"
              class="form-control"
              name="quoteIncrement"
              id="symbol-quoteIncrement"
              data-cy="quoteIncrement"
              :class="{ valid: !$v.symbol.quoteIncrement.$invalid, invalid: $v.symbol.quoteIncrement.$invalid }"
              v-model="$v.symbol.quoteIncrement.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.priceIncrement')" for="symbol-priceIncrement"
              >Price Increment</label
            >
            <input
              type="text"
              class="form-control"
              name="priceIncrement"
              id="symbol-priceIncrement"
              data-cy="priceIncrement"
              :class="{ valid: !$v.symbol.priceIncrement.$invalid, invalid: $v.symbol.priceIncrement.$invalid }"
              v-model="$v.symbol.priceIncrement.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.priceLimitRate')" for="symbol-priceLimitRate"
              >Price Limit Rate</label
            >
            <input
              type="text"
              class="form-control"
              name="priceLimitRate"
              id="symbol-priceLimitRate"
              data-cy="priceLimitRate"
              :class="{ valid: !$v.symbol.priceLimitRate.$invalid, invalid: $v.symbol.priceLimitRate.$invalid }"
              v-model="$v.symbol.priceLimitRate.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.minFunds')" for="symbol-minFunds">Min Funds</label>
            <input
              type="text"
              class="form-control"
              name="minFunds"
              id="symbol-minFunds"
              data-cy="minFunds"
              :class="{ valid: !$v.symbol.minFunds.$invalid, invalid: $v.symbol.minFunds.$invalid }"
              v-model="$v.symbol.minFunds.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.isMarginEnabled')" for="symbol-isMarginEnabled"
              >Is Margin Enabled</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="isMarginEnabled"
              id="symbol-isMarginEnabled"
              data-cy="isMarginEnabled"
              :class="{ valid: !$v.symbol.isMarginEnabled.$invalid, invalid: $v.symbol.isMarginEnabled.$invalid }"
              v-model="$v.symbol.isMarginEnabled.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.enableTrading')" for="symbol-enableTrading"
              >Enable Trading</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="enableTrading"
              id="symbol-enableTrading"
              data-cy="enableTrading"
              :class="{ valid: !$v.symbol.enableTrading.$invalid, invalid: $v.symbol.enableTrading.$invalid }"
              v-model="$v.symbol.enableTrading.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.symbol.active')" for="symbol-active">Active</label>
            <input
              type="checkbox"
              class="form-check"
              name="active"
              id="symbol-active"
              data-cy="active"
              :class="{ valid: !$v.symbol.active.$invalid, invalid: $v.symbol.active.$invalid }"
              v-model="$v.symbol.active.$model"
            />
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" data-cy="entityCreateCancelButton" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.symbol.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./symbol-update.component.ts"></script>
