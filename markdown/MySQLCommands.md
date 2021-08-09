# MySQL Commands

## Usage: mysql [OPTIONS] [database]

## options

### -?, --help 显示此帮助并退出。

### -I, --help 同义词 -?

### --auto-rehash

- 启用自动重新哈希。一个不需要使用 'rehash' 获取表和字段完成，但启动并且重新连接可能需要更长的时间。

### --disable-auto-rehash  

- 禁用自动重新哈希（默认为开启；使用 --skip-auto-rehash 禁用。）

### -A, --no-auto-rehash   

- 没有自动重新哈希。必须使用“rehash”才能获得 表和字段完成。这样可以更快地开始mysql 并在重新连接时禁用重新哈希。

### --auto-vertical-output 

- 自动切换到垂直输出模式，如果结果比终端宽度宽。

### -B, --batch

-  不要使用历史文件。禁用交互行为。（启用 --silent。）

### --bind-address=name 

- 要绑定到的 IP 地址。

### --binary-as-hex

-  将二进制数据打印为十六进制

### --character-sets-dir=name 

- 字符集文件的目录。

### --column-type-in​​fo 

- 显示列类型信息。

### -c, --comments 

- 保留注释。向服务器发送评论。这默认是--skip-comments（丢弃评论），启用与--comments。

### -C, --compress 

- 在服务器/客户端协议中使用压缩。

### -#, --debug[=#] 

- 这是一个非调试版本。抓住这个并退出。

### --debug-check 

- 这是一个非调试版本。抓住这个并退出。

### -T, --debug-info 

- 这是一个非调试版本。抓住这个并退出。

### -D, --database=name 

- 要使用的数据库。

### --default-character-set=name 

- 设置默认字符集。

### --delimiter=name 

- 要使用的分隔符。

### --enable-cleartext-plugin 

- 启用/禁用明文身份验证插件。

### -e, --execute=name 

- 执行命令并退出。 （禁用 --force 和历史文件。）

### -E, --vertical 

- 垂直打印查询（行）的输出。

### -f, --force 

- 即使我们收到 SQL 错误，也要继续。

### --histignore=name 

- 以冒号分隔的模式列表，用于保留语句从登录到 syslog 和 mysql 历史记录。

### -G, --named-commands 

- 启用命名命令。命名命令意味着这个程序的内部命令；请参阅 mysql> 帮助。启用后，命名命令可以在查询的任何行中使用，否则只能从第一行开始，在输入之前。使用 --disable-named-commands 禁用。这个选项是默认禁用。

### -i, --ignore-spaces 

- 忽略函数名后的空格。

### --init-command=name 

- SQL 命令在连接到 MySQL 服务器时执行。重新连接时会自动重新执行。

### --local-infile 

- 启用/禁用加载数据本地文件。

### -b, --no-beep 

- 关闭错误提示音。

### -h, --host=name 

- 连接到主机。

### -H, --html 

- 产生 HTML 输出。

### -X, --xml 

- 产生 XML 输出。

### --line-numbers 

- 为错误写行号。（默认为开启；使用 --skip-line-numbers 禁用。）

### -L, --skip-line-numbers 

- 不要为错误写行号。

### -n, --unbuffered 

- 每次查询后刷新缓冲区。

### --column-names 

- 在结果中写入列名。（默认为开启；使用 --skip-column-names 禁用。）

### -N, --skip-column-names 

- 不要在结果中写入列名。

### --signt-ignore

-  忽略 SIGINT (CTRL-C)。

### -o, --one-database 

- 忽略语句，除了那些发生在默认数据库是在命令行中命名的数据库。

### --pager[=name] 

- 用于显示结果的寻呼机。如果您不提供选项，默认寻呼机取自您的 ENV 变量寻呼机。有效的寻呼机是less, more, cat [> filename],等。另请参阅交互式帮助 (\h)。此选项不在批处理模式下工作。使用 --disable-pager 禁用。这默认情况下禁用选项。

### -p, --password[=name] 

- 连接到服务器时使用的密码。如果密码是没有给出它是从 tty 询问的。

### -P, --port=# 

- 用于连接的端口号或默认为 0，在优先顺序，my.cnf，$MYSQL_TCP_PORT，/etc/services，内置默认值 (3306)。

### --prompt=name

-  将 mysql 提示设置为此值。

### --protocol=name 

- 用于连接的协议（tcp、socket、pipe、记忆）。

### -q, --quick 

- 不缓存结果，逐行打印。这可能会慢如果输出暂停，则关闭服务器。不使用历史文件。

### -r, --raw 

- 写入字段而无需转换。与 --batch 一起使用。

### --reconnect 

- 如果连接丢失，则重新连接。禁用

### --disable-reconnect

- 默认情况下启用此选项。（默认为开启；使用 --skip-reconnect 禁用。）

### -s, --silent 

- 更安静。使用制表符作为分隔符打印结果，新行上的每一行。

### -S, --socket=name 

- 用于连接的套接字文件。

### --ssl-mode=name 

- SSL 连接模式。

### --ssl 

- 已弃用。改用 --ssl-mode 。（默认为开启；使用 --skip-ssl 禁用。）

### --ssl-verify-server-cert 

- 已弃用。改用 --ssl-mode=VERIFY_IDENTITY 。

### --ssl-ca=name

-  PEM 格式的 CA 文件。

### --ssl-capath=name 

- CA 目录。

### --ssl-cert=name

-  PEM 格式的 X509 证书。

### --ssl-cipher=name 

- 要使用的 SSL 密码。

### --ssl-key=name 

- PEM 格式的 X509 密钥。

### --ssl-crl=name 

- 证书吊销列表。

### --ssl-crlpath=name 

- 证书吊销列表路径。

### --tls-version=name 

- 要使用的 TLS 版本，允许的值为：TLSv1、TLSv1.1、TLSv1.2

### --server-public-key-path=name 

- PEM 格式的服务器公共 RSA 密钥的文件路径。

### --get-server-public-key 

- 获取服务器公钥

### -t, --table

-  以表格格式输出。

### --tee=name

-  将所有内容附加到输出文件中。查看交互式帮助 (\h)还。在批处理模式下不起作用。禁用

### --disable-tee。

- 默认情况下禁用此选项。

### -u, --user=name 

- 如果不是当前用户，则用于登录的用户。

### -U, --safe-updates 

- 只允许使用密钥的 UPDATE 和 DELETE。

### -U, --i-am-a-dummy 

- 选项的同义词 --safe-updates, -U。

### -v, --verbose 

- 写更多。 （-v -v -v 给出表格输出格式）。

### -V, --version 

- 输出版本信息并退出。

### -w, --wait

-  等待并在连接断开时重试。

### --connect-timeout=# 

- 连接超时前的秒数。

### --max-allowed-packet=# 

- 发送或接收的最大数据包长度服务器。

### --net-buffer-length=# 

- TCP/IP 和套接字通信的缓冲区大小。

### --max-join-size=#

-  使用时自动限制连接中的行

### --safe-updates。

### --secure-auth 

- 拒绝客户端连接到服务器，如果它使用旧的(pre-4.1.1) 协议。已弃用。永远正确

### --server-arg=name 将此作为参数发送嵌入式服务器。

### --show-warnings 

- 在每条语句后显示警告。

### -j, --syslog

-  将过滤后的交互命令记录到 syslog。过滤命令取决于通过 histignore 提供的模式除了默认模式之外的选项。

### --plugin-dir=name 

- 客户端插件的目录。

### --default-auth=name 

- 要使用的默认身份验证客户端插件。

### --binary-mode 

- 默认情况下，不允许使用 ASCII '\0' 而 '\r\n' 是翻译成'\n'。这个开关关闭这两个功能，并关闭对所有客户端命令的解析，除了\C 和 DELIMITER，处于非交互模式（用于输入通过管道传输到 mysql 或使用“源”命令加载）。这在处理 mysqlbinlog 的输出时是必需的可能包含斑点。

### --connect-expired-password

-  通知服务器此客户端已准备好处理过期密码沙盒模式。

## default

### 默认选项按给定顺序从以下文件中读取：
/etc/my.cnf /etc/mysql/my.cnf ~/.my.cnf
读取以下组：mysql客户端
以下选项可以作为第一个参数给出：

- --print-defaults 打印程序参数列表并退出。
- --no-defaults 不要从任何选项文件中读取默认选项，除了登录文件。
- --defaults-file=# 仅从给定文件中读取默认选项#。
- --defaults-extra-file=# 在读取全局文件后读取此文件。
- --defaults-group-suffix=# 还可以使用 concat(group, suffix) 读取组
- --login-path=# 从登录文件中读取此路径。

### 变量 (--variable-name=value)和布尔选项 {FALSE|TRUE} 值（阅读选项后）

Variables (--variable-name=value)
and boolean options {FALSE|TRUE}  Value (after reading options)
--------------------------------- ----------------------------------------
auto-rehash                       TRUE
auto-vertical-output              FALSE
bind-address                      (No default value)
binary-as-hex                     FALSE
character-sets-dir                (No default value)
column-type-info                  FALSE
comments                          FALSE
compress                          FALSE
database                          (No default value)
default-character-set             auto
delimiter                         ;
enable-cleartext-plugin           FALSE
vertical                          FALSE
force                             FALSE
histignore                        (No default value)
named-commands                    FALSE
ignore-spaces                     FALSE
init-command                      (No default value)
local-infile                      FALSE
no-beep                           FALSE
host                              (No default value)
html                              FALSE
xml                               FALSE
line-numbers                      TRUE
unbuffered                        FALSE
column-names                      TRUE
sigint-ignore                     FALSE
port                              0
prompt                            mysql>
quick                             FALSE
raw                               FALSE
reconnect                         TRUE
socket                            (No default value)
ssl                               TRUE
ssl-verify-server-cert            FALSE
ssl-ca                            (No default value)
ssl-capath                        (No default value)
ssl-cert                          (No default value)
ssl-cipher                        (No default value)
ssl-key                           (No default value)
ssl-crl                           (No default value)
ssl-crlpath                       (No default value)
tls-version                       (No default value)
server-public-key-path            (No default value)
get-server-public-key             FALSE
table                             FALSE
user                              (No default value)
safe-updates                      FALSE
i-am-a-dummy                      FALSE
connect-timeout                   0
max-allowed-packet                16777216
net-buffer-length                 16384
select-limit                      1000
max-join-size                     1000000
secure-auth                       TRUE
show-warnings                     FALSE
plugin-dir                        (No default value)
default-auth                      (No default value)
binary-mode                       FALSE
connect-expired-password          FALSE


## --select-limit=# 

### 使用 --safe-updates 时自动限制 SELECT。

