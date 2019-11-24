## 项目目的
源于在做 React Native 包拆分的需求时，比较 bsdiff 和 google-diff-match-patch 在生成差量文件上的性能差异。
* bsdiff (http://www.daemonology.net/bsdiff/)
* google-diff-match-patch (https://github.com/bystep15/google-diff-match-patch)
* metro-bundle(https://facebook.github.io/metro/)    

## 实验数据

* Hello World 工程中的jsbundle对比

| 工具名称                   | bsdiff        | google-diff-match-patch | metro-bundle  |
| -------------------------- | ------------- | ----------------------- | ------------- |
| Common包                   | 764,783 bytes | 764,783 bytes           | 764,783 bytes |
| HelloWorld完整包           | 767,338 bytes | 767,338 bytes           | 767,338 bytes |
| HelloWorld业务补丁 (patch) | 1,337 bytes   | 43,321 bytes            | 2,219 bytes   |
| 拆分时间 (diff time)       | 457 ms        | 2642 ms                 | -             |
| 合并时间 (patch time)      | 14.2 ms       | 580 ms                  | -             |
