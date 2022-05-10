<template>
  <div>
    <main class="main-content mt-0">
      <section>
        <div class="page-header min-vh-100">
          <div class="container">
            <div class="row">
              <div
                class="
                  col-6
                  d-lg-flex d-none
                  h-100
                  my-auto
                  pe-0
                  position-absolute
                  top-0
                  start-0
                  text-center
                  justify-content-center
                  flex-column
                "
              >
                <div
                  class="
                    position-relative
                    bg-gradient-primary
                    h-100
                    m-3
                    px-7
                    border-radius-lg
                    d-flex
                    flex-column
                    justify-content-center
                  "
                  style="
                    background-image: url('https://cdn.discordapp.com/attachments/901731363844132894/912154392424222780/apt4.jpg');
                    background-size: cover;
                  "
                ></div>
              </div>
              <div
                class="
                  col-xl-4 col-lg-5 col-md-7
                  d-flex
                  flex-column
                  ms-auto
                  me-auto
                  ms-lg-auto
                  me-lg-15
                "
              >
                <div
                  class="card card-plain"
                  style="background-color: white; z-index: 100"
                  v-if="toggle % 2 == 1"
                >
                  <div class="card-header">
                    <h4 class="font-weight-bolder">친구 관리</h4>
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
                          v-for="(friend, index) in this.$store.state.friends
                            .friendId"
                          :key="index"
                          :value="friend"
                          @click="frendId = friend"
                        >
                          <button class="dropdown-item" type="button">
                            {{ friend }}
                          </button>
                        </li>
                      </ul>
                    </div>
                    <!--  -->
                    <p class="mb-0">친구 아이디를 입력하세요</p>
                  </div>

                  <div class="card-body mt-0">
                    <form role="form" class="text-start">
                      <div class="text-secondary font-weight-bold text-sm">
                        아이디
                      </div>
                      <div class="input-group input-group-outline mb-3">
                        <input
                          type="text"
                          class="form-control"
                          v-model="frendId"
                        />
                      </div>
                      <div class="d-grid gap-2 d-md-block text-center">
                        <button
                          type="button"
                          class="btn btn-lg w-45"
                          @click="friendadd()"
                          style="background-color: #6eceda; color: white"
                        >
                          친구추가
                        </button>
                        &nbsp; &nbsp; &nbsp;
                        <button
                          type="button"
                          class="btn btn-lg w-45"
                          @click="frienddelete()"
                          style="background-color: #83b1c9; color: white"
                        >
                          친구삭제
                        </button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
              <div
                class="
                  col-xl-4 col-lg-5 col-md-7
                  d-flex
                  flex-column
                  ms-auto
                  me-auto
                  ms-lg-auto
                  me-lg-7
                "
              >
                <div class="card card-plain h-100">
                  <div class="card-header">
                    <h4 class="font-weight-bolder">회원 정보</h4>
                    <p class="mb-0">수정할 정보를 입력해주세요</p>
                  </div>
                  <div class="card-body">
                    <form role="form" class="text-start">
                      <div class="text-secondary font-weight-bold text-sm">
                        이름
                      </div>
                      <div class="input-group input-group-outline mb-3">
                        <input
                          type="text"
                          class="form-control"
                          v-model="userName"
                          :class="{
                            'is-valid': isUserNameFocusAndValid,
                            'is-invalid': isUserNameFocusAndInvalid,
                          }"
                          @input="validateUserName"
                          @focus="validateUserName"
                        />
                        <div class="valid-feedback">사용 가능 합니다.</div>
                        <div class="invalid-feedback">
                          올바른 이름을 입력해 주세요.
                        </div>
                      </div>
                      <div class="text-secondary font-weight-bold text-sm">
                        아이디
                      </div>
                      <div class="input-group input-group-outline mb-3">
                        <input
                          type="text"
                          class="form-control"
                          readonly
                          v-model="userId"
                        />
                      </div>
                      <div class="text-secondary font-weight-bold text-sm">
                        이메일
                      </div>
                      <div class="input-group input-group-outline mb-3">
                        <input
                          type="email"
                          class="form-control"
                          v-model="userEmail"
                          :class="{
                            'is-valid': isUserEmailFocusAndValid,
                            'is-invalid': isUserEmailFocusAndInValid,
                          }"
                          @input="validateEmail"
                          @focus="validateEmail"
                        />
                        <div class="valid-feedback">사용 가능 합니다.</div>
                        <div class="invalid-feedback">
                          올바른 이메일을 입력해 주세요.
                        </div>
                      </div>
                      <div class="text-secondary font-weight-bold text-sm">
                        비밀번호
                      </div>
                      <div class="input-group input-group-outline mb-3">
                        <input
                          type="password"
                          class="form-control"
                          v-model="userPassword"
                          :class="{
                            'is-valid': isUserPasswordFocusAndValid,
                            'is-invalid': isUserPasswordFocusAndInvalid,
                          }"
                          @input="validatePassword"
                          @focus="validatePassword"
                        />
                        <div class="valid-feedback">사용 가능 합니다.</div>
                        <div class="invalid-feedback">
                          1개 이상의 특수문자, 대소문자 및 숫자를 포함하고 8자리
                          이상이여야 합니다.
                        </div>
                      </div>
                      <div class="text-secondary font-weight-bold text-sm">
                        비밀번호 확인
                      </div>
                      <div class="input-group input-group-outline mb-3">
                        <input
                          type="password"
                          class="form-control"
                          v-model="userPassword2"
                          :class="{
                            'is-valid': isUserPassword2FocusAndValid,
                            'is-invalid': isUserPassword2FocusAndInvalid,
                          }"
                          @input="validatePassword2"
                          @focus="validatePassword2"
                        />
                        <div class="valid-feedback">일치 합니다.</div>
                        <div class="invalid-feedback">일치하지 않습니다.</div>
                      </div>
                      <div
                        class="d-grid gap-2 d-md-flex justify-content-md-end"
                      >
                        <button
                          class="btn btn-sm mt-0"
                          @click="toggle++"
                          style="background-color: #aeddef; color: white"
                        >
                          친구 관리
                        </button>
                      </div>
                      <div class="d-grid gap-2 d-md-block text-center">
                        <button
                          type="button"
                          class="btn btn-lg w-45"
                          @click="update()"
                          style="background-color: #6eceda; color: white"
                        >
                          수정하기
                        </button>
                        &nbsp; &nbsp; &nbsp;
                        <button
                          type="button"
                          class="btn btn-lg w-45"
                          @click="remove()"
                          style="background-color: #83b1c9; color: white"
                        >
                          삭제하기
                        </button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>
  </div>
</template>

<script>
import http from "@/common/axios.js";
export default {
  data() {
    return {
      toggle: 0,
      frendId: "",
      userName: this.$store.state.user.userName,
      userId: this.$store.state.user.userId,
      userEmail: this.$store.state.user.userEmail,
      userPassword: this.$store.state.user.userPassword,
      userPassword2: "",

      // focus
      isUserNameFocus: false,
      isUserEmailFocus: false,
      isUserPasswordFocus: false,
      isUserPassword2Focus: false,

      // validation
      isUserNameValid: false,
      isUserEmailValid: false,
      isUserPasswordValid: false,
      isUserPassword2Valid: false,
    };
  },

  computed: {
    isUserNameFocusAndValid() {
      return this.isUserNameFocus && this.isUserNameValid;
    },
    isUserNameFocusAndInvalid() {
      return this.isUserNameFocus && !this.isUserNameValid;
    },
    isUserEmailFocusAndValid() {
      return this.isUserEmailFocus && this.isUserEmailValid;
    },
    isUserEmailFocusAndInValid() {
      return this.isUserEmailFocus && !this.isUserEmailValid;
    },
    isUserPasswordFocusAndValid() {
      return this.isUserPasswordFocus && this.isUserPasswordValid;
    },
    isUserPasswordFocusAndInvalid() {
      return this.isUserPasswordFocus && !this.isUserPasswordValid;
    },
    isUserPassword2FocusAndValid() {
      return this.isUserPassword2Focus && this.isUserPassword2Valid;
    },
    isUserPassword2FocusAndInvalid() {
      return this.isUserPassword2Focus && !this.isUserPassword2Valid;
    },
  },

  methods: {
    validateUserName() {
      this.isUserNameFocus = true;
      this.isUserNameValid = this.userName.length > 0 ? true : false;
      console.log(this.isUserNameValid);
    },
    validateEmail() {
      this.isUserEmailFocus = true;
      // ^ 시작일치, $ 끝 일치
      // {2, 3} 2개 ~ 3개
      // * 0회 이상, + 1회 이상
      // [-_.] - 또는 _ 또는 .
      // ? 없거나 1회
      let regexp =
        /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
      this.isUserEmailValid = regexp.test(this.userEmail) ? true : false;
      console.log(this.isUserEmailValid);
    },
    validatePassword() {
      this.isUserPasswordFocus = true;
      let patternEngAtListOne = new RegExp(/[a-zA-Z]+/); // + for at least one
      let patternSpeAtListOne = new RegExp(/[~!@#$%^&*()_+|<>?:{}]+/); // + for at least one
      let patternNumAtListOne = new RegExp(/[0-9]+/); // + for at least one

      this.isUserPasswordValid =
        patternEngAtListOne.test(this.userPassword) &&
        patternSpeAtListOne.test(this.userPassword) &&
        patternNumAtListOne.test(this.userPassword) &&
        this.userPassword.length >= 8
          ? true
          : false;
    },
    validatePassword2() {
      this.isUserPassword2Focus = true;
      this.isUserPassword2Valid =
        this.userPassword == this.userPassword2 ? true : false;
    },
    update() {
      if (
        this.isUserNameFocus != this.isUserNameValid ||
        this.isUserEmailFocus != this.isUserEmailValid ||
        this.isUserPasswordFocus != this.isUserPasswordValid ||
        this.isUserPassword2Focus != this.isUserPassword2Valid ||
        !this.isUserPassword2Valid
      ) {
        this.$alertify.alert(
          "회원 정보 수정 오류",
          "올바른 정보를 입력해 주세요"
        );
        return;
      }

      var $this = this;

      this.$alertify.confirm(
        "회원 정보를 수정하시겠습니까?",
        function () {
          $this.updateuser();
        },
        function () {
          console.log("수정 취소");
        }
      );
    },

    updateuser() {
      const params = {
        userName: this.userName,
        userId: this.userId,
        userPassword: this.userPassword,
        userEmail: this.userEmail,
      };
      console.log(params);
      http
        .put("/users", params)
        .then((response) => {
          console.log(response);
          this.$alertify.alert("회원 수정", "회원 수정 성공");
          this.$store.commit("SET_USER", {
            isLogin: true,
            userName: this.userName,
            userSeq: this.userSeq,
            userPassword: this.userPassword,
            userEmail: this.userEmail,
            userId: this.userId,
          });
          this.$router.push("/");
        })
        .catch((error) => {
          console.log(error);
        });
    },
    remove() {
      var $this = this;

      this.$alertify.confirm(
        "회원 정보를 삭제(탈퇴) 하시겠습니까?",
        function () {
          $this.removeuser();
        },
        function () {
          console.log("삭제 취소");
        }
      );
    },

    removeuser() {
      console.log("/users/" + this.userId);
      http
        .delete("/users/" + this.userId)
        .then((response) => {
          console.log(response);
          this.$alertify.alert("회원 삭제", "회원 삭제 성공");
          this.$store.commit("SET_USER", {
            isLogin: false,
            userName: "",
            userSeq: 0,
            userPassword: "",
            userEmail: "",
            userId: "",
          });
          this.$router.push("/");
        })
        .catch((error) => {
          console.log(error);
        });
    },
    friendadd() {
      console.log(this.$store.state.user.userId + "-" + this.frendId);

      var formData = new FormData();
      formData.append("userId", this.$store.state.user.userId);
      formData.append("friendId", this.frendId);

      http
        .post("/friends", formData)
        .then(({ data }) => {
          console.log(data);
          if (data.result == "login") {
            this.$router.push("/login");
          } else {
            this.$alertify.success("관계가 등록되었습니다.");
            this.frendId = "";
            this.friendlist();
          }
        })
        .catch((error) => {
          this.$alertify.error("친구 아이디를 확인하세요");
          this.frendId = "";
          console.log(error);
        });
    },
    frienddelete() {
      http
        .delete(
          "/friends/" + this.$store.state.user.userId + "/" + this.frendId
        )
        .then(({ data }) => {
          console.log("친구 관계 삭제: data : ");
          console.log(data);
          if (data.result == "login") {
            this.$router.push("/login");
          } else {
            this.$alertify.success("관계가 삭제 되었습니다.");
            this.frendId = "";
            this.friendlist();
          }
        })
        .catch((error) => {
          this.$alertify.error("친구 아이디를 확인하세요");
          this.frendId = "";
          console.log(error);
        });
    },
    friendlist() {
      this.$store.dispatch("friendList");
    },
  },
  created() {
    this.friendlist();
  },
  watch: {
    toggle: function (a, b) {
      console.log(a + "->" + b);
    },
  },
};
</script>

<style></style>
