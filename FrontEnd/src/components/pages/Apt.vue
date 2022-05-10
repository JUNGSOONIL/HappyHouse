<template>
  <div>
    <br />
    <br />
    <br />
    <br />
    <apt-search-bar id="searchBar"></apt-search-bar>
    <!-- <div class="row">
      <div class="col-6">
        <apt-list></apt-list>
      </div>
      <div class="col-6"></div>
    </div> -->
    <apt-map id="aptMap"></apt-map>
  </div>
</template>

<script>
// import AptList from "./Apt/AptList.vue";
import AptMap from "../Apt/AptMap.vue";
import AptSearchBar from "../Apt/AptSearchBar.vue";
export default {
  components: {
    AptSearchBar,
    // AptList,
    AptMap,
  },
};
</script>

<style>
#searchBar {
  position: absolute;
  z-index: 200;
  background-color: transparent;
  width: 60%;
  opacity: 0.9;
  margin-left: 50%;
}
#aptMap {
  position: relative;
}
</style>
