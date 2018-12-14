<template>
  <section>
    <el-row>
      <el-col :span="24">
        <el-collapse v-model="activeNames">
          <el-collapse-item title="用户类型信息" name="1">
            <template slot="title">
              <h3>用户类型信息</h3>
            </template>
            <el-table :data="deviceOnline.list1"
                      v-loading="listLoading"
                      max-height="420"
                      highlight-current-row
                      border
                      style="width: 100%; border-color: #DCDFE6;">
              <el-table-column prop="user_type" label="用户类型" :formatter="formatUserType">
              </el-table-column>
              <el-table-column prop="user_count" label="用户数量">
              </el-table-column>
            </el-table>
          </el-collapse-item>
          <el-collapse-item name="2">
            <template slot="title">
              <h3>设备类型信息</h3>
            </template>
            <el-table :data="deviceOnline.list2"
                      v-loading="listLoading"
                      max-height="420"
                      highlight-current-row
                      border
                      style="width: 100%; border-color: #DCDFE6;">
              <el-table-column prop="client_type" label="设备类型" :formatter="formatClientType">
              </el-table-column>
              <el-table-column prop="user_count" label="用户数量">
              </el-table-column>
            </el-table>
          </el-collapse-item>
        </el-collapse>
      </el-col>
    </el-row>
  </section>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
  name: 'device-online',
  data () {
    return {
      listLoading: true,
      activeNames: ['1', '2']
    };
  },
  computed: {
    ...mapGetters({deviceOnline: 'getDeviceOnline'})
  },
  methods: {
    // 性别显示转换
    formatUserType: function (row, column) {
      let userType = '';
      switch (row.user_type) {
        case 0:
          userType = '在线';
          break;
        case 1:
          userType = '不在线';
          break;
        default:
          userType = '其他';
      }
      return userType;
    },
    formatClientType: function (row, column) {
      let clientType = '';
      switch (row.client_type) {
        case 0:
          clientType = 'windowd PC';
          break;
        case 1:
          clientType = 'Wince车机';
          break;
        case 2:
          clientType = 'android车机';
          break;
        case 3:
          clientType = 'ipad车机';
          break;
        case 4:
          clientType = 'Wince后视镜';
          break;
        case 5:
          clientType = 'android后视镜';
          break;
        case 6:
          clientType = 'ios后视镜';
          break;
        case 7:
          clientType = 'iphone';
          break;
        case 8:
          clientType = 'android';
          break;
        case 9:
          clientType = 'windows';
          break;
        case 10:
          clientType = '行车记录仪';
          break;
        default:
          clientType = '外接服务器设备';
      }
      return clientType;
    }
  },
  mounted () {
    this.$store.dispatch('queryDeviceOnline', {
      params: {},
      e: this
    });
  }
};
</script>

<style scoped>

</style>
