import 'package:flutter/material.dart';
import 'package:toast/toast.dart';
///首页->侧滑菜单
class DrawerPage extends StatefulWidget{


  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return new DrawerState();
  }
}

class DrawerState extends State<DrawerPage>{
  double _heightAll = 0;//整个屏幕的高度
  double _heightTitle = 0;//title的高度
  List<Widget> _list = new List();
  Widget _getRow(String url,String str,IconData data,bool isIcon){
    return new Row(children: <Widget>[
      new Builder(//左上角主要图标
        builder: (BuildContext context) {
          return IconButton(
            icon: isIcon?Icon(data):Image.asset(url,height: 30,),
            onPressed: () { Scaffold.of(context).openDrawer(); },
            tooltip: MaterialLocalizations.of(context).openAppDrawerTooltip,
          );
        },
      ),
      new Text(str,
        style: new TextStyle(color: Colors.black,fontSize: 20),
      ),
    ],
    );
  }
  @override
  Widget build(BuildContext context) {
    if(_list.isEmpty){
      _list.add(_getRow("asset/attention.png", "关注",null,false));
      _list.add(_getRow("asset/friend.png", "好友",null,false));
      _list.add(_getRow("asset/collection.png", "收藏",null,false));
      _list.add(_getRow("asset/order.png", "订单",null,false));
      _list.add(_getRow(null, "TapTap周边",Icons.shop,true));
      _list.add(_getRow(null, "兑换中心",Icons.party_mode,true));
      _list.add(_getRow(null, "意见反馈",Icons.opacity,true));
      _list.add(_getRow(null, "设置",Icons.settings,true));
      _list.add(_getRow(null, "夜间模式",Icons.mood,true));
      _list.add(_getRow(null, "当前版本2.1.4",Icons.warning,true));
    }
    _heightAll = MediaQuery.of(context).size.height;
    _heightTitle = Theme.of(context).textTheme.display1.fontSize * 1.1 + 200.0;
    return new Drawer(
      child: new Column(
        children: <Widget>[
          new Container(///上方头部
            constraints: BoxConstraints.expand(
              height: _heightTitle,
            ),
            color: Colors.blue,
            alignment:Alignment.centerLeft,//中间左对齐
            child: new Container(
              height: 80,
              margin: const EdgeInsets.all(10),
              child: new Column(
                children: <Widget>[
                  new Builder(//左上角主要图标
                    builder: (BuildContext context) {
                      return IconButton(
                        icon: Image.asset("asset/persion_white.png"),
                        onPressed: () { Scaffold.of(context).openDrawer(); },
                        tooltip: MaterialLocalizations.of(context).openAppDrawerTooltip,
                      );
                    },
                  ),
                  new Text("点击头像登录",style: new TextStyle(color: Colors.white,),),
                ],
              ),
            ),
          ),
          new Container(///下方列表
            constraints: BoxConstraints.expand(
              height: _heightAll-_heightTitle,
            ),
            child: new ListView.builder(
              padding: EdgeInsets.only(top: 0),
              itemBuilder: (BuildContext context,int index) => _list[index],
              itemCount: _list.length,
            ),
          )
        ],
      ),
    );
  }

}

