## 项目目的
源于在做 React Native 包拆分的需求时，比较 bsdiff 和 google-diff-match-patch 在生成差量文件上的性能差异。
* bsdiff (http://www.daemonology.net/bsdiff/)
* google-diff-match-patch (https://github.com/bystep15/google-diff-match-patch)

## 实验数据

* Hello World 工程中的jsbundle对比

| 工具名称                  | bsdiff    | google-diff-match-patch |
| ---                      | ---       | --- |
|Common包                  | 573,583 bytes | 573,583 bytes |
|HelloWorld完整包           | 574,294 bytes | 574,294 bytes | 
|HelloWorld业务补丁 (patch)    | 449 bytes |  981 bytes |
|拆分时间 (diff time)             | 182.6 ms | 79.8 ms |
|合并时间 (patch time)            | 14.2 ms | 55 ms  |
