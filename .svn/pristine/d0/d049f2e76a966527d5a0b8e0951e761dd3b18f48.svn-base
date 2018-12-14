<template>
  <el-row>
    <el-col :span="24">
      <el-table :data="channelState.list"
                v-loading="listLoading"
                max-height="420"
                highlight-current-row
                border
                style="width: 100%; border-color: #DCDFE6;">
        <el-table-column v-for="(column,index) in channelState.column" :key="index" :prop="column.columnEn" :label="column.columnCn">
        </el-table-column>
      </el-table>
    </el-col>
  </el-row>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
  name: 'channel-state',
  data () {
    return {
      listLoading: true
    };
  },
  computed: {
    ...mapGetters({channelState: 'getChannelState'})
  },
  mounted () {
    this.$store.dispatch('queryChannelState', {
      params: {},
      e: this
    });
  }
};
</script>

<style scoped>

</style>
