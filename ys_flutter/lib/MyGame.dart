import 'package:flutter/material.dart';

class MyGamePage extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return new MyGameState();
  }
}

class MyGameState extends State<MyGamePage>{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return new Column(
      children: <Widget>[
        Text("MyGame!!!")
      ],
    );
  }
}