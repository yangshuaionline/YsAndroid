import 'package:flutter/material.dart';

import 'Drawer.dart';
import 'Find.dart';
import 'First.dart';
import 'Forum.dart';
import 'MyGame.dart';
import 'Ranking.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: '我的游戏'),

    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);
  final String title;
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  bool _isShowText = false;
  int _currentIndex = 0;
  Widget _body = new FirstPage();
  void _onItemTapped(int index){
    setState(() {
      _currentIndex =index;
      _isShowText = index == 4?true:false;
      switch(index){
        case 0:
          _body = new FirstPage();
          break;
        case 1:
          _body = new FindPage();
          break;
        case 2:
          _body = new ForumPage();
          break;
        case 3:
          _body = new RankingPage();
          break;
        case 4:
          _body = new MyGamePage();
          break;
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      ///标题
      appBar: AppBar(
        title: _isShowText//标题，true为文字，false为图片
            ?Text(widget.title)
            :Image.asset("asset/logo_new.png",height: 30),
        centerTitle: true,
        leading:Builder(//左上角主要图标
          builder: (BuildContext context) {
            return IconButton(
              icon: Image.asset("asset/persion_white.png",width: 30,height: 30,),
              onPressed: () { Scaffold.of(context).openDrawer(); },
              tooltip: MaterialLocalizations.of(context).openAppDrawerTooltip,
            );
          },
        ),
        actions: !_isShowText//右侧小图标
              ?[
            Builder(//左上角主要图标
              builder: (BuildContext context) {
                return IconButton(
                  icon: Image.asset("asset/search_white.png",width: 25,height: 25,),
                );
              },
            )]
              :[
            Builder(//左上角主要图标
              builder: (BuildContext context) {
                return IconButton(
                  icon: Image.asset("asset/download_white.png",width: 25,height: 25,),
                );
              },
            ),
            Builder(//左上角主要图标
              builder: (BuildContext context) {
                return IconButton(
                  icon: Image.asset("asset/rocket_white.png"),
                );
              },
            )
          ]

      ),
      bottomNavigationBar: BottomNavigationBar(
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
              icon: Icon(Icons.home),
              title:Text('首页'),
          ),
          BottomNavigationBarItem(
            icon: ImageIcon(AssetImage("asset/find_black.png")),
            title:Text('发现'),
          ),
          BottomNavigationBarItem(
            icon: ImageIcon(AssetImage("asset/forum_black.png")),
            title:Text('论坛'),
          ),
          BottomNavigationBarItem(
            icon: ImageIcon(AssetImage("asset/ranking_black.png")),
            title:Text('排行'),
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.folder),
            title:Text('我的游戏'),
          ),
        ],
        currentIndex: _currentIndex,
        selectedItemColor: Colors.blue,
        unselectedItemColor:Colors.grey,
        onTap: _onItemTapped,
        type: BottomNavigationBarType.fixed,
      ),// This trailing comma makes auto-formatting nicer for build methods.
      body: _body,
      drawer: new DrawerPage(),//侧滑菜单
    );
  }
}
