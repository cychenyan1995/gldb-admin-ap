<template>
  <section>
    <!--工具条-->
    <el-row>
      <el-col :span="12">
        <!-- 搜索 -->
        <el-form :inline="true" :model="search" style="width:270px;float: left">
          <el-form-item>
            <el-input prop="userid" v-model="search.userid" size="mini" placeholder="请输入用户ID"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="mini" v-on:click="handleList()">搜索
            </el-button>
          </el-form-item>
        </el-form>
        <!-- 高级搜索 -->
     <!--   <el-popover
          placement="right"
          width="360"
          v-model="advancedSearchVisible"
          class="advanced-search">
          <p class="advanced-search_title">高级搜索</p>
          <hr class="advanced-search_line"/>
          <el-form :inline="true" ref="advancedSearch"
                   :model="advancedSearch"
                   label-width="100px"
                   size="mini">
            <el-form-item label="用户ID" prop="userid">
              <el-input v-model="advancedSearch.userid"></el-input>
            </el-form-item>
            <el-form-item label="用户ID" prop="userid">
              <el-input v-model="advancedSearch.userid"></el-input>
            </el-form-item>
          </el-form>
          <div style="float: right;">
            <el-button size="mini" type="text" @click="advancedSearchVisible = false">取消</el-button>
            <el-button plain type="primary" size="mini" @click="submitSearch('advancedSearch')">确定</el-button>
          </div>
          <el-button slot="reference" type="primary" icon="el-icon-search" size="mini">高级搜索</el-button>
        </el-popover>-->
      </el-col>
      <!--<el-col :span="12">
        <el-button-group style="padding-top:7px;float:right">
          <el-button size="mini" plain type="info" icon="el-icon-upload2">上传</el-button>
          <el-button size="mini" plain type="info" icon="el-icon-download">下载</el-button>
          <el-button size="mini" plain type="info" icon="el-icon-sort-up">导入</el-button>
          <el-button size="mini" plain type="info" icon="el-icon-sort-down">导出</el-button>
          <el-button size="mini" plain type="info" icon="el-icon-circle-plus" @click="handleAdd">新增</el-button>
        </el-button-group>
      </el-col>-->
    </el-row>
    <el-row>
      <el-col :span="24">
        <!--列表-->
        <el-table
                  :data="table.list"
                  :default-sort = "{prop: 'createtime', order: 'descending'}"
                  v-loading="listLoading"
                  highlight-current-row
                  max-height="435"
                  border
                  style="width: 100%; border-color: #DCDFE6;">
          <el-table-column prop="id" label="序号">
          </el-table-column>
          <el-table-column prop="userid" label="用户ID">
          </el-table-column>
          <el-table-column prop="logtime" label="登陆时间" :formatter="formatDate">
          </el-table-column>
          <el-table-column prop="logtype" label="登录方式" :formatter="formatDateLogtype">
          </el-table-column>
          <el-table-column prop="offtime" label="退出时间" :formatter="formatDate">
          </el-table-column>
          <el-table-column prop="curver" label="客户端版本">
          </el-table-column>
          <el-table-column prop="imsi" label="IMSI">
          </el-table-column>
          <el-table-column prop="deviceid" label="设备ID">
          </el-table-column>
          <el-table-column prop="partnerid" label="合作商ID">
          </el-table-column>
          <el-table-column prop="clientip" label="客户端IP">
          </el-table-column>
          <el-table-column prop="svrip" label="服务器IP">
          </el-table-column>
          <el-table-column prop="offtype" label="下线类型" :formatter="formatOfftype">
          </el-table-column>
          <el-table-column prop="createtime" label="创建时间" :formatter="formatDate">
          </el-table-column>
        </el-table>
      </el-col>
    </el-row>
    <!--分页-->
    <el-row>
      <el-col :span="24">
        <el-pagination background
                       small
                       layout="prev, pager, next"
                       :page-size="table.pageSize"
                       :total="table.total"
                       :current-page="currentPage"
                       @current-change="handleCurrentChange"
                       style="padding-top:15px;float:right;">
        </el-pagination>
      </el-col>
    </el-row>
  </section>
</template>
<script>
import {mapGetters} from 'vuex';
import util from '../../../components/utils/js/util';

export default {
  data () {
    return {
      search: {
        userid: ''
      },
      currentPage: 1,
      // advancedSearchVisible: false,
      listLoading: true
      // advancedSearch: {
      //   userid: ''
      // },
      // advancedSearchRules: {
      //   userid: [
      //     {required: true, message: '请输入姓名', trigger: 'blur'}
      //   ]
      // }
    };
  },
  computed: {
    ...mapGetters({table: 'getList'})
  },
  methods: {
    // 获取用户信息列表
    handleList (currentPage) {
      this.currentPage = currentPage === undefined ? 1 : currentPage;
      this.$store.dispatch('queryList', {
        params: {
          currentPage: this.currentPage,
          userid: this.search.userid
        },
        e: this
      });
    },
    handleCurrentChange (val) {
      this.handleList(val);
    },
    //   selsChange: function (sels) {
    //     this.$store.dispatch('test/setSels', {sels: sels});
    //   },
    //   batchRemove: function () {
    //     this.$refs.delFrom.batchRemove();
    //   },
    // submitSearch (formName) {
    //   this.$refs[formName].validate((valid) => {
    //     if (valid) {
    //       console.log(formName);
    //     } else {
    //       return false;
    //     }
    //   });
    // },
    formatDate: function (row, column) {
      return util.formatDate.format(new Date(row[column.property]), 'yyyy-MM-dd');
    },
    formatDateLogtype: function (row, column) {
      return row.logtype === 0 ? '终端' : '';
    },
    formatOfftype: function (row, column) {
      let offtype = '';
      switch (row.offtype) {
        case 1:
          offtype = '正常下线';
          break;
        case 2:
          offtype = '超时下线';
          break;
        default:
          offtype = '强制下线';
      }
      return offtype;
    }
  },
  mounted () {
    this.handleList();
  }
};

</script>
