<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="search">
        <el-form-item>
          <el-input v-model="search.lanCode" size="small" placeholder="语言标示"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" v-on:click="getList()">搜索</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <template>
        <el-table :data="table.language" :default-sort = "{prop: 'lanCode', order: 'descending'}" border highlight-current-row max-height="480" v-loading="listLoading" style="width: 100%; border-color: #DCDFE6;">
        <el-table-column type="index" width="60">
        </el-table-column>
        <el-table-column prop="lanCode" label="语言标示" width="120">
        </el-table-column>
        <el-table-column prop="lanDes" label="描述" width="100">
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
        lanCode: ''
      },
      currentPage: 1,
      listLoading: true
    };
  },
  computed: {
    ...mapGetters({table: 'getLanguageList'})
  },
  methods: {
    handleCurrentChange (val) {
      this.getList(val);
    },
    getList (currentPage) {
      this.currentPage = currentPage === undefined ? 1 : currentPage;
      this.$store.dispatch('queryLanguageList', {
        params: {
          currentPage: this.currentPage,
          lanCode: this.search.lanCode
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
