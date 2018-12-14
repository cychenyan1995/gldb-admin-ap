<template>
  <el-row>
    <el-col :span="24">
      <h3>
        {{programVersion.version===undefined?"暂无数据":programVersion.version}}
      </h3>
      <h3>
        {{programVersion.date}}
      </h3>
    </el-col>
  </el-row>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
  name: 'program-version',
  computed: {
    ...mapGetters({programVersion: 'getProgramVersion'})
  },
  mounted () {
    this.$store.dispatch('queryProgramVersion', {
      params: {},
      e: this
    });
  }
};
</script>

<style scoped>

</style>
