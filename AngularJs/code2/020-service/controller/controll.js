angular.module("myApp",[])

.controller("myController",function($scope,$location,$timeout,$interval){
    //$location服务:用来返回当前页面的URL地址
    $scope.myUrl=$location.absUrl();

    //$timeout服务:用来执行简单的定时任务
    $scope.data="hello1"
    $timeout(function(){
        $scope.data="hello2";
    },3000);

    //$interva:提供类似于$timeout的延时服务
    $scope.num=0;
    $interval(function(){
        $scope.num=$scope.num+1;
    },1000);
})
    //自定义服务
.service("myService",function(){
    this.sayHello=function(name){
        return "hello:"+name;
    }
})
.controller("myController2",function($scope,myService){
    $scope.name="zhangsan";
    $scope.greet=function(){
        $scope.greetInfo=myService.sayHello($scope.name);
    }
})
.service("myService2",function(){
    //自定义服务2:将字符串反转
    this.myReverse=function(str){
        return str.split(",");
    }
})
    //自定义过滤器,在过滤器中使用自定义服务
.filter("reverse",function(myService2){
    return function(str){
        return myService2.myReverse(str);
    }
})