# Docker commands

## Usage:  docker [OPTIONS] COMMAND

## OPTIONS

### --config string 

- 客户端配置文件的位置（默认"C:\\Users\\用户\\.docker")

###   -c, --context string 

- 用于连接到守护进程（覆盖 DOCKER_HOST 环境变量和使用“docker context use”设置的默认上下文）

###   -D, --debug 

- 开启调试模式

###   -H, --host 

- 列出要连接的守护进程套接字

###   -l, --log-level string 

- 设置日志级别（“debug”|“info”|“warn”|“error”|“fatal”）（默认“info”）

###       --tls 

- 使用 TLS;由 --tlsverify 暗示

###       --tlscacert string 

- 仅由该 CA 签名的信任证书（默认 "C:\\Users\\用户\\.docker\\ca.pem")

###       --tlscert string 

- TLS 证书文件的路径（默认 "C:\\Users\\用户\\.docker\\cert.pem")

###       --tlskey string 

- TLS 密钥文件的路径（默认 "C:\\Users\\用户\\.docker\\key.pem")

###       --tlsverify

-  使用 TLS 并验证远程

###   -v, --version 

- 打印版本信息并退出

## Management Commands

### builder

- 管理构建

###   buildx*

- 使用 BuildKit 构建（Docker Inc.，v0.5.1-docker）

###   compose*

- Docker Compose（Docker Inc.，v2.0.0-beta.6）

###   config

-  管理 Docker 配置

###   container

-  管理容器

###   context

-  管理上下文

###   image 

- 管理镜像

###   manifest 

- 管理 Docker 镜像清单和清单列表

###   network

-  管理网络

###   node 

- 管理 Swarm 节点

###   plugin

-  管理插件

###   scan* 

- Docker 扫描（Docker Inc.，v0.8.0）

###   secret 

- 管理 Docker 机密

###   service 

- 管理服务

###   stack 

- 管理 Docker 堆栈

###   swarm 

- 管理集群

###   system 

- 管理 Docker

###   trust 

- 管理对 Docker 镜像的信任

###  volume 

- 管理卷宗

## Commands

### attach 

- 将本地标准输入、输出和错误流附加到正在运行的容器

###  build  

- 从 Dockerfile 构建镜像

###   commit 

- 根据容器的更改创建一个新映像

###   cp 

- 在容器和本地文件系统之间复制文件/文件夹

###   create 

- 创建一个新的容器

###   diff 

- 检查对容器文件系统上的文件或目录的更改

###   events 

- 从服务器获取实时事件

###   exec 

- 在正在运行的容器中运行命令

###   export 

- 将容器的文件系统导出为 tar 存档

###   history 

- 显示镜像的历史

###   images

- 列出镜像

###   import 

- 从 tarball 导入内容以创建文件系统映像

###   info 

- 显示系统范围的信息

###   inspect 

- 检查返回有关 Docker 对象的低级信息

###   kill 

- 杀死一个或多个正在运行的容器

###   load 

- 从 tar 存档或 STDIN 加载图像

###   login 

- 登录到 Docker 注册表

###   logout 

- 从 Docker 注册表中注销

###   logs 

- 获取容器的日志

###   pause 

- 暂停一个或多个容器内的所有进程

###   port

-  列出端口映射或容器的特定映射

###   ps 

- 列出容器

###   pull 

- 从注册表中拉取镜像或存储库

###   push 

- 将映像或存储库推送到注册表

###   rename 

- 重命名容器

###   restart 

- 重启一个或多个容器

###   rm 

- 移除一个或多个容器

###   rmi 

- 删除一个或多个镜像

###   run 

- 在新容器中运行命令

###   save 

- 将一张或多张图像保存到 tar 存档（默认流式传输到 STDOUT）

###   search 

- 在 Docker Hub 中搜索图像

###   start 

- 启动一个或多个停止的容器

###   stats 

- 显示容器资源使用统计的实时流

###   stop 

- 停止一个或多个正在运行的容器

###   tag 

- 创建一个引用 SOURCE_IMAGE 的标签 TARGET_IMAGE

###   top 

- 显示容器正在运行的进程

###   unpause 

- 取消暂停一个或多个容器中的所有进程

###   update 

- 更新一个或多个容器的配置

###   version 

- 显示 Docker 版本信息

###   wait 

- 等待阻塞直到一个或多个容器停止，然后打印它们的退出代码

