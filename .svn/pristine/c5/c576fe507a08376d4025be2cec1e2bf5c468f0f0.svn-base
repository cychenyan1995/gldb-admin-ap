<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item>
          <el-input v-model="filters.userId" size="small" placeholder="用户ID"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" size="small" icon="el-icon-search" v-on:click="search">搜索</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <template>
      <el-table :data="table.navAddresss" :default-sort = "{prop: 'createTime', order: 'descending'}" border highlight-current-row max-height="480" v-loading="listLoading" style="width: 100%; border-color: #DCDFE6;">
        <el-table-column type="index" width="60">
        <!--</el-table-column>
        <el-table-column prop="id" label="主键ID" width="100">-->
        </el-table-column>
        <el-table-column prop="userId" label="用户ID" width="110">
        </el-table-column>
        <el-table-column prop="msgId" label="消息ID" width="110">
        </el-table-column>
        <el-table-column prop="longItude" label="目的地经度" width="150">
        </el-table-column>
        <el-table-column prop="latItude" label="目的地纬度" width="150">
        </el-table-column>
        <el-table-column prop="title" label="搜索关键字" min-width="160">
        </el-table-column>
        <el-table-column prop="address" label="目的地地址" min-width="230">
        </el-table-column>
        <el-table-column prop="feedBack" label="推送结果" min-width="120" :formatter="feedBackType">
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" min-width="120" :formatter="formatDate">
        </el-table-column>
        <el-table-column prop="updateTime" label="修改时间" min-width="120" :formatter="formatDate">
        </el-table-column>
      </el-table>
    </template>

    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-top: 19px;">
      <el-pagination background
                     small
                     layout="prev, pager, next"
                     @current-change="handleCurrentPage"
                     :current-page="currentPage"
                     :page-size="10"
                     :total="this.table.total"
                     style="float:right;">
      </el-pagination>
    </el-col>
  </section>
</template>
<script>
import { mapState } from 'vuex';
import util from '../../../components/utils/js/util';

export default {
  data () {
    return {
      filters: {
        userId: ''
      },
      currentPage: 1,
      listLoading: true
    };
  },
  computed: mapState({
    table: state => state.navigation.navAdd
  }),
  methods: {
    /* handleCurrentPage (val) {
      this.currentPage = val.currentPage === undefined ? 1 : val.currentPage;
      console('this.currentPage:' + this.currentPage);
      this.$store.dispatch('navigation/setCurrentPage', {page: val});
      this.getList();
    }, */
    getList (currentPage) {
      this.currentPage = currentPage === undefined ? 1 : currentPage;
      let param = {
        currentPage: this.currentPage,
        page: this.table.page,
        // page: this.currentPage,
        userId: this.filters.userId
      };
      this.$store.dispatch('navigation/navAddInfoList', {param: param, ref: this});
    },
    handleCurrentPage (val) {
      this.getList(val);
    },
    search () {
      let param = {
        currentPage: this.currentPage,
        page: this.table.page,
        userId: this.filters.userId
      };
      this.$store.dispatch('navigation/navAddInfoList', {param: param, ref: this});
    },
    formatDate: function (row, column) {
      return util.formatDate.format(new Date(row[column.property]), 'yyyy-MM-dd');
    },
    feedBackType: function (row, column) {
      let feedBack = '';
      switch (row.feedBack) {
        case 0:
          feedBack = '客户端没返回';
          break;
        case 1:
          feedBack = '客户端有返回';
          break;
        default:
          feedBack = '';
      }
      return feedBack;
    }
  },
  mounted () {
    this.getList();
  }};

</script>

<style scoped>

</style>
