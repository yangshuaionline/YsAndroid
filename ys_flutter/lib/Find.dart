import 'package:flutter/material.dart';


class FindPage extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return new FindState();
  }
}

class FindState extends State<FindPage>{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return new ListView.builder(
      itemCount: 10,
      itemBuilder: (BuildContext context,int index){
        return new Container(
          height: 50,
          child: new Center(
            child: new Text("Find${index+1}"),
          ),
        );
      },
    );
  }
}