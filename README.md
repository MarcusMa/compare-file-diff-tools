## 项目目的

源于在做 React Native 包拆分的需求时，比较 bsdiff 和 google-diff-match-patch 在生成差量文件上的性能差异。

- bsdiff (http://www.daemonology.net/bsdiff/)
- google-diff-match-patch (https://github.com/bystep15/google-diff-match-patch)
- metro-bundle(https://facebook.github.io/metro/)

## 实验数据

- Hello World 工程中的 jsbundle 对比

| 工具名称                    | bsdiff        | google-diff-match-patch | metro-bundle  |
| --------------------------- | ------------- | ----------------------- | ------------- |
| Common 包                   | 764,797 bytes | 764,797 bytes           | 764,797 bytes |
| HelloWorld 完整包           | 767,338 bytes | 767,338 bytes           | 767,338 bytes |
| HelloWorld 业务补丁 (patch) | 1,324 bytes   | 42,891 bytes            | 2,783 bytes   |
| 拆分时间 (diff time)        | 1,042 ms      | 2,410 ms                | -             |
| 合并时间 (patch time)       | 32 ms         | 258 ms                  | -             |
