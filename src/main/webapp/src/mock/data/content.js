import Mock from 'mockjs';

const Contents = [];

for (let i = 0; i < 86; i++) {
  Contents.push(Mock.mock({
    id: Mock.Random.guid(),
    appmsgId: Mock.Random.integer(10000, 99999),
    msgType: Mock.Random.integer(0, 1, 2),
    msgSource: Mock.Random.integer(0, 1),
    msgTime: Mock.Random.date(),
    context: Mock.Random.paragraph(1, 1),
    expire: Mock.Random.date(),
    createTime: Mock.Random.date(),
    updateTime: Mock.Random.date()
  }));
}

export { Contents };
