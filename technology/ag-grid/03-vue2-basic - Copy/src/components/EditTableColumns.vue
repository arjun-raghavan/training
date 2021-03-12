<template>
  <div v-if="show">
    <transition name="modal">
      <div class="modal-mask">
        <div class="modal-wrapper">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title">Select Columns To View</h5>
                <button
                  type="button"
                  class="close"
                  data-dismiss="modal"
                  aria-label="Close"
                >
                  <span aria-hidden="true" @click="closeModal">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <b-form-group>
                  <b-form-checkbox-group
                    v-model="selected"
                    :options="options"
                  ></b-form-checkbox-group>
                </b-form-group>
              </div>
              <div class="modal-footer">
                <button
                  type="button"
                  class="btn btn-primary"
                  @click="saveModal"
                >
                  Save changes
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </transition>
  </div>
</template>

<script>
import { eventBus } from "./../main.js";

export default {
  props: ["show", "selectedColumns"],
  data() {
    return {
      options: [
        { text: "Material Number", value: "F1", disabled: false },
        { text: "Order Type", value: "F2", disabled: false },
        { text: "Customer PO#", value: "F3", disabled: false },
        { text: "Customer Sold To", value: "F4", disabled: false },
        { value: "F5", text: "Material ID", disabled: false },
        { value: "F6", text: "Size", disabled: false },
        { value: "F7", text: "Qunatity", disabled: false },
        { value: "F8", text: "Contract #", disabled: false },
        { value: "F9", text: "Region Code", disabled: false },
        { value: "F10", text: "F10", disabled: false },
        { value: "F11", text: "F11", disabled: false },
        { value: "F12", text: "F12", disabled: false },
        { value: "F13", text: "F13", disabled: false },
        { value: "F14", text: "F14", disabled: false },
        { value: "F15", text: "F15", disabled: false },
        { value: "F16", text: "F16", disabled: false },
        { value: "F17", text: "F17", disabled: false },
        { value: "F18", text: "F18", disabled: false },
        { value: "F19", text: "F19", disabled: false },
        { value: "F20", text: "F20", disabled: false },
        { value: "F21", text: "F21", disabled: false },
        { value: "F22", text: "F22", disabled: false },
        { value: "F23", text: "F23", disabled: false },
        { value: "F24", text: "F24", disabled: false },
        { value: "F25", text: "F25", disabled: false },
        { value: "F26", text: "F26", disabled: false },
        { value: "F27", text: "F27", disabled: false },
      ],
      selected: [],
    };
  },
  methods: {
    saveModal() {
      console.log("Emit saveModal");
      eventBus.$emit("saveModal", this.selected);
    },
    closeModal() {
      console.log("closeModal");
      eventBus.$emit("closeModal", !this.show);
    },
  },
  beforeMount() {
    console.log(this.selectedColumns);
    this.selected = this.selectedColumns;
  },
};
</script>

<style scoped>
</style>
