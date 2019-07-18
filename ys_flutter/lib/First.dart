import 'package:flutter/material.dart';
import 'package:flutter/src/scheduler/ticker.dart';

import 'FirstListPage.dart';
import 'utils/Types.dart';

class FirstPage extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return new FirstState();
  }
}

class FirstState extends State<FirstPage>{
  Size _sizeAll;//设备的宽高等属性
  List<Widget> _tabsList = new List();
  List<Widget> _lists = new List();
  @override
  Widget build(BuildContext context) {
    if(_tabsList.isEmpty){
      _sizeAll = MediaQuery.of(context).size;
      _tabsList.add(new Center(child: new Text("游戏")));
      _tabsList.add(new Center(child: new Text("视频")));
      _lists.add(new FirstListWidget(GAME));
      _lists.add(new FirstListWidget(GAME));
    }
    return new DefaultTabController(
      length: _tabsList.length,
      child: new Scaffold(
        appBar: new AppBar(
          backgroundColor: Colors.white,
          centerTitle: true,
          title: new TabBar(///上方导航栏
//            labelPadding: EdgeInsets.fromLTRB(0,0,0,0),
            isScrollable: false,
            tabs: _tabsList,
            unselectedLabelColor: Colors.grey,
            labelColor: Colors.blue,
            indicatorColor: Colors.blue,
            indicatorPadding: EdgeInsets.fromLTRB(_sizeAll.width/5,0,_sizeAll.width/5,0),
          ),
        ),
        body: new TabBarView(///下方显示内容
          children: _lists,
        ),
      ),
    );
  }
}