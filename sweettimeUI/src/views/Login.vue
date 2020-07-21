<template>
  <div class="login">
    <div class="wrapper">
      <div class="container">
        <h1>Welcome</h1>

        <!-- 登录表单 -->
        <form class="form" action>
          <input type="text" placeholder="Username" id="username" />
          <input type="password" placeholder="Password" id="password" />
          <button type="button" id="login-button">登录</button>
        </form>
      </div>

      <!-- 背景上浮气泡 -->
      <ul class="bg-bubbles">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {};
  },
  components: {},
  created() {},
  mounted() {},
  methods: {}
};
</script>
<style lang='scss' scoped>
@import "../assets/css/style.scss";
</style>
