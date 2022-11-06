<template>
  <div>
    <b-dropdown-item to="/symbol">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.symbol')">Symbol</span>
    </b-dropdown-item>
    <b-dropdown-item to="/kline">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.kline')">Kline</span>
    </b-dropdown-item>
    <!-- jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here -->
  </div>
</template>

<script lang="ts" src="./entities-menu.component.ts"></script>
