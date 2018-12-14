import Mock from 'mockjs';

const Appsvrs = [];

for (let i = 0; i < 98; i++) {
  Appsvrs.push(Mock.mock({
    id: Mock.Random.guid(),
    appId: Mock.Random.integer(10000, 99999),
    appName: Mock.Random.integer(10000, 99999),
    bigCmd: Mock.Random.string(),
    appDes: Mock.Random.string(),
    createTime: Mock.Random.date(),
    updateTime: Mock.Random.date()
  }));
}

export { Appsvrs };
