import 'dart:async';

import 'package:flutter/material.dart';

import 'utils/ImageUrl.dart';

class FirstListWidget extends StatefulWidget{
  int _type = 0;
  FirstListWidget(int type){
    this._type = type;
  }
  @override
  State<StatefulWidget> createState() {
    return new FirstListState(_type);
  }
}

class FirstListState extends State<FirstListWidget>{
  double _refreshHeight = 200;
  int _type = 0;
  List<Widget> _list = new List();
  ScrollController _scrollController ;
  Container _container ;
  FirstListState(int type){
    this._type = type;
  }
  @override
  void initState() {
    super.initState();

    _scrollController = new ScrollController(initialScrollOffset:_refreshHeight);
    _scrollController.addListener(() {
      if (_scrollController.position.pixels
          == _scrollController.position.maxScrollExtent) {//加载
        _getMoreData();
      }else if (_scrollController.position.pixels
          < _scrollController.position.minScrollExtent+_refreshHeight/2) {//刷新
        _refresh();
      }
    });
  }
  double xy =  0;
  @override
  void dispose() {
    _scrollController.dispose();
    super.dispose();
  }
  bool _isPerformingRequest = true;
  ///创建上啦刷新widget
  Widget _buildProgressIndicator() {
    return new Padding(
      padding: const EdgeInsets.all(8.0),
      child: new Center(
        child: new Opacity(
          opacity: _isPerformingRequest ? 1.0 : 0.0,
          child: new CircularProgressIndicator(),
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    if(_list.isEmpty){
      for(int i = 0;i<10;i++){
        if(i == 0){
          _container = new Container(
            height: _refreshHeight,
            child: new Text("刷新",
              style: new TextStyle(),
              textAlign: TextAlign.center,
            ),
          );
          _list.add(_container);
        }else{
          _list.add(new App());
        }
      }
    }
    return new Container(
      child: new ListView.builder(
        padding: EdgeInsets.only(left: 10,right: 10),
        itemBuilder: (context,index){
          if(index == _list.length){
            return _buildProgressIndicator();
          }else{
            return _list[index];
          }
        },
        itemCount: _list.length+1,
        controller: _scrollController,
      ),
    );
  }
  Future<Null> _refresh() async{
    _isPerformingRequest = true;
    _list.clear();
    Future.delayed(
        const Duration(milliseconds: 1000),
            (){
              setState(() {
                _scrollController.animateTo(
                    _refreshHeight/2,
                    duration: new Duration(milliseconds: 500),
                    curve: Curves.easeOut);
                Future.delayed(
                    const Duration(seconds: 2),
                        (){
                          setState(() {
                            for(int i = 0;i<10;i++){
                              if(i == 0){
                                _list.add(_container);
                              }else{
                                _list.add(new App());
                              }
                            }
                            _scrollController.animateTo(
                                _refreshHeight,
                                duration: new Duration(milliseconds: 500),
                                curve: Curves.easeOut);
                          });
                    });
              });
    });
  }

  _getMoreData() async {
    _isPerformingRequest = false;
    if(!_isPerformingRequest){
      Future.delayed(
          const Duration(seconds: 1),(){
            setState((){
              if(_list.length >50){
                double edge = 50.0;
                double offsetFromBottom = _scrollController.position.maxScrollExtent - _scrollController.position.pixels;
                if (offsetFromBottom < edge) {
                  _scrollController.animateTo(
                      _scrollController.offset - (edge -offsetFromBottom),
                      duration: new Duration(milliseconds: 500),
                      curve: Curves.easeOut);
                }
                _isPerformingRequest = false;
              }else{
                for (int i = 0; i < 10; i++) {
                  _list.add(new App());
                }
                _isPerformingRequest = true;
              }
            });
          }
      );
    }
  }
}

///App列表
class App extends StatelessWidget{

  @override
  Widget build(BuildContext context) {
    return new Container(
      child: new Column(
        crossAxisAlignment :CrossAxisAlignment.start,//设置内容靠左
        children: <Widget>[
          new Container(
            padding : EdgeInsets.only(left:5.0,top:10.0,right:5.0,bottom:10.0),
            child: new Text("版本更新",
              style: new TextStyle(color: Colors.black),
              textAlign: TextAlign.left,
            ),
          ),

          new Container(
            child: new Image.asset(gameBgCeshi),
          ),
          new Container(
            width: MediaQuery.of(context).size.width,
//            alignment: AlignmentDirectional.center,
            child: new Row(
              children: <Widget>[
                new Image.asset(taptap,width: 50,height: 50,),
                new Container(
                  padding: EdgeInsets.only(top: 10,bottom: 10),
                  width: MediaQuery.of(context).size.width-150-20,
                  child: new Column(
                    children: <Widget>[
                      new Container(
                        padding: EdgeInsets.only(left: 10),
                        height: 25,
                        alignment: AlignmentDirectional.centerStart,
                        child: new Text("测试title！",
                          textAlign: TextAlign.left,
                          style: new TextStyle(fontSize: 20),
                        ),
                      ),
                      new Container(
                        height: 25,
                        padding: EdgeInsets.only(left: 10),
                        alignment: AlignmentDirectional.centerStart,
                        child: new Text("测试content！",
                          textAlign: TextAlign.left,
                          style: new TextStyle(fontSize: 15),
                        ),
                      ),
                    ],
                  ),
                ),
                new Container(
                  width: 100,
//                  color: Colors.black,
                  child:new Column(
                    children: <Widget>[
                      new Container(
                        height: 25,
                        padding: EdgeInsets.only(right: 10),
                        alignment: AlignmentDirectional.centerEnd,
                        child: new Text("000人评分",
                          textAlign: TextAlign.right,
                          style: new TextStyle(fontSize: 10),
                        ),
                      ),
                      new Container(
                        height: 25,
                        padding: EdgeInsets.only(right: 10),
                        alignment: AlignmentDirectional.centerEnd,
                        child: new Text("5.5",
                          textAlign: TextAlign.right,
                          style: new TextStyle(fontSize: 20),
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
          )
        ],
      ),
    );
  }
}


