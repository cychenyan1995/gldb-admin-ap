import Mock from 'mockjs';

const NavAddInfos = [];

for (let i = 0; i < 86; i++) {
  NavAddInfos.push(Mock.mock({
    id: Mock.Random.guid(),
    userId: Mock.Random.integer(10000, 99999),
    msgId: Mock.Random.integer(1000000, 9999999),
    longItude: Mock.Random.integer(1000000, 9999999),
    latItude: Mock.Random.integer(1000000, 9999999),
    title: Mock.Random.cname(),
    address: Mock.mock('@county(true)'),
    feedBack: Mock.Random.integer(0, 1),
    createTime: Mock.Random.date(),
    updateTime: Mock.Random.date()
  }));
}

export { NavAddInfos };
