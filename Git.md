# Git命令集合
新建一个README文档，若上一步勾选了创建README.md，提交时导致冲突  
>touch README.md

初始化本地仓库 
>git init  

添加刚刚创建的README文档 
>git add README.md   

提交到本地仓库，并写一些注释   
>git commit -m "你的注释...."   

连接远程仓库并建了一个名叫：origin的别名，当然可以为其他名字，但是origin一看就知道是别名，youname记得替换成你的用户名  
>git remote add origin git@github.com:yangshuaionline/YsAndroid.git

将本地仓库的文件提交到别名为origin的地址的master分支下，-u为第一次提交，需要创建master分支，下次就不需要了 
>git push -u origin master                              

提交代码
>git push origin master --force 