<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="search">
        <el-form-item>
          <el-input prop="keyId" v-model="search.keyId" size="small" placeholder="监测点ID"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" v-on:click="getList()">搜索</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <template>
      <el-table :data="table.list" :default-sort = "{prop: 'createTime', order: 'descending'}" border highlight-current-row max-height="480" v-loading="listLoading" style="width: 100%; border-color: #DCDFE6;">
        <el-table-column type="index" width="60">
        </el-table-column>
        <el-table-column prop="keyId" label="监测点id" width="120">
        </el-table-column>
        <el-table-column prop="des" label="监测点描述" width="120">
        </el-table-column>
        <el-table-column prop="remark" label="监测点备注" width="120">
        </el-table-column>
        <el-table-column prop="appId" label="服务器id" width="120">
        </el-table-column>
        <el-table-column prop="cMarco" label="未知" width="120">
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" min-width="160">
        </el-table-column>
        <el-table-column prop="updateTime" label="修改时间" min-width="160">
        </el-table-column>
        <el-table-column prop="type" label="检测点类型" min-width="180" :formatter="formatType">
        </el-table-column>
      </el-table>
    </template>
    <el-col :span="24" class="toolbar" style="padding-top: 19px;">
      <el-pagination background small layout="prev, pager, next" @current-change="handleCurrentChange" :page-size=table.pageSize :total="table.total" style="float:right;"  :current-page="currentPage">
      </el-pagination>
    </el-col>

  </section>
</template>
<script>
// import NProgress from 'nprogress'
import { mapGetters } from 'vuex';

export default {
  data () {
    return {
      search: {
        keyId: ''
      },
      currentPage: 1,
      listLoading: true
    };
  },
  // computed: mapState({
  //   table: state => state.monitor.monitorPor
  // }),
  computed: {
    ...mapGetters({table: 'getMonitorList'})
  },
  methods: {
    // 性别显示转换
    formatType: function (row, column) {
      return row.type === 0 ? '频次检测' : row.type === 1 ? '发生错误检测' : '未知';
    },
    handleCurrentChange (val) {
      this.getList(val);
    },
    getList (currentPage) {
      this.currentPage = currentPage === undefined ? 1 : currentPage;
      this.$store.dispatch('queryMonitorList', {
        params: {
          currentPage: this.currentPage,
          keyId: this.search.keyId
        },
        e: this
      });
    }
    // getList (currentPage) {
    //   this.currentPage = currentPage === undefined ? 1 : currentPage;
    //   let param = {
    //     currentPage: this.currentPage,
    //     keyId: this.search.keyId
    //   };
    //   this.$store.dispatch('monitor/monitorPotList', {param: param, ref: this});
    // }
  },
  mounted () {
    this.getList();
  }
};

</script>

<style scoped>

</style>
