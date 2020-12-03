## 一、Git是什么 

Git是目前世界上最先进的分布式版本控制系统

工作流程：

![img](https://img-blog.csdnimg.cn/2019031114145422.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ5NDY1,size_16,color_FFFFFF,t_70)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

**名词**

- **master: 默认开发分支**
- **origin: 默认远程版本库**
- **Index / Stage：暂存区**
- **Workspace：工作区**
- **Repository：仓库区（或本地仓库）**
- **Remote：远程仓库** 

## 二、Git基本结构结构 

<img src="https://img-blog.csdnimg.cn/20190320224319446.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ5NDY1,size_16,color_FFFFFF,t_70" alt="img" style="zoom:80%;" />![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

## 三、本地库和远程库 

### **1、团队内部协作**

<img src="https://img-blog.csdnimg.cn/20190320224535391.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ5NDY1,size_16,color_FFFFFF,t_70" alt="img" style="zoom:80%;" />![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

###  **2、跨团队协作**

<img src="https://img-blog.csdnimg.cn/20190320225139760.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ5NDY1,size_16,color_FFFFFF,t_70" alt="img" style="zoom:80%;" />![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

## 四、Git基本原理 

哈希是一个系列的加密算法，各个不同的哈希算法虽然加密强度不同，但是有一下几个共同点：

- 不管输入数据的数据量有多大，输入同一个哈希算法，得到的加密结果长度固定
- 哈希算法确定，输入数据确定，输出数据能够保证不变
- 哈希算法确定，输入数据有变化，输出数据一定有变化，而且变化很大
- 哈希算法不可逆

**常见的hash算法**（摘自 百度百科）：

（1）MD4

MD4（RFC 1320）是 MIT 的Ronald L. Rivest在 1990 年设计的，MD 是 Message Digest（消息摘要） 的缩写。它适用在32位字长的处理器上用高速软件实现——它是基于 32位操作数的位操作来实现的。

（2）MD5

MD5（RFC 1321）是 Rivest 于1991年对MD4的改进版本。它对输入仍以512位分组，其输出是4个32位字的级联，与 MD4 相同。MD5比MD4来得复杂，并且速度较之要慢一点，但更安全，在抗分析和抗差分方面表现更好。

（3）SHA-1及其他

SHA1是由NIST NSA设计为同DSA一起使用的，它对长度小于264的输入，产生长度为160bit的散列值，因此抗穷举（brute-force）性更好。SHA-1 设计时基于和MD4相同原理，并且模仿了该算法。



**Git底层采用的是SHA-1算法来保证数据的完整性**，如下图

![img](https://img-blog.csdnimg.cn/20190320224056173.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ5NDY1,size_16,color_FFFFFF,t_70)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

## 五、命令 

### **1. 配置**

#### **1.1 全局指定仓库的用户名和邮箱（为了区别不同的开发人员身份）**

> git config --global user.name zxc
>
> git config --global user.email 512724412@qq.com

 **信息保存在 ~/.gitconfig文件**

![img](https://img-blog.csdnimg.cn/20190320230116653.png)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

#### **1.2 项目级别/仓库级别**

> git config user.name zxc
>
> git config user.email 512724412@qq.com

**信息保存在：.git/config文件**

![img](https://img-blog.csdnimg.cn/2019032023003263.png)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

#### **1.3 查看配置文件**

> git config --list **显示当前Git配置**
>
> git config -e [--global] **编辑Git配置文件**

![img](https://img-blog.csdnimg.cn/20190311143857474.png)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

### **2. 新建代码库**

> git init 在当前目录新建一个Git代码库
>
> git init [project-name] 新建一个目录，初始化为 Git代码库
>
> git clone [url] 克隆一个项目

![img](https://img-blog.csdnimg.cn/20190311144659794.png)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

### **3. 基本操作**

> git status : 查看当前仓库中文件的状态。
>
> git status -s : 文件状态的简写（M - 修改， A - 添加， D - 删除， R - 重命名，?? - 未追踪）
>
> git add <文件名> ：将后方紧跟的文件进行暂存，以便commit使用。
>
> git checkout -- <文件名> ：**撤销对尚未暂存文件的修改**，该操作不可逆，慎用。
>
> **注意：命令git checkout -- readme.txt 中的 -- 很重要，如果没有 -- 的话，那么命令变成创建分支了**
>
> git commit -a : 对那些被修改的文件单尚未暂存和提交的文件进行暂存和提交。注意：对未暂存的新增文件无效。
>
> git commit : 对暂存区的文件进行提交到本地仓库
>
> git rm : 删除工作区文件，并将这次删除放入暂存区
>
> **git rm --cached[file] : 停止追踪指定文件，但该文件会保留在工作区**
>
> git reset HEAD <文件名> : 将已经暂存的文件进行撤销，回到未暂存的状态

![img](https://img-blog.csdnimg.cn/20190311151636836.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ5NDY1,size_16,color_FFFFFF,t_70)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

###  **4. 查看信息**

git status : 查看有变更的文件

git diff [文件名]: 查看工作区和暂存区的差异

git diff [本地库中历史版本][文件名] ：工作区的文件和本地库历史进行比较

git log : 显示当前分支的版本历史

![img](https://img-blog.csdnimg.cn/20190320230540694.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ5NDY1,size_16,color_FFFFFF,t_70)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

git log --pretty=oneline :漂亮格式查看版本历史

![img](https://img-blog.csdnimg.cn/20190320230639765.png)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

git log --oneline

![img](https://img-blog.csdnimg.cn/20190320230731242.png)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

git reflog : 查看当前分支的所有历史

![img](https://img-blog.csdnimg.cn/20190320230747546.png)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

### **5. 版本回退**

> git reset --hard[局部索引值]
>
> git reset --hard HEAD^ :一个^表示后退一步，n个表示后退n步
>
> git reset --hard HEAD~n : 表示后退n步

### **6. 分支**

在版本控制中，使多条线同时推进多个任务

![img](https://img-blog.csdnimg.cn/2019031116350192.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ5NDY1,size_16,color_FFFFFF,t_70)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

> git branch 显示所有本地分支
>
> git branch -v 查看分支
>
> git branch -a 列出所有本地分支和远程分支
>
> git branch[分支名] 创建一个分支，仍保留当前分支
>
> git branch -d [branch-name] 删除分支
>
> git checkout [分支名] 切换分支
>
> git checkout -b [分支名] 创建并切换分支
>
> 合并分支
>
> **1.切换到接受修改的分支 git checkout**
>
> **2.执行merge命令，合并修改 git merge [有新内容的分支]**

![img](https://img-blog.csdnimg.cn/2019031116483146.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ5NDY1,size_16,color_FFFFFF,t_70)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

### **7. 查看和修改远端地址** 

**git remote add [别名][远程地址] 设置默认远程版本库**

**git remote -v 显示所有远程仓库名称**

![img](https://img-blog.csdnimg.cn/20190321124918966.png)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

git push [remote] [branch] 上传本地指定分支到远程仓库 

![img](https://img-blog.csdnimg.cn/20190321125338386.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ5NDY1,size_16,color_FFFFFF,t_70)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

git pull [remote] [branch] 取回远程仓库变化，并于本地分支合并 

![img](https://img-blog.csdnimg.cn/20190321125148678.png)![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

git remote rm [仓库别名] 删除远端地址

git remote rename [仓库别名] 修改名称

git remote show [remote] 显示某个远程仓库的信息

git fetch[remote] 下载远程仓库的所有变动

git push [remote] --all 推送所有分支到远程仓库

git push -u

这个-u的用法，加了参数-u后，以后即可直接用git push 代替git push origin master

**git clone [remote]**  

- 完整的把远程库下载到本地
- 创建origin远程仓库别名
- 初始化本地库

<img src="https://img-blog.csdnimg.cn/20190311180420729.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ5NDY1,size_16,color_FFFFFF,t_70" alt="img" style="zoom:80%;" />![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

**由于本地Git仓库和github仓库之间的传输是通过SSH加密的，所以需要一点设置**：
第一步：创建SSH Key。在用户主目录下，看看有没有.ssh目录，如果有，再看看这个目录下有没有id_rsa和id_rsa.pub这两个文件，如果有的话，直接跳过此如下命令，如果没有的话，打开命令行，输入如下命令：

**$ ssh-keygen -t rsa -C "512724412@qq.com"**

<img src="https://img-blog.csdnimg.cn/20190311173228402.png" alt="img" style="zoom:80%;" />![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

 **id_rsa是私钥，不能泄露出去，id_rsa.pub是公钥，可以放心地告诉任何人。**

第二步：登录github,打开” settings”中的SSH Keys页面，然后点击“Add SSH Key”,填上任意title，在Key文本框里黏贴id_rsa.pub文件的内容。



<img src="https://img-blog.csdnimg.cn/20190311173502832.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ5NDY1,size_16,color_FFFFFF,t_70" alt="img" style="zoom: 67%;" />![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

[本文地址](https://blog.csdn.net/qq_40949465/article/details/88392863)

[参考地址](http://www.cnblogs.com/tugenhua0707/p/4050072.html)
