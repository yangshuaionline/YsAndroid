import 'package:flutter/material.dart';

class RankingPage extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return new RankingState();
  }
}

class RankingState extends State<RankingPage>{
  Size _sizeAll;//设备的宽高等属性
  List<Widget> tabsList = new List();
  @override
  Widget build(BuildContext context) {
    if(tabsList.isEmpty){
      _sizeAll = MediaQuery.of(context).size;
      tabsList.add(new Center(child: new Text("下载榜")));
      tabsList.add(new Center(child: new Text("新品榜")));
      tabsList.add(new Center(child: new Text("预约榜")));
      tabsList.add(new Center(child: new Text("热卖榜")));
      tabsList.add(new Center(child: new Text("热玩榜")));
      tabsList.add(new Center(child: new Text("厂商")));
    }
    return new DefaultTabController(
      length: tabsList.length,
      child: new Scaffold(
        appBar: new AppBar(
          backgroundColor: Colors.white,
          centerTitle: true,
          title: new TabBar(///上方导航栏
//            labelPadding: EdgeInsets.fromLTRB(0,0,0,0),
            isScrollable: true,
            tabs: tabsList,
            unselectedLabelColor: Colors.grey,
            labelColor:Colors.blue,
            indicatorColor:Colors.blue,
//            indicatorPadding: EdgeInsets.fromLTRB(_sizeAll.width/5,0,_sizeAll.width/5,0),
          ),
        ),
        body: new TabBarView(///下方显示内容
          children: tabsList,
        ),
      ),
    );
  }
}