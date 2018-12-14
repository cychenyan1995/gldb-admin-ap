<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item>
          <el-input v-model="filters.appMsgId" size="small" placeholder="营销ID"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" size="small" icon="el-icon-search" v-on:click="search">搜索</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <template>
      <el-table :data="table.inboxs" :default-sort = "{prop: 'createTime', order: 'descending'}" border highlight-current-row max-height="480" v-loading="listLoading" style="width: 100%; border-color: #DCDFE6;">
        <el-table-column type="index" width="60">
        </el-table-column>
        <el-table-column prop="appMsgId" label="营销ID" width="120">
        </el-table-column>
        <el-table-column prop="sender" label="发送ID" width="100">
        </el-table-column>
        <el-table-column prop="receiver" label="接收者ID" width="120">
        </el-table-column>
        <el-table-column prop="status" label="状态" width="100" :formatter="formatStatus">
        </el-table-column>
        <el-table-column prop="receiverTime" label="推送接收时间" width="140" :formatter="receiverTimeFormatDate">
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" width="140" :formatter="createTimeFormatDate">
        </el-table-column>
        <el-table-column prop="updateTime" label="修改时间" width="140" :formatter="updateTimeFormatDate">
        </el-table-column>
        <el-table-column prop="batchNumber" label="批次号" width="200">
        </el-table-column>
      </el-table>
    </template>
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
        appMsgId: ''
      },
      currentPage: 1,
      listLoading: true
    };
  },
  computed: mapState({
    table: state => state.mkmsg.inbox
  }),
  methods: {
    // 性别显示转换
    formatStatus: function (row, column) {
      return row.status === 0 ? '未推送' : row.status === 1 ? '已推送' : row.status === 2 ? '过期' : '未知';
    },
    /* handleCurrentPage (val) {
      this.$store.dispatch('mkmsg/setCurrentPage', {page: val});
      this.getList();
    }, */
    getList (currentPage) {
      this.currentPage = currentPage === undefined ? 1 : currentPage;
      let param = {
        currentPage: this.currentPage,
        page: this.table.page,
        appMsgId: this.filters.appMsgId
      };
      this.$store.dispatch('mkmsg/inboxList', {param: param, ref: this});
    },
    handleCurrentPage (val) {
      this.getList(val);
    },
    search () {
      let param = {
        currentPage: this.currentPage,
        page: this.table.page,
        appMsgId: this.filters.appMsgId
      };
      this.$store.dispatch('mkmsg/inboxList', {param: param, ref: this});
    },
    formatDate: function (row, column) {
      if (row) {
        return util.formatDate.format(new Date(row[column.property]), 'yyyy-MM-dd');
      }
    },
    receiverTimeFormatDate: function (row, column) {
      if (row.receiverTime) {
        return util.formatDate.format(new Date(row[column.property]), 'yyyy-MM-dd');
      }
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
    }
  },
  mounted () {
    this.getList();
  }
};

</script>

<style scoped>

</style>
