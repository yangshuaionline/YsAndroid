import 'package:flutter/material.dart';

class FirstPage extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return new FirstState();
  }
}

class FirstState extends State<FirstPage>{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return new Column(
      children: <Widget>[
        new Text("First!!!"),
      ],
    );
  }

}