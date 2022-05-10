<template>
  <div class="bg-gray-200">
    <main class="main-content mt-0">
      <div
        class="page-header align-items-start min-vh-100"
        style="
          background-image: url('https://cdn.discordapp.com/attachments/901731363844132894/912234465156276244/house-1477041.jpg');
        "
      >
        <span class="mask bg-gradient-dark opacity-6"></span>
        <div class="container my-auto">
          <div class="row">
            <div class="col-lg-4 col-md-8 col-12 mx-auto">
              <div class="card z-index-0 fadeIn3 fadeInBottom">
                <div
                  class="card-header p-0 position-relative mt-n4 mx-3 z-index-2"
                >
                  <div
                    class="shadow-secondary border-radius-lg py-3 pe-1"
                    style="background-color: #9a6856"
                  >
                    <h4
                      class="
                        text-white
                        font-weight-bolder
                        text-center
                        mt-2
                        mb-0
                      "
                    >
                      Login
                    </h4>
                    <!-- <div class="row mt-3">
                      <div class="col-2 text-center ms-auto">
                        <a class="btn btn-link px-3" href="javascript:;">
                          <i class="fa fa-facebook text-white text-lg"></i>
                        </a>
                      </div>
                      <div class="col-2 text-center px-1">
                        <a class="btn btn-link px-3" href="javascript:;">
                          <i class="fa fa-github text-white text-lg"></i>
                        </a>
                      </div>
                      <div class="col-2 text-center me-auto">
                        <a class="btn btn-link px-3" href="javascript:;">
                          <i class="fa fa-google text-white text-lg"></i>
                        </a>
                      </div>
                    </div> -->
                    <br />
                  </div>
                </div>
                <div class="card-body">
                  <form role="form" class="text-start">
                    <div class="input-group input-group-outline my-3">
                      <!-- <label class="form-label">Email</label> -->
                      <input
                        type="email"
                        class="form-control"
                        v-model="$store.state.user.userId"
                        placeholder="Id"
                      />
                    </div>
                    <div class="input-group input-group-outline mb-3">
                      <!-- <label class="form-label">Password</label> -->
                      <input
                        type="password"
                        class="form-control"
                        v-model="$store.state.user.userPassword"
                        placeholder="Password"
                        @keyup.enter="login"
                      />
                    </div>
                    <!-- <div
                      class="
                        form-check form-switch
                        d-flex
                        align-items-center
                        mb-3
                      "
                    >
                      <input
                        class="form-check-input"
                        type="checkbox"
                        id="rememberMe"
                      />
                      <label class="form-check-label mb-0 ms-2" for="rememberMe"
                        >Remember me</label
                      >
                    </div> -->
                    <div class="text-center">
                      <button
                        type="button"
                        class="btn w-100 my-4 mb-2"
                        @click="login"
                        style="background-color: #9a6856; color: white"
                      >
                        로그인
                      </button>
                    </div>
                    <p class="mt-4 text-sm text-center">
                      계정이 없으신가요?
                      <router-link
                        to="/register"
                        class="text-gradient font-weight-bold"
                        style="background-color: #9a6856"
                        >회원 가입하기</router-link
                      >
                      <!-- <a
                        style="cursor: pointer"
                        @click="register"
                        class="text-primary text-gradient font-weight-bold"
                        >Sign up</a
                      > -->
                    </p>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- <footer class="footer position-absolute bottom-2 py-2 w-100">
          <div class="container">
            <div class="row align-items-center justify-content-lg-between">
              <div class="col-12 col-md-6 my-auto">
                <div
                  class="copyright text-center text-sm text-white text-lg-start"
                >
                  ©
                  <script>
                    document.write(new Date().getFullYear());
                  </script>
                  , made with <i class="fa fa-heart" aria-hidden="true"></i> by
                  <a
                    href="https://www.creative-tim.com"
                    class="font-weight-bold text-white"
                    target="_blank"
                    >Creative Tim</a
                  >
                  for a better web.
                </div>
              </div>
              <div class="col-12 col-md-6">
                <ul
                  class="
                    nav nav-footer
                    justify-content-center justify-content-lg-end
                  "
                >
                  <li class="nav-item">
                    <a
                      href="https://www.creative-tim.com"
                      class="nav-link text-white"
                      target="_blank"
                      >Creative Tim</a
                    >
                  </li>
                  <li class="nav-item">
                    <a
                      href="https://www.creative-tim.com/presentation"
                      class="nav-link text-white"
                      target="_blank"
                      >About Us</a
                    >
                  </li>
                  <li class="nav-item">
                    <a
                      href="https://www.creative-tim.com/blog"
                      class="nav-link text-white"
                      target="_blank"
                      >Blog</a
                    >
                  </li>
                  <li class="nav-item">
                    <a
                      href="https://www.creative-tim.com/license"
                      class="nav-link pe-0 text-white"
                      target="_blank"
                      >License</a
                    >
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </footer> -->
      </div>
    </main>
  </div>
</template>

<script>
import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);

import http from "@/common/axios.js";
export default {
  created() {
    this.$store.commit("SET_USER", {
      isLogin: false,
      userName: "",
      userSeq: 0,
      userEmail: "",
      userId: "",
      userPassword: "",
    });
  },
  methods: {
    login() {
      http
        .post("/login", {
          userId: this.$store.state.user.userId,
          userPassword: this.$store.state.user.userPassword,
        })
        .then(({ data }) => {
          console.log("LoginVue: data : ");
          console.log(data);

          // $emit 사용 X
          // login 성공 전달
          //this.$emit('call-parent-loginSuccess', {userName: data.userName, userProfileImageUrl: data.userProfileImageUrl});

          // isLogin 포함 mutator 호출
          this.$store.commit("SET_USER", {
            isLogin: true,
            userName: data.userName,
            userSeq: data.userSeq,
            userEmail: data.userEmail,
            userId: data.userId,
            userPassword: data.userPassword,
          });

          // board 로 이동
          // this.$router.push("/board")
          // this.$alertify.success("로그인 완료");
          // this.$alertify.alert("로그인", "로그인 성공").set({
          //   onshow: null,
          //   onclose: function () {
          //     this.$router.push("/board");
          //   },
          // });

          this.$alertify.alert("로그인", "로그인 성공");

          this.$router.push("/");
        })
        .catch((error) => {
          console.log(error.response);
          console.log("LoginVue: error : ");
          console.log(error);
          if (error.response.status == "404") {
            this.$alertify.error("아이디 또는 비밀번호를 확인하세요.");
          } else {
            this.$alertify.error("아이디 또는 비밀번호를 확인하세요.");
          }
        });
    },
  },
};
</script>

<style></style>
