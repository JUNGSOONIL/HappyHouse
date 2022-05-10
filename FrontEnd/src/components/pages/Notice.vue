<template>
  <div>
    <br />
    <br />
    <br />
    <br />
    <div
      class="page-header min-height-300 border-radius-xl mt-4 row"
      style="
        background-image: url('https://cdn.discordapp.com/attachments/901731363844132894/912239680454557696/window-3065345_1920.jpg');
        width: 100%;
        height: 85vh;
      "
    >
      <div>
        <br />
        <br />
      </div>
      <div class="col-12" style="opacity: 0.9">
        <div class="card my-4 container">
          <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
            <div
              class="shadow-secondary border-radius-lg pt-4 pb-3"
              style="background-color: #806849"
            >
              <h5 class="text-white text-capitalize ps-3">공지사항</h5>
            </div>
          </div>

          <!-- <div class="ms-md-auto pe-md-3 d-flex align-items-center"> -->
          <div class="d-grid gap-2 d-md-flex pt-2 justify-content-md-end">
            <div>
              <input
                v-model="$store.state.boardad.searchWord"
                @keydown.enter="boardList"
                type="text"
                class="form-control shadow-secondary"
                placeholder="검색어 입력"
              />
            </div>
            <div>
              <button
                class="btn btn-icon btn-2 shadow-secondary"
                type="button"
                @click="boardList"
                style="background-color: #806849"
              >
                <span class="btn-inner--icon"
                  ><i class="material-icons">search</i></span
                >
              </button>
            </div>
            <div>
              <button
                class="btn btn-icon btn-2 shadow-secondary"
                type="button"
                v-if="this.$store.state.user.userSeq == 1"
                @click="showInsertModal"
                style="background-color: #806849"
              >
                <span class="btn-inner--icon"
                  ><i class="material-icons">create</i></span
                >
              </button>
            </div>
          </div>

          <div class="card-body px-0 pb-2 pt-0">
            <div class="p-0">
              <table class="table align-items-center mb-0 table-hover">
                <thead>
                  <tr>
                    <th
                      class="
                        text-center text-uppercase text-secondary
                        font-weight-bolder
                        opacity-7
                      "
                    >
                      #
                    </th>
                    <th
                      class="
                        text-center text-uppercase text-secondary
                        font-weight-bolder
                        opacity-7
                      "
                    >
                      제목
                    </th>
                    <th
                      class="
                        text-center text-uppercase text-secondary
                        font-weight-bolder
                        opacity-7
                      "
                    >
                      작성자
                    </th>
                    <th
                      class="
                        text-center text-uppercase text-secondary
                        font-weight-bolder
                        opacity-7
                      "
                    >
                      작성일시
                    </th>
                    <th
                      class="
                        text-center text-uppercase text-secondary
                        font-weight-bolder
                        opacity-7
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
      <pagination v-on:call-parent="movePage"></pagination>
    </div>

    <insert-modal v-on:call-parent-insert="closeAfterInsert"></insert-modal>
    <!-- props 제거 -->
    <detail-modal
      v-on:call-parent-change-to-update="changeToUpdate"
      v-on:call-parent-change-to-delete="changeToDelete"
    ></detail-modal>
    <update-modal v-on:call-parent-update="closeAfterUpdate"></update-modal>
  </div>
</template>

<script>
import InsertModal from "../modals/NoticeInsertModal.vue";
import DetailModal from "../modals/NoticeDetailModal.vue";
import UpdateModal from "../modals/NoticeUpdateModal.vue";
import Pagination from "../Paginationad.vue";

import { Modal } from "bootstrap";

import http from "@/common/axios.js";
import util from "@/common/util.js";

// 삭제
import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);

export default {
  name: "Board",
  components: { InsertModal, DetailModal, UpdateModal, Pagination },
  data() {
    return {
      // modal
      insertModal: null,
      detailModal: null,
      updateModal: null,
    };
  },
  computed: {
    // gttters 이용
    listGetters() {
      return this.$store.getters.getBoardListad; // no getBoardList()
    },
  },
  methods: {
    // list
    // store actions 에 구현
    // 가능한 한 가지 방법
    boardList() {
      this.$store.dispatch("boardListad");
    },

    // pagination
    movePage(pageIndex) {
      console.log("BoardMainVue : movePage : pageIndex : " + pageIndex);

      // store commit 으로 변경
      // this.offset = (pageIndex - 1) * this.listRowCount;
      // this.currentPageIndex = pageIndex;
      this.$store.commit("SET_BOARD_MOVE_PAGEAD", pageIndex);

      this.boardList();
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

    // detail
    // board-vue 와 다르게 구현해 봄
    // Detail Component 에서 Server 요청을 하지 않고 이곳에서 수행 후에 Detail 보여줌
    boardDetail(boardId) {
      // store 변경
      // this.boardId = boardId;
      // this.$store.commit('mutateSetBoardBoardId', boardId);
      console.log(boardId);
      http
        .get(
          "/notices/" + boardId // props variable
        )
        .then(({ data }) => {
          console.log("공지사항");
          console.log(data);

          if (data.result == "login") {
            this.$router.push("/login");
          } else {
            console.log(data.dto.noticeId);
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
              sameUser: data.dto.sameUser, // not data.dto.sameUser
              readCount: data.dto.readCount,
            });
            this.detailModal.show();
            this.boardList();
          }
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
        "이 글을 삭제하시겠습니까?",
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
      // parameter 사용 X
      console.log("공지사항 삭제 " + this.$store.state.boardad.boardId);
      http
        .delete("/notices/" + this.$store.state.boardad.boardId)
        .then(({ data }) => {
          console.log("BoardMainVue: data : ");
          console.log(data);
          if (data.result == "login") {
            this.$router.push("/login");
          } else {
            this.boardList();
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  created() {
    this.boardList();
  },
  mounted() {
    this.insertModal = new Modal(document.getElementById("insertModal"));
    this.detailModal = new Modal(document.getElementById("detailModal"));
    this.updateModal = new Modal(document.getElementById("updateModal"));
  },
};
</script>

<style scoped></style>
