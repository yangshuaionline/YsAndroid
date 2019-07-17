import 'package:flutter/material.dart';
final int game = 0;
class FirstListWidget extends StatefulWidget{
  int type = 0;
  FirstListWidget(int type){
    this.type = type;
  }
  @override
  State<StatefulWidget> createState() {
    return new FirstListState(type);
  }
}

class FirstListState extends State<FirstListWidget>{
  int type = 0;
  FirstListState(int type){
    this.type = type;
  }
  @override
  Widget build(BuildContext context) {
    return null;
  }
}