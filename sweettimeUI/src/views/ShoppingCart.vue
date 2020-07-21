<template>
  <div class="shoppingCart">
    <el-input-number
      v-model="num"
      controls-position="right"
      @change="handleChange"
      :min="1"
      :max="10"
    ></el-input-number>
  </div>
</template>

<script>
export default {
  name: "shoppingCart",
  data() {
    return {
      num: 1
    };
  },
  components: {},
  created() {},
  mounted() {},
  methods: {
    handleChange(value) {
      console.log(value);
    }
  }
};
</script>
<style lang='scss' scoped>
</style>
