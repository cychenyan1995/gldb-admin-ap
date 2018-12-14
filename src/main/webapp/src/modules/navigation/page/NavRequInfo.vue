<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item>
          <el-input v-model="filters.userId" size="small" placeholder="嘀嘀号"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" size="small" icon="el-icon-search" v-on:click="search">搜索</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <template>
      <el-table :data="table.navRequests" :default-sort = "{prop: 'createTime', order: 'descending'}" border highlight-current-row max-height="480" v-loading="listLoading" style="width: 100%; border-color: #DCDFE6;">
        <el-table-column type="index" width="60">
        <!--</el-table-column>
        <el-table-column prop="id" label="主键ID" width="100">-->
        </el-table-column>
        <el-table-column prop="userId" label="嘀嘀号" width="110">
        </el-table-column>
        <el-table-column prop="imsi" label="imsi" width="140">
        </el-table-column>
        <el-table-column prop="mobileNo" label="电话号码" width="120">
        </el-table-column>
        <el-table-column prop="srclongItude" label="请求时经度" min-width="120">
        </el-table-column>
        <el-table-column prop="srclatItude" label="请求时纬度" width="120">
        </el-table-column>
        <el-table-column prop="time" label="请求时间" width="120"  :formatter="formatDate">
        </el-table-column>
        <el-table-column prop="msgId" label="交易套号ID" width="130">
        </el-table-column>
        <el-table-column prop="code" label="一键导航合作商ID" width="160">
        </el-table-column>
        <el-table-column prop="feedBack" label="反馈消息" min-width="120" :formatter="feedBackType">
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" width="120" :formatter="createTimeFormatDate">
        </el-table-column>
        <el-table-column prop="updateTime" label="更新时间" width="120" :formatter="updateTimeFormatDate">
        </el-table-column>
        <el-table-column prop="status" label="请求状态" width="105" :formatter="formatStatus">
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
    table: state => state.navigation.navRequ
  }),
  methods: {
    // 请求状态显示转换
    formatStatus: function (row, column) {
      return row.status === 0 ? '成功' : row.status === 1 ? '失败' : '超时';
    },
    /* handleCurrentPage (val) {
      this.$store.dispatch('navigation/setRequCurrentPage', {page: val});
      this.getList();
    }, */
    getList (currentPage) {
      this.currentPage = currentPage === undefined ? 1 : currentPage;
      let param = {
        currentPage: this.currentPage,
        page: this.table.page,
        userId: this.filters.userId
      };
      this.$store.dispatch('navigation/navRequInfoList', {param: param, ref: this});
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
      this.$store.dispatch('navigation/navRequInfoList', {param: param, ref: this});
    },
    formatDate: function (row, column) {
      return util.formatDate.format(new Date(row[column.property]), 'yyyy-MM-dd');
    },
    createTimeFormatDate: function (row, column) {
      if (row.createTime) {
        return util.formatDate.format(new Date(row[column.property]), 'yyyy-MM-dd');
      }
    },
    updateTimeFormatDate: function (row, column) {
      if (row.updateTime) {
        return util.formatDate.format(new Date(row[column.property]), 'yyyy-MM-dd');
      }
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
