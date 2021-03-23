<template>
  <div>
    <b-card-group deck>
      <b-card
        header-tag="header"
        footer-tag="footer"
      >
        <b-card-text>{{carddata.caseId}}</b-card-text>
      </b-card>

    </b-card-group>
  </div>
</template>


<script>

export default {
  props: ["carddata"],
}
</script>

<style scoped>
</style>
