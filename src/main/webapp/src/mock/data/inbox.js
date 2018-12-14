import Mock from 'mockjs';

const Inboxs = [];

for (let i = 0; i < 86; i++) {
  Inboxs.push(Mock.mock({
    id: Mock.Random.guid(),
    appmsgId: Mock.Random.integer(10000, 99999),
    sender: Mock.Random.integer(10000, 99999),
    receiver: Mock.Random.integer(10000, 99999),
    status: Mock.Random.integer(1, 2),
    receiverTime: Mock.Random.date(),
    createDTime: Mock.Random.date(),
    updateDTime: Mock.Random.date(),
    batchNumber: Mock.Random.integer(10000, 99999)
  }));
}

export { Inboxs };
