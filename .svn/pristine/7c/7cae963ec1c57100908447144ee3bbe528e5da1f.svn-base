import Mock from 'mockjs';

const MonitorPots = [];

for (let i = 0; i < 86; i++) {
  MonitorPots.push(Mock.mock({
    id: Mock.Random.guid(),
    keyId: Mock.Random.integer(10000, 99999),
    des: Mock.Random.string(),
    remark: Mock.Random.string(),
    appId: Mock.Random.integer(10000, 99999),
    cMarco: Mock.Random.string(),
    createTime: Mock.Random.date(),
    updateTime: Mock.Random.date(),
    type: Mock.Random.integer(0, 1)
  }));
}

export { MonitorPots };
