/**
 * Created by 1 on 2018/2/14.
 */
angular.module("myApp",[])
    .service("student",function(){
        return [{
            id:0001,
            name:'zhangsan',
            age:18
        },{
            id:0002,
            name:'lisi',
            age:19
        },{
            id:0003,
            name:'wangwu',
            age:17
        },{
            id:0004,
            name:'tom',
            age:20
        }];
    })

.controller("myController",function($scope,student){
    $scope.fullName="Tom-Roger";
    $scope.price=9.99;
    $scope.quantity=1;
    $scope.date=new Date();
    $scope.student=student;
    $scope.text=1234;
})    //自定义反转控制器
    .filter("reverse",function(){
        return function(str){
            return str.split("").reverse().join("");
        }
    });