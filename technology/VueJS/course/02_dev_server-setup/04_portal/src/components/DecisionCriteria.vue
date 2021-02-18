<template>
  <v-card class="mx-auto" max-width="400">
    <v-toolbar color="grey" dark>
      <v-toolbar-title>Exception details</v-toolbar-title>
    </v-toolbar>

    <v-list subheader three-line>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title>Message</v-list-item-title>
          <v-list-item-subtitle>Product Not Found</v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>

      <v-list-item>
        <v-list-item-content>
          <v-list-item-title>PO#</v-list-item-title>
          <v-list-item-subtitle>20201207_BJBBAL100</v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>

      <v-list-item>
        <v-list-item-content>
          <v-list-item-title>Decision Criteria#</v-list-item-title>
          <div v-for="criteria in dc" :key="criteria.title">
              <v-list-item-subtitle>{{criteria.title}}</v-list-item-subtitle>
        </div>
        </v-list-item-content>
      </v-list-item>
    </v-list>
    <v-divider></v-divider>
  </v-card>
</template>
<script>
export default {
  data: () => ({
    dc: [
      {
        title: "Order Entry Date",
      },
      {
        title: "Partner",
      },
      {
        title: "Material Number",
      },
    ],
  }),
};
</script>