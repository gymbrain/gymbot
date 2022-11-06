<template>
  <div>
    <h2 id="page-heading" data-cy="SymbolHeading">
      <span v-text="$t('gymbotApp.symbol.home.title')" id="symbol-heading">Symbols</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gymbotApp.symbol.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'SymbolCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-symbol"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gymbotApp.symbol.home.createLabel')"> Create a new Symbol </span>
          </button>
        </router-link>
      </div>
    </h2>
    <div class="row">
      <div class="col-sm-12">
        <form name="searchForm" class="form-inline" v-on:submit.prevent="search(currentSearch)">
          <div class="input-group w-100 mt-3">
            <input
              type="text"
              class="form-control"
              name="currentSearch"
              id="currentSearch"
              v-bind:placeholder="$t('gymbotApp.symbol.home.search')"
              v-model="currentSearch"
            />
            <button type="button" id="launch-search" class="btn btn-primary" v-on:click="search(currentSearch)">
              <font-awesome-icon icon="search"></font-awesome-icon>
            </button>
            <button type="button" id="clear-search" class="btn btn-secondary" v-on:click="clear()" v-if="currentSearch">
              <font-awesome-icon icon="trash"></font-awesome-icon>
            </button>
          </div>
        </form>
      </div>
    </div>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && symbols && symbols.length === 0">
      <span v-text="$t('gymbotApp.symbol.home.notFound')">No symbols found</span>
    </div>
    <div class="table-responsive" v-if="symbols && symbols.length > 0">
      <table class="table table-striped" aria-describedby="symbols">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('symbol')">
              <span v-text="$t('gymbotApp.symbol.symbol')">Symbol</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'symbol'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('name')">
              <span v-text="$t('gymbotApp.symbol.name')">Name</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'name'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('baseCurrency')">
              <span v-text="$t('gymbotApp.symbol.baseCurrency')">Base Currency</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'baseCurrency'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('quoteCurrency')">
              <span v-text="$t('gymbotApp.symbol.quoteCurrency')">Quote Currency</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'quoteCurrency'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeCurrency')">
              <span v-text="$t('gymbotApp.symbol.feeCurrency')">Fee Currency</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeCurrency'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('market')">
              <span v-text="$t('gymbotApp.symbol.market')">Market</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'market'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('baseMinSize')">
              <span v-text="$t('gymbotApp.symbol.baseMinSize')">Base Min Size</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'baseMinSize'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('quoteMinSize')">
              <span v-text="$t('gymbotApp.symbol.quoteMinSize')">Quote Min Size</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'quoteMinSize'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('baseMaxSize')">
              <span v-text="$t('gymbotApp.symbol.baseMaxSize')">Base Max Size</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'baseMaxSize'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('quoteMaxSize')">
              <span v-text="$t('gymbotApp.symbol.quoteMaxSize')">Quote Max Size</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'quoteMaxSize'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('baseIncrement')">
              <span v-text="$t('gymbotApp.symbol.baseIncrement')">Base Increment</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'baseIncrement'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('quoteIncrement')">
              <span v-text="$t('gymbotApp.symbol.quoteIncrement')">Quote Increment</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'quoteIncrement'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('priceIncrement')">
              <span v-text="$t('gymbotApp.symbol.priceIncrement')">Price Increment</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'priceIncrement'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('priceLimitRate')">
              <span v-text="$t('gymbotApp.symbol.priceLimitRate')">Price Limit Rate</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'priceLimitRate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('minFunds')">
              <span v-text="$t('gymbotApp.symbol.minFunds')">Min Funds</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'minFunds'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('isMarginEnabled')">
              <span v-text="$t('gymbotApp.symbol.isMarginEnabled')">Is Margin Enabled</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'isMarginEnabled'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('enableTrading')">
              <span v-text="$t('gymbotApp.symbol.enableTrading')">Enable Trading</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'enableTrading'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('active')">
              <span v-text="$t('gymbotApp.symbol.active')">Active</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'active'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="symbol in symbols" :key="symbol.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'SymbolView', params: { symbolId: symbol.id } }">{{ symbol.id }}</router-link>
            </td>
            <td>{{ symbol.symbol }}</td>
            <td>{{ symbol.name }}</td>
            <td>{{ symbol.baseCurrency }}</td>
            <td>{{ symbol.quoteCurrency }}</td>
            <td>{{ symbol.feeCurrency }}</td>
            <td>{{ symbol.market }}</td>
            <td>{{ symbol.baseMinSize }}</td>
            <td>{{ symbol.quoteMinSize }}</td>
            <td>{{ symbol.baseMaxSize }}</td>
            <td>{{ symbol.quoteMaxSize }}</td>
            <td>{{ symbol.baseIncrement }}</td>
            <td>{{ symbol.quoteIncrement }}</td>
            <td>{{ symbol.priceIncrement }}</td>
            <td>{{ symbol.priceLimitRate }}</td>
            <td>{{ symbol.minFunds }}</td>
            <td>{{ symbol.isMarginEnabled }}</td>
            <td>{{ symbol.enableTrading }}</td>
            <td>{{ symbol.active }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'SymbolView', params: { symbolId: symbol.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'SymbolEdit', params: { symbolId: symbol.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(symbol)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="gymbotApp.symbol.delete.question" data-cy="symbolDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-symbol-heading" v-text="$t('gymbotApp.symbol.delete.question', { id: removeId })">
          Are you sure you want to delete this Symbol?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-symbol"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeSymbol()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="symbols && symbols.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./symbol.component.ts"></script>
