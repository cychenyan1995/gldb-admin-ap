<template>
  <section class="chart-container">
    <div class="block">
      <span class="demonstration">请求时间</span>
      <el-date-picker
        v-model="time"
        type="daterange"
        value-format="yyyy-MM-dd"
        range-separator="至"
        start-placeholder="开始日期"
        end-placeholder="结束日期"
        :picker-options="pickerOptions0">
      </el-date-picker>
    </div>
    <el-row>
      <el-col :span="12">
        <div id="chartPie" style="width:100%; height:400px;"></div>
      </el-col>
    </el-row>
  </section>
</template>

<script>
import echarts from 'echarts';
import { mapGetters } from 'vuex';
import {formatDate} from '../../../components/utils/js/date.js';

export default {
  data () {
    const date = new Date();
    const startTime = formatDate(date, 'yyyy-MM-dd');
    const endTime = startTime;
    return {
      pickerOptions0: {
        disabledDate (time) {
          return time.getTime() > Date.now() - 8.64e6;
        }
      },
      chartPie: Object,
      time: [startTime, endTime],
      beginTime: '',
      endTime: ''
    };
  },

  computed: {
    ...mapGetters({table: 'getArr'})
  },
  methods: {
    handleList () {
      this.$store.dispatch('queryInboxList', {
        params: {
          beginTime: this.time[0],
          endTime: this.time[1]
        },
        e: this,
        callback: () => {
          this.chartPie = echarts.init(document.getElementById('chartPie'));
          this.chartPie.setOption({
            title: {
              text: '推送信息报表分析',
              subtext: '数据饼图',
              x: 'center'
            },
            tooltip: {
              trigger: 'item',
              formatter: '{a} <br/>{b} : {c} ({d}%)'
            },
            color: ['rgb(46,203,171)', 'rgb(228,52,72)', 'rgb(238,189,60)'],
            legend: {
              orient: 'vertical',
              left: 'left',
              data: (() => {
                var res = [];
                var len = this.table.list.length;
                for (var i = 0, size = len; i < size; i++) {
                  res.push({
                    name: this.table.list[i].status === 0 ? '请求成功' : this.table.list[i].status === 1 ? '请求失败' : '请求超时'
                  });
                };
                return res;
              })()
            },
            series: [
              {
                name: '访问来源',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: (() => {
                  var res = [];
                  var len = this.table.list.length;
                  for (var i = 0, size = len; i < size; i++) {
                    res.push({
                      name: this.table.list[i].status === 0 ? '请求成功' : this.table.list[i].status === 1 ? '请求失败' : '请求超时',
                      value: this.table.list[i].number
                    });
                  }
                  return res;
                })(),
                itemStyle: {
                  emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                  }
                }
              }
            ]
          });
        }
      });
    },

    drawCharts () {
      this.handleList();
    }
  },

  mounted: function () {
    this.drawCharts();
  },
  updated: function () {
    this.drawCharts();
  }
};
</script>

<style scoped>
  .chart-container {
    width: 100%;
    float: left;
  }
  /*.chart div {
      height: 400px;
      float: left;
  }*/

  .el-col {
    padding: 30px 20px;
  }
</style>
