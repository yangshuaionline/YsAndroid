import 'package:flutter/material.dart';

class ForumPage extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return new ForumState();
  }
}

class ForumState extends State<ForumPage>{
  Size _sizeAll;//设备的宽高等属性
  List<Widget> tabsList = new List();
  @override
  Widget build(BuildContext context) {
    if(tabsList.isEmpty){
      _sizeAll = MediaQuery.of(context).size;
      tabsList.add(new Center(child: new Text("板块")));
      tabsList.add(new Center(child: new Text("关注")));
      tabsList.add(new Center(child: new Text("热帖")));
    }
    return new DefaultTabController(
      length: tabsList.length,
      child: new Scaffold(
        appBar: new AppBar(
          backgroundColor: Colors.white,
          centerTitle: true,
          title: new TabBar(///上方导航栏
//            labelPadding: EdgeInsets.fromLTRB(0,0,0,0),
            isScrollable: false,
            tabs: tabsList,
            unselectedLabelColor: Colors.grey,
            labelColor:Colors.blue,
            indicatorColor:Colors.blue,
            indicatorPadding: EdgeInsets.fromLTRB(_sizeAll.width/5,0,_sizeAll.width/5,0),
          ),
        ),
        body: new TabBarView(///下方显示内容
          children: tabsList,
        ),
      ),
    );
  }
}