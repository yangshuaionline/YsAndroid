import 'package:flutter/material.dart';

class MyGamePage extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return new MyGameState();
  }
}

class MyGameState extends State<MyGamePage>{
  Size _sizeAll;//设备的宽高等属性
  List<Widget> tabsList = new List();
  @override
  Widget build(BuildContext context) {
    if(tabsList.isEmpty){
      _sizeAll = MediaQuery.of(context).size;
      tabsList.add(new Center(child: new Text("已装")));
      tabsList.add(new Center(child: new Text("更新")));
      tabsList.add(new Center(child: new Text("预约")));
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