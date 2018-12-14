<template>
  <el-row>
    <el-col :span="24">
      <el-table :data="serverLoad.list"
                v-loading="listLoading"
                max-height="420"
                highlight-current-row
                border
                style="width: 100%; border-color: #DCDFE6;">
        <el-table-column v-for="(column,index) in serverLoad.column" :key="index" :prop="column.columnEn" :label="column.columnCn">
        </el-table-column>
      </el-table>
    </el-col>
  </el-row>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
  name: 'program-version',
  data () {
    return {
      listLoading: true
    };
  },
  computed: {
    ...mapGetters({serverLoad: 'getServerLoad'})
  },
  mounted () {
    this.$store.dispatch('queryServerLoad', {
      params: {},
      e: this
    });
  }
};
</script>

<style scoped>

</style>
