<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="search">
        <el-form-item>
          <el-input prop="appId" v-model="search.appId" size="small" placeholder="服务器ID"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" v-on:click="getList()">搜索</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <template>
      <el-table :data="table.appsvr" :default-sort = "{prop: 'createTime', order: 'descending'}"  border highlight-current-row max-height="480" v-loading="listLoading" style="width: 100%; border-color: #DCDFE6;">
        <el-table-column type="index" width="60">
        </el-table-column>
        <el-table-column prop="appId" label="服务器id" width="120">
        </el-table-column>
        <el-table-column prop="appName" label="服务器名称" width="100">
        </el-table-column>
        <el-table-column prop="bigCmd" label="大命令码" width="100">
        </el-table-column>
        <el-table-column prop="appDes" label="说明" width="120">
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" min-width="180">
        </el-table-column>
        <el-table-column prop="updateTime" label="修改时间" width="180">
        </el-table-column>
      </el-table>
    </template>
    <el-col :span="24" class="toolbar" style="padding-top: 19px;">
      <el-pagination background small layout="prev, pager, next" @current-change="handleCurrentChange" :page-size=table.pageSize :total="table.total" style="float:right;" :current-page="currentPage">
      </el-pagination>
    </el-col>

  </section>
</template>
<script>
import { mapGetters } from 'vuex';
export default {
  data () {
    return {
      search: {
        appId: ''
      },
      currentPage: 1,
      listLoading: true
    };
  },
  computed: {
    ...mapGetters({table: 'getAppsvrList'})
  },
  methods: {
    handleCurrentChange (val) {
      this.getList(val);
    },
    getList (currentPage) {
      this.currentPage = currentPage === undefined ? 1 : currentPage;
      this.$store.dispatch('queryAppsvrList', {
        params: {
          currentPage: this.currentPage,
          appId: this.search.appId
        },
        e: this
      });
    }
  },
  mounted () {
    this.getList();
  }
};

</script>

<style scoped>

</style>
