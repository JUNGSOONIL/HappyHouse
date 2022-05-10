import Vue from "vue"; // defalut module
import VueRouter from "vue-router"; // installed module

Vue.use(VueRouter);

import Main from "@/components/pages/Main.vue";
import Login from "@/components/pages/Login.vue";
import User from "@/components/pages/User.vue";
import Register from "@/components/pages/Register.vue";
import Board from "@/components/pages/Board.vue";
import Apt from "@/components/pages/Apt.vue";
import Notice from "@/components/pages/Notice.vue";
import store from "@/store/store.js";

export default new VueRouter({
  routes: [
    {
      path: "/",
      component: Main,
    },

    {
      name: "Login",
      path: "/login",
      component: Login,
    },

    {
      name: "Register",
      path: "/register",
      component: Register,
    },

    {
      name: "User",
      path: "/user",
      component: User,
      beforeEnter: (to, from, next) => {
        console.log(store.state.user.isLogin);
        if (!store.state.user.isLogin) {
          next("/login");
        } else {
          return next();
        }
      },
    },

    {
      name: "Board",
      path: "/board",
      component: Board,
    },

    {
      name: "Notice",
      path: "/notice",
      component: Notice,
    },

    {
      name: "Apt",
      path: "/apt",
      component: Apt,
      beforeEnter: (to, from, next) => {
        console.log(store.state.user.isLogin);
        if (!store.state.user.isLogin) {
          next("/login");
        } else {
          return next();
        }
      },
    },
  ],
});
