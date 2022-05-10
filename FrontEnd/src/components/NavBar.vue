<template>
  <div class="container position-sticky z-index-sticky top-0">
    <nav
      class="
        navbar navbar-expand-lg
        blur
        border-radius-lg
        top-0
        z-index-3
        shadow
        position-absolute
        mt-4
        py-2
        start-0
        end-0
        mx-4
      "
    >
      <div class="container-fluid ps-2 pe-0">
        <router-link
          to="/"
          class="navbar-brand font-weight-bolder ms-lg-0 ms-3"
        >
          HappyHouse</router-link
        >
        <button
          class="navbar-toggler shadow-none ms-2"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navigation"
          aria-controls="navigation"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon mt-2">
            <span class="navbar-toggler-bar bar1"></span>
            <span class="navbar-toggler-bar bar2"></span>
            <span class="navbar-toggler-bar bar3"></span>
          </span>
        </button>
        <div class="collapse navbar-collapse" id="navigation">
          <ul class="navbar-nav mx-auto">
            <li class="nav-item">
              <router-link to="/" class="nav-link me-2">
                <i class="fa fa-pager opacity-6 text-dark me-1"></i>
                Home
              </router-link>
            </li>
            <li class="nav-item">
              <router-link to="/apt" class="nav-link me-2" id="Nav_Apt">
                <i class="fa fa-home opacity-6 text-dark me-1"></i>
                Apt
              </router-link>
            </li>
            <li class="nav-item">
              <router-link to="/board" class="nav-link me-2">
                <i class="fa fa-list-ul opacity-6 text-dark me-1"></i>
                Board
              </router-link>
            </li>
            <li class="nav-item">
              <router-link to="/notice" class="nav-link me-2">
                <i class="fa fa-list-ul opacity-6 text-dark me-1"></i>
                Notice
              </router-link>
            </li>
            <li class="nav-item">
              <router-link to="/user" class="nav-link me-2">
                <i class="fa fa-user opacity-6 text-dark me-1"></i>
                User
              </router-link>
            </li>
          </ul>

          <div v-show="this.$store.state.user.isLogin">
            안녕하세요 <strong>{{ this.$store.state.user.userName }}</strong
            >님
          </div>
          <ul class="navbar-nav d-lg-block d-none">
            <a
              class="nav-link me-2"
              v-if="$store.state.user.isLogin"
              @click="logout"
              style="cursor: pointer"
            >
              <i class="fa fa-key opacity-6 text-dark me-1"></i>
              Logout
            </a>
            <router-link to="/login" class="nav-link me-2" v-else>
              <i class="fa fa-key opacity-6 text-dark me-1"></i>
              Login
            </router-link>
          </ul>
        </div>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  methods: {
    logout() {
      this.$alertify.confirm("로그아웃 하시겠습니까?", () => {
        this.$store.commit("SET_USER", {
          isLogin: false,
          userName: "",
          userSeq: 0,
          userEmail: "",
          userId: "",
          userPassword: "",
        });

        this.$alertify.alert("로그아웃", "로그아웃 성공");

        this.$router.push("/");
      });
    },
  },
};
</script>

<style></style>
