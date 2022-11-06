<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gymbotApp.kline.home.createOrEditLabel"
          data-cy="KlineCreateUpdateHeading"
          v-text="$t('gymbotApp.kline.home.createOrEditLabel')"
        >
          Create or edit a Kline
        </h2>
        <div>
          <div class="form-group" v-if="kline.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="kline.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.kline.time')" for="kline-time">Time</label>
            <input
              type="number"
              class="form-control"
              name="time"
              id="kline-time"
              data-cy="time"
              :class="{ valid: !$v.kline.time.$invalid, invalid: $v.kline.time.$invalid }"
              v-model.number="$v.kline.time.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.kline.open')" for="kline-open">Open</label>
            <input
              type="text"
              class="form-control"
              name="open"
              id="kline-open"
              data-cy="open"
              :class="{ valid: !$v.kline.open.$invalid, invalid: $v.kline.open.$invalid }"
              v-model="$v.kline.open.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.kline.close')" for="kline-close">Close</label>
            <input
              type="text"
              class="form-control"
              name="close"
              id="kline-close"
              data-cy="close"
              :class="{ valid: !$v.kline.close.$invalid, invalid: $v.kline.close.$invalid }"
              v-model="$v.kline.close.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.kline.high')" for="kline-high">High</label>
            <input
              type="text"
              class="form-control"
              name="high"
              id="kline-high"
              data-cy="high"
              :class="{ valid: !$v.kline.high.$invalid, invalid: $v.kline.high.$invalid }"
              v-model="$v.kline.high.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.kline.low')" for="kline-low">Low</label>
            <input
              type="text"
              class="form-control"
              name="low"
              id="kline-low"
              data-cy="low"
              :class="{ valid: !$v.kline.low.$invalid, invalid: $v.kline.low.$invalid }"
              v-model="$v.kline.low.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.kline.volume')" for="kline-volume">Volume</label>
            <input
              type="text"
              class="form-control"
              name="volume"
              id="kline-volume"
              data-cy="volume"
              :class="{ valid: !$v.kline.volume.$invalid, invalid: $v.kline.volume.$invalid }"
              v-model="$v.kline.volume.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.kline.turnover')" for="kline-turnover">Turnover</label>
            <input
              type="text"
              class="form-control"
              name="turnover"
              id="kline-turnover"
              data-cy="turnover"
              :class="{ valid: !$v.kline.turnover.$invalid, invalid: $v.kline.turnover.$invalid }"
              v-model="$v.kline.turnover.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.kline.timeType')" for="kline-timeType">Time Type</label>
            <input
              type="text"
              class="form-control"
              name="timeType"
              id="kline-timeType"
              data-cy="timeType"
              :class="{ valid: !$v.kline.timeType.$invalid, invalid: $v.kline.timeType.$invalid }"
              v-model="$v.kline.timeType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gymbotApp.kline.symbol')" for="kline-symbol">Symbol</label>
            <select class="form-control" id="kline-symbol" data-cy="symbol" name="symbol" v-model="kline.symbol">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="kline.symbol && symbolOption.id === kline.symbol.id ? kline.symbol : symbolOption"
                v-for="symbolOption in symbols"
                :key="symbolOption.id"
              >
                {{ symbolOption.symbol }}
              </option>
            </select>
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
            :disabled="$v.kline.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./kline-update.component.ts"></script>
