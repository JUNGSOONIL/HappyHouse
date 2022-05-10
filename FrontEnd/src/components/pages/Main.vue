<template>
  <main
    class="
      main-content
      position-relative
      max-height-vh-100
      h-100
      border-radius-lg
    "
  >
    <br />
    <br />
    <br />
    <br />
    <div class="container-fluid px-2 px-md-4">
      <div
        class="page-header min-height-300 border-radius-xl mt-4"
        style="
          background-image: url('https://cdn.discordapp.com/attachments/901731363844132894/912236103304642620/panorama-2646143_1920.jpg');
        "
      ></div>
      <div class="card card-body mx-3 mx-md-4 mt-n6">
        <div class="row">
          <div class="col-12 mt-4 col-xl-12">
            <div class="mb-5 ps-3">
              <h5 class="mb-1">인기 매물</h5>
            </div>
            <div class="row">
              <div
                class="col-xl-3 col-md-6 mb-xl-0 mb-4"
                v-for="(item, index) in this.$store.state.houses
                  .popularHouseList"
                :key="index"
              >
                <div class="card card-blog card-plain">
                  <div class="card-header p-0 mt-n4 mx-3">
                    <a class="d-block shadow-xl border-radius-xl">
                      <img
                        v-bind:src="imglist[index]"
                        alt="img-blur-shadow"
                        class="img-fluid shadow border-radius-xl"
                        style="height: 242px; cursor: pointer"
                        @click="showAptModal(item)"
                      />
                    </a>
                  </div>
                  <div class="card-body p-3">
                    <p class="mb-0 text-sm">{{ index + 1 }}위</p>
                    <!-- <a href="javascript:;"> -->
                    <h5>
                      {{ item.aptName }}
                    </h5>
                    <!-- </a> -->
                    <p class="mb-4 text-sm">
                      {{
                        item.sidoName +
                        " " +
                        item.gugunName +
                        " " +
                        item.dongName +
                        " " +
                        item.jibun
                      }}
                    </p>
                  </div>
                </div>
              </div>
              <!--  -->

              <!--  -->
              <div class="col-xl-3 col-md-6 mb-xl-0 mb-4 mt-n7">
                <div
                  class="card card-plain h-100 pb-0"
                  v-if="!this.$store.state.user.isLogin"
                  style="border-color: white"
                >
                  <div
                    class="card-header pb-0 p-3"
                    style="background-color: white; border-color: white"
                  >
                    <h5 class="mb-1 mt-2">배너</h5>
                  </div>
                  <div
                    id="carouselExampleControls"
                    class="carousel slide"
                    data-bs-ride="carousel"
                  >
                    <div class="carousel-inner mb-0">
                      <div class="carousel-item">
                        <div
                          class="page-header min-vh-35 m-3 border-radius-xl"
                          style="
                            background-image: url('https://demos.creative-tim.com/test/material-dashboard-pro/assets/img/products/product-3-min.jpg');
                          "
                        >
                          <span class="mask bg-gradient-secondary"></span>
                          <div class="container">
                            <div class="row">
                              <div class="col-lg-6 my-auto">
                                <h2 class="text-white mb-2">HAPPY HOUSE</h2>
                                <p
                                  class="
                                    lead
                                    text-white
                                    opacity-8
                                    fadeIn3
                                    fadeInBottom
                                  "
                                >
                                  관통 PROJECT
                                </p>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="carousel-item">
                        <div
                          class="page-header min-vh-35 m-3 border-radius-xl"
                          style="
                            background-image: url('https://demos.creative-tim.com/test/material-dashboard-pro/assets/img/products/product-1-min.jpg');
                          "
                        >
                          <span class="mask bg-gradient-secondary"></span>
                          <div class="container">
                            <div class="row">
                              <div class="col-lg-6 my-auto">
                                <h2 class="text-white mb-2">SSAFY</h2>
                                <p
                                  class="
                                    lead
                                    text-white
                                    opacity-8
                                    fadeIn3
                                    fadeInBottom
                                  "
                                >
                                  6기
                                </p>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="carousel-item active">
                        <div
                          class="page-header min-vh-35 m-3 border-radius-xl"
                          style="
                            background-image: url('https://demos.creative-tim.com/test/material-dashboard-pro/assets/img/products/product-2-min.jpg');
                          "
                        >
                          <span class="mask bg-gradient-secondary"></span>
                          <div class="container">
                            <div class="row">
                              <div class="col-lg-6 my-auto">
                                <h2 class="text-white mb-2">부울경 3반</h2>
                                <p
                                  class="
                                    lead
                                    text-white
                                    opacity-8
                                    fadeIn3
                                    fadeInBottom
                                  "
                                >
                                  전양희, 정순일
                                </p>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="min-vh-25 position-absolute w-100 top-0">
                      <a
                        class="carousel-control-prev"
                        href="#carouselExampleControls"
                        role="button"
                        data-bs-slide="prev"
                      >
                        <span
                          class="
                            carousel-control-prev-icon
                            position-absolute
                            bottom-10
                          "
                          aria-hidden="true"
                        ></span>
                        <span class="visually-hidden">Previous</span>
                      </a>
                      <a
                        class="carousel-control-next"
                        href="#carouselExampleControls"
                        role="button"
                        data-bs-slide="next"
                      >
                        <span
                          class="
                            carousel-control-next-icon
                            position-absolute
                            bottom-10
                          "
                          aria-hidden="true"
                        ></span>
                        <span class="visually-hidden">Next</span>
                      </a>
                    </div>
                  </div>
                </div>
                <!--  -->
                <div
                  class="card card-plain h-100"
                  v-if="this.$store.state.user.isLogin"
                  style="border-color: white"
                >
                  <div
                    class="card-header pb-0 pt-3"
                    style="background-color: white; border-color: white"
                  >
                    <div class="row">
                      <div class="col-md-8 d-flex align-items-center mt-2">
                        <h5 class="mb-1">관심 하우스</h5>
                      </div>
                      <!--  -->
                      <div
                        class="dropdown col-md-4 text-end"
                        style="float: right; display: inline-block"
                        v-if="this.$store.state.friends.friendId.length !== 0"
                      >
                        <i
                          class="
                            fas
                            fa-users
                            text-secondary text-sm
                            dropdown-toggle
                          "
                          data-bs-toggle="dropdown"
                          aria-expanded="false"
                          style="cursor: pointer"
                        >
                          친구 목록</i
                        >
                        <ul
                          class="dropdown-menu"
                          aria-labelledby="dropdownMenuButton"
                        >
                          <li
                            v-on:click="
                              getInterestList($store.state.user.userId)
                            "
                          >
                            <button class="dropdown-item" type="button">
                              {{ this.$store.state.user.userName }}님 관심
                              하우스 목록
                            </button>
                          </li>
                          <li
                            v-for="(friend, index) in this.$store.state.friends
                              .friendId"
                            :key="index"
                            :value="friend"
                            @click="getInterestList(friend)"
                          >
                            <button class="dropdown-item" type="button">
                              {{ friend }}님 관심 하우스 목록
                            </button>
                          </li>
                        </ul>
                      </div>
                      <!--  -->
                    </div>
                  </div>

                  <div
                    class="card-body p-3"
                    style="height: 200px; overflow: auto"
                  >
                    <div
                      v-if="
                        this.$store.state.houses.maininterestlist.length === 0
                      "
                    >
                      <div
                        class="page-header min-vh-35 m-3 border-radius-xl"
                        style="
                          background-image: url('https://cdn.discordapp.com/attachments/901731363844132894/912239680731361280/architecture-1477101.jpg');
                        "
                      >
                        <span class="mask bg-gradient-secondary"></span>
                        <div class="container">
                          <div class="row">
                            <h2 class="text-white mb-2">
                              등록한 관심 하우스가 없습니다.
                            </h2>
                          </div>
                        </div>
                      </div>
                    </div>
                    <ul
                      class="list-group"
                      v-if="
                        this.$store.state.houses.maininterestlist.length !== 0
                      "
                    >
                      <li
                        class="
                          list-group-item
                          border-0
                          d-flex
                          align-items-center
                          px-0
                          mb-2
                        "
                        v-for="(item, index) in this.$store.state.houses
                          .maininterestlist"
                        :key="index"
                      >
                        <div class="avatar me-4">
                          <img
                            src="@/assets/img/apt/houselist.jpg"
                            alt="kal"
                            class="border-radius-lg shadow"
                          />
                        </div>
                        <div
                          class="
                            d-flex
                            align-items-start
                            flex-column
                            justify-content-center
                          "
                        >
                          <p class="mb-0">
                            {{ index + 1 }}.<strong>
                              {{ item.aptName }}
                            </strong>
                          </p>
                          <p class="mb-0 text-sm">
                            <strong>주소 :</strong> {{ item.sidoName }}
                            {{ item.gugunName }} {{ item.dongName }}
                            {{ item.jibun }} <br />
                            <strong>건축년도 :</strong> {{ item.buildYear
                            }}<br />
                            <strong>거래 금액 :</strong>
                            {{
                              (parseInt(item.recentPrice.replace(",", "")) *
                                10000)
                                | price
                            }}원
                          </p>
                        </div>
                        <!-- <a
                      class="btn btn-link pe-3 ps-0 mb-0 ms-auto w-25 w-md-auto"
                      href="javascript:;"
                      >상세정보</a
                    > -->
                      </li>
                    </ul>
                  </div>
                </div>
                <!--  -->
              </div>
            </div>
          </div>
        </div>
        <!--  -->
        <!--  -->
        <div class="row mt-3">
          <div class="col-12 col-xl-12">
            <div class="card card-plain h-100" style="border-color: white">
              <div class="card-header pb-0 p-3" style="background-color: white">
                <div class="row mb-2">
                  <div class="col-md-8 d-flex align-items-center">
                    <h5>공지 사항</h5>
                  </div>
                  <div
                    class="col-md-4 text-end"
                    v-if="this.$store.state.user.userSeq == 1"
                  >
                    <a href="javascript:;">
                      <i
                        class="fas fa-user-edit text-secondary text-sm"
                        data-bs-toggle="tooltip"
                        data-bs-placement="top"
                        title="Edit Profile"
                        @click="showInsertModal"
                      ></i>
                    </a>
                  </div>
                </div>
              </div>
              <div class="card-body p-3">
                <div class="row">
                  <div class="col-12">
                    <div class="card my-4">
                      <div class="card-body px-0 pb-2 pt-0">
                        <div style="height: 200px; overflow: auto">
                          <table
                            class="
                              table table-fixed
                              align-items-center
                              mb-0
                              table-hover
                            "
                          >
                            <thead>
                              <tr>
                                <th
                                  class="
                                    text-center text-uppercase text-secondary
                                    font-weight-bolder
                                    opacity-7
                                    text-sm
                                  "
                                >
                                  #
                                </th>
                                <th
                                  class="
                                    text-center text-uppercase text-secondary
                                    font-weight-bolder
                                    opacity-7
                                    text-sm
                                  "
                                >
                                  제목
                                </th>
                                <th
                                  class="
                                    text-center text-uppercase text-secondary
                                    font-weight-bolder
                                    opacity-7
                                    text-sm
                                  "
                                >
                                  작성자
                                </th>
                                <th
                                  class="
                                    text-center text-uppercase text-secondary
                                    font-weight-bolder
                                    opacity-7
                                    text-sm
                                  "
                                >
                                  작성일시
                                </th>
                                <th
                                  class="
                                    text-center text-uppercase text-secondary
                                    font-weight-bolder
                                    opacity-7
                                    text-sm
                                  "
                                >
                                  조회수
                                </th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr
                                style="cursor: pointer"
                                v-for="(board, index) in listGetters"
                                v-bind:key="index"
                                @click="boardDetail(board.noticeId)"
                                class="
                                  align-middle
                                  text-center text-secondary
                                  font-weight-bold
                                  text-sm
                                "
                              >
                                <td>{{ board.noticeId }}</td>
                                <td>{{ board.title }}</td>
                                <td>{{ board.userName }}</td>
                                <td>
                                  {{
                                    makeDateStr(
                                      board.regDt.date.year,
                                      board.regDt.date.month,
                                      board.regDt.date.day,
                                      "."
                                    )
                                  }}
                                </td>
                                <td>{{ board.readCount }}</td>
                              </tr>
                            </tbody>
                          </table>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <!-- // 테이블 테스트  -->

        <!-- // 테이블 테스트  -->
      </div>
      <apt-modal></apt-modal>
      <insert-modal v-on:call-parent-insert="closeAfterInsert"></insert-modal>
      <detail-modal
        v-on:call-parent-change-to-update="changeToUpdate"
        v-on:call-parent-change-to-delete="changeToDelete"
      ></detail-modal>
      <update-modal v-on:call-parent-update="closeAfterUpdate"></update-modal>
    </div>
  </main>
</template>

<script>
import InsertModal from "../modals/NoticeInsertModal.vue";
import DetailModal from "../modals/NoticeDetailModal.vue";
import UpdateModal from "../modals/NoticeUpdateModal.vue";
import AptModal from "../Apt/AptDetailModal.vue";

import { Modal } from "bootstrap";

import http from "@/common/axios.js";
import util from "@/common/util.js";

// 삭제
import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);

export default {
  name: "Main",
  components: {
    InsertModal,
    DetailModal,
    UpdateModal,
    AptModal,
  },
  data() {
    return {
      // modal
      insertModal: null,
      detailModal: null,
      updateModal: null,
      aptModal: null,
      imglist: [
        require("@/assets/img/apt/apt4.jpg"),
        require("@/assets/img/apt/apt2.jpg"),
        require("@/assets/img/apt/apt3.jpg"),
      ],
    };
  },
  computed: {
    // gttters 이용
    listGetters() {
      return this.$store.getters.getBoardListad; // no getBoardList()
    },
  },
  filters: {
    price(value) {
      if (!value) return value;
      return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  methods: {
    showAptModal(house) {
      console.log(house);
      this.$store.commit("SET_DETAIL_HOUSE", house);
      this.$store.state.houses.house.isInterest = false;
      this.$store.commit("SET_INTEREST");
      this.aptModal.show();
    },
    getInterestList(userId) {
      console.log(userId);
      this.$store.dispatch("getInterestListMain", userId);
      console.log(this.$store.state.houses.friendinterestlist);
    },
    boardList() {
      this.$store.commit("SET_BOARD_MAIN_LISTAD_DEFALUT", 20);
      this.$store.dispatch("boardListad");
      this.$store.commit("SET_BOARD_MAIN_LISTAD_DEFALUT", 10);
    },

    friendlist() {
      this.$store.dispatch("friendList");
    },

    // util
    makeDateStr: util.makeDateStr,

    // insert
    showInsertModal() {
      this.insertModal.show();
    },

    closeAfterInsert() {
      this.insertModal.hide();
      this.boardList();
    },

    boardDetail(boardId) {
      http
        .get("/notices/" + boardId)
        .then(({ data }) => {
          console.log("공지사항");
          console.log(data);
          this.$store.commit("SET_BOARD_DETAILAD", {
            boardId: data.dto.noticeId,
            title: data.dto.title,
            content: data.dto.content,
            userName: data.dto.userName,
            regDt: this.makeDateStr(
              data.dto.regDt.date.year,
              data.dto.regDt.date.month,
              data.dto.regDt.date.day,
              "."
            ),
            fileList: data.dto.fileList,
            sameUser: data.dto.sameUser,
            readCount: data.dto.readCount,
          });

          this.detailModal.show();
          this.boardList();

          // if (data.result == "login") {
          //   this.$router.push("/login");
          // } else {
          // }
        })
        .catch((error) => {
          console.log("공지사항 상세 error ");
          console.log(error);
        });
    },

    changeToUpdate() {
      this.detailModal.hide();
      this.updateModal.show();
    },

    closeAfterUpdate() {
      this.updateModal.hide();
      this.boardList();
    },

    changeToDelete() {
      this.detailModal.hide();

      var $this = this; // alertify.confirm-function()에서 this 는 alertify 객체
      this.$alertify.confirm(
        //'삭제 확인', '이 글을 삭제하시겠습니까?', <- ???? title 추가하면 cancel이 ok 처럼 동작
        "이 공지사항을 삭제하시겠습니까?",
        function () {
          // board.boardId 사용 X
          $this.boardDelete(); // $this 사용
        },
        function () {
          console.log("cancel");
        }
      );
    },
    boardDelete() {
      console.log("공지사항 삭제" + this.$store.state.boardad.boardId);
      http
        .delete("/notices/" + this.$store.state.boardad.boardId)
        .then(({ data }) => {
          console.log(data);
          console.log("삭제 성공?");
          this.boardList();
          // if (data.result == "login") {
          //   this.$router.push("/login");
          // } else {
          // }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  created() {
    this.boardList();
    if (this.$store.state.user.isLogin) {
      this.friendlist();
      this.$store.dispatch(
        "getInterestListMain",
        this.$store.state.user.userId
      );
    }
    this.$store.dispatch("getPopularList");
    this.$store.dispatch("getInterest", this.$store.state.user.userSeq);
  },
  updated() {},
  mounted() {
    this.insertModal = new Modal(document.getElementById("insertModal"));
    this.detailModal = new Modal(document.getElementById("detailModal"));
    this.updateModal = new Modal(document.getElementById("updateModal"));
    this.aptModal = new Modal(document.getElementById("aptModal"));
    // console.log("mounted aptModal : ");
    // console.log(this.aptModal);
  },
};
</script>

<style scoped></style>
