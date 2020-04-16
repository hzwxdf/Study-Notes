# Git版本控制系统
  [学习参考廖雪峰](https://www.liaoxuefeng.com/wiki/896043488029600)
  [学习md格式][1]
  [1]: https://www.liaoxuefeng.com/wiki/896043488029600
  <https://www.liaoxuefeng.com/wiki/896043488029600>

## git安装和环境准备

### git安装
  本次使用windows版本的git安装，默认github有账号。
  git下载地址：https://gitforwindows.org/
  1) 安装的话一直点下一步就可以了。
  2) 安装完成后会有几个应用。git bash、git cmd、git gui。
  3) 我们后续都是使用git bash。
### git的配置
  1. 打开git bash输入以下命令配置用户名和邮箱
  ```
  # 配置全局用户名
  git config --global  user.name "github网站的用户名"
  # 配置全局邮箱
  git config --global user.email "github网站的邮箱"
  ```
  配置好后可以输入一下命令确认
  ```
  git config --global --list
  ```
  2. ssh密钥创建
  输入一下命令创建ssh密钥
  ```
  ssh-keygen -t rsa -路径 "github绑定邮箱"
  ```
  创建过程会有三次输入操作
  1）是路径确认，直接按回车存默认路径即可
  2）直接回车键，这里我们不使用密码进行登录, 用密码太麻烦;
  3）确认密码,直接回车键
  结束后会在对应路径下生成：id_rsa和id_rsa.pub两个文件。我们需要复制id_rsa.pub的内容。
  3. github的ssh连接
  将id_rsa.pub的内容复制到github网站的`SSH key`中(title部分随便填，keys的内容就是复制的内容)。
  可以在Git bash中输入一下命令确认,出现Successfully就代表成功。
  ```
  ssh -T git@github.com
  ```
  4. 本地创建本地仓库
  在本地创建一个目录当做本地仓库，然后执行`git init`,这时目录下就多了.git隐藏文件夹了。
  1）在当前目录下新建一个readme.md文件
  2）然后使用`git add .`添加文件到暂存区
  3）然后`git commit -m '注释'`提交。
  5. 上传到github仓库
  1) 在github网站复制一个创建好的仓库地址。
  2）Git bash中执行`git remote add origin 复制的仓库地址`,关联远程仓库。
  3）Git bash执行`git push -u origin master`推到远程仓库。(如果出错'failed to push some refs to git'，那么可能是远程仓库的readme.md文件本地没有，可以执行`git pull --rebase origin master`解决)

## git版本库
  版本库，又叫仓库。可以理解成一个目录，目录下所有文件都是由git管理的，你可以回退、查询、追踪修改历史等等。
  1. 新建目录
  ```
  mkdir learngit
  ```
  2. 把目录变成git可以管理的仓库
  ```
  cd learngit
  git init
  ```
  目录变成git仓库后，目录下回多出一个*.git*文件，这个文件是记录文件修改的，最好别轻易动。
  看不见文件，可能被隐藏，可以使用*ls -ah*查看
  3. 添加文件到版本库
  使用git需要注意：使用纯文本方式编写文件。推荐使用utf-8的编码(推荐notepad++文本编辑器)。
  新建文件*readme.txt*,内容如下
  > this is first line!
  > this is second line!
  将*readme.txt*文件添加到版本库：添加 --> 提交
  添加readme.txt到仓库
  ```
  git add readme.txt
  ```
  提交readme.txt到仓库
  ```
  git commit -m "这是这次提交的信息：提交了一个文件readme.txt"
  ```
  注：可以提交多个文件到仓库
  ```
  # 提交多个
  git add file1.txt file2.txt
  # 提交全部
  git add .
  ```

## 时光机穿梭(回退、撤销)
  *git status*可以查看当前仓库的状态。
  *git diff*可以查看修改文件的详细修改信息。
  现在修改*readme.txt*,内容如下：
  > this is first line!
  > this is 2 line!
  我们可以使用*git status*查看仓库状态，*git diff*查看本次修改的内容。
  然后添加提交到仓库。
  ```
  git add readme.txt
  git commit -m "修改：second改成2"
  ```
### 版本回退
  我们想要回退到的某个版本，我们可以使用版本回退。
  git的版本回退很快，是因为有个HEAD指针指向当前版本，回退只是调整指针的指向，并更新你的工作区。
  1. 回退到过去的版本
  *git log*可以查看最近到最远的提交记录
  *git log --pretty=oneline*可以让提交记录好看点。
  *git reset*回退到某个版本,当然git需要知道那个版本。
  *git reset --hard HEAD^*表示回退到上一个版本，HEAD^^回退到上上一个版本。^太多时可能不方便。我们可以使用HEAD~100.表示回退到100个版本前。
  2. 过去再回到未来的版本
  如果窗口没关闭可以找到未来的版本号，然后使用*git reset -hard 版本号*来回退到未来的某个版本(版本号不用写全，git会自动查找)。
  *git reflog*查看命令历史,会记录你的所有操作。
  我们可以通过*git reflog*来找到未来的版本号，然后指向*git reset -hard 版本号*来回退到某个版本。  

### 工作区和暂存区
  工作区就是能看见git的目录。
  暂存区就是存放你使用git add添加的文件的。
  *git add a.txt*表示把a.txt添加到暂存区，*git commit*表示把暂存区所有文件提交到分支上。
### 撤销修改
  1. 你修改了工作区的文件*readme.txt*，想要撤销修改
  ``` git checkout -- readme.txt ```
  上面会将*readme.txt*撤销到没有修改前。
  2. 你已经添加文件*readme.txt*到暂存区，然后又做了修改，想要撤销修改
  ``` git checkout -- readme.txt ```
  上面会将*readme.txt*撤销将文件添加到暂存区后的修改。
  3. 你修改了*readme.txt*，并提交到了暂存区。想要撤销暂存区
  ```
  git add readme.txt
  # 撤销
  git reset HEAD  readme.txt
  ```

### 删除文件
  1. 删除文件
  ```
  git add a.txt
  git commit
  # 删除
  git rm a.txt
  # 使用提交来告诉仓库，删除了
  git commit -m "delete a.txt"
  ```
  2. 撤销删除文集
  ```
  git checkout -- a.txt
  ```
  *git checkout*其实是用版本库里的版本替换工作区的版本，无论工作区是修改还是删除，都可以“一键还原”。
  注意：从来没有被添加到版本库就被删除的文件，是无法恢复的！

## 远程仓库
### 添加远程仓库
  1. 关联远程仓库(github创建一个仓库)
  ```
  # 关联远程仓库
  git remote add origin git@github.com:自己的github账户/learngit.git
  # 推送本地到远程仓库
  git push -u origin master
  ```
  由于远程库是空的，我们第一次推送master分支时，加上了-u参数，Git不但会把本地的master分支内容推送的远程新的master分支，还会把本地的master分支和远程的master分支关联起来，在以后的推送或者拉取时就可以简化命令。
  ```
  # 推送
  git push origin master
  ```
  2. 克隆仓库
  先创建远程仓库，然后本地克隆
  ```
  git clone git@github.com:github账户/github仓库名.git
  ```

## 分支关联
### 创建、切换分支
  1. 创建
  创建分支develop
  ```
  # 创建并切换分支
  git checkout -b develop
  # 等价于
  git branch develop
  git checkout develop
  ```
  可以使用*git branch*来查看git的当前所有分支
  2. 合并
  *git merge*命令用于合并指定分支到当前分支。
  假如在develop分支添加并提交了文件*dev.txt*，我们要将他合并到master分支中。
  ```
  # 切换到master主分支
  git checkout master
  # 将develop分支合并到当期master分支
  git merge develop
  ```
  3. 删除分支
  我们在develop分支开发完功能，合并到master分支后，需要删除develop分支
  ```
  git branch -d develop
  ```
  4. switch
  创建和切换分支
  ```
  # 创建并切换分支develop
  git switch -c develop
  # 切换分支
  git switch master
  ```

### 解决冲突
  当Git无法自动合并分支时，就必须首先解决冲突。解决冲突后，再提交，合并完成。
  解决冲突就是把Git合并失败的文件手动编辑为我们希望的内容，再提交。
  用*git log --graph*命令可以看到分支合并图
  ```
  git log --graph --pretty=oneline --abbrev-commit
  ```
### 分支管理
  通常，合并分支时，如果可能，Git会用Fast forward模式，但这种模式下，删除分支后，会丢掉分支信息。
如果要强制禁用Fast forward模式，Git就会在merge时生成一个新的commit，这样，从分支历史上就可以看出分支信息。
下面我们实战一下--no-ff方式的git merge：
  ```
  git merge --no-ff -m "由于是产生一次新commit，所以备注信息：merge develop" develop
  ```
### bug分支(储存当前的内容)
  *git stash*可以将当前工作区的内容(工作现场)存储起来，等后面需要用时再使用。
  *git stash list*查看所有存储的工作现场
  *git stash apply*恢复工作现场
  *git stash apply stash@{0}*恢复指定工作现场
  *git stash drop*删除工作现场
  *git stash pop*恢复并删除工作现场
  工作现场还在，Git把stash内容存在某个地方了，但是需要恢复一下，有两个办法：
  一是用*git stash apply*恢复，但是恢复后，stash内容并不删除，你需要用*git stash drop*来删除；
  另一种方式是用*git stash pop*，恢复的同时把stash内容也删了：
  Git专门提供了一个*cherry-pick*命令，让我们能复制一个特定的提交到当前分支：
### feature分支
  当开发一个新功能时可以建立feature分支来进行开发。
  例如开发一个邮件功能
  ```
  # 从当前分支创建一个feature/mail分支
  git switch -c feature/mail
  # 开发ing --> 开发结束
  # 合并到master分支
  git switch master
  git merge feature/mail
  # 当feature/mail开发完成还没有提交，但是这个功能不需要了，要删除(只能强制删除，使用-D)
  git branch -D feature/mail
  # 当feature/mail开发完已经提交到master了，需要删除可以使用普通分支删除(-d)
  git branch -d feature/mail
  ```
### 多人协作
  当在本地克隆远程仓库时，git会自动把本地master分支关联到远程仓库的origin/msater。
  *git remote*查看远程仓库信息
  *git remote -v*查看远程仓库的详细信息。
  1. 推送分支
  *git push origin develop*指定本地的develop分支推送到远程仓库。
  2. 关于多人协作的分支问题
  ```
  # 创建分支
  git checkout -b develop origin/develop
  # 将本地分支关联到远程仓库的分支
  git branch --set-upstream-to develop origin/develop
  ```
  如果远程仓库存在dev分支，而你的本地不存在dev，那么最好是先git pull一下，然后再执行：
  > $ git checkout -b dev origin/dev
  > 就可以自动关联分支，而不需要：
  > $ git branch --set-upstream-to dev origin/dev
  > 上面这条命令是在你本地已经建立了dev分支，但是还没有和远程dev分支关联的时候采用
  ```
  git checkout -b dev//基于本地创建分支
  git checkout -b dev origin/dev //基于远程分支创建本地分支
  # 删除远程分支
  git push origin --delete rpc
  ```
  总结： 
  •查看远程库信息，使用git remote -v；
  •本地新建的分支如果不推送到远程，对其他人就是不可见的；
  •从本地推送分支，使用git push origin branch-name，如果推送失败，先用git pull抓取远程的新提交；
  •在本地创建和远程分支对应的分支，使用git checkout -b branch-name origin/branch-name，本地和远程分支的名称最好一致；
  •建立本地分支和远程分支的关联，使用git branch --set-upstream branch-name origin/branch-name；
  •从远程抓取分支，使用git pull，如果有冲突，要先处理冲突。

### rebase
  我们可以通过rebase将git的记录变成一条直线。
  ```
  git rebase
  ```

## 标签管理
### 创建标签
  标签是为了方便查找对应的版本。
  ```
  # 假如现在有2个branch：master dev
  git checkout dev
  # 给当前分支dev,打上标签v1.0。默认给最新的commit打tag
  git tag v1.0
  # 指定版本号，例如：100ab1
  git tag v2.0 100ab1
  # 创建带说明的tag标签,版本号：a00ah1
  git tag -a v3.0 -m "这是第三次打标签tag" a00ah1
  # 查看所有标签tag
  git tag
  # 查看指定tag标签
  git show v1.0
  # 
  ```
### 标签操作
  ```
  # 删除标签
  git tag -d v1.0
  # 推送标签到远程仓库
  git push origin v1.0
  # 推送全部本地标签到远程仓库
  git push origin --tags
  # 删除远程标签(先本地删除，在推送到远程)
  git tag -d v1.0
  git push origin :refs/tags/v1.0
  ```

## 其他git知识
### patch文件打包和应用
  有时候我们需要将自己的修改代码部分发给别人，而不是使用git提交的形式。
  ```
  # 打包
  git diff > 文件名.patch
  # 应用
  git apply 文件名.patch
  ```

### git的reset和revert区别
  场景：现在有版本1、版本2、版本3
  1. reset:现在想回到版本1，版本1之后的都不要了，这时就可以使用reset。
  ```
  git reset --hard 版本1的版本号
  ```
  2. revert:现在想撤销版本2的修改，但是保留版本3的修改。
  ```
  git revert 版本2的版本号
  ```
  注：
  reset是让HEAD指向某个版本。revert是反做，照着版本2的操作来进行逆向操作。例如，你版本2添加了a.txt，revert就是删除a.txt。
  最重要的一点：revert 是回滚某个 commit ，不是回滚“到”某个