/**
 * Created by 1 on 2018/2/14.
 */
angular.module("myApp",[],function($provide,$controllerProvider,$filterProvider){
    //自定义服务
    $provide.service("Data",function(){
       return [{
           id:1001,
           name:'zhangsan',
           age:18
       },{
           id:1002,
           name:'lisi',
           age:25
       },{
           id:1003,
           name:'tom',
           age:20
       }] ;
    });

    //自定义过滤器
    $filterProvider.register('filterAge',function(){
        return function(students){
            var newStu = [];
            angular.forEach(students,function(stu){
               if(stu.age>15){
                 newStu.push(stu);
               };
            });
            return newStu;
        }
    });

    //控制器
    $controllerProvider.register("firstController",function($scope,Data){
       $scope.students=Data;
    });
})
.filter("filterName",function(){
    return function(students){
        var newObj = [];
        angular.forEach(students,function(stu){
            if(stu.name=="zhangsan"){
                newObj.push(stu);
            }
        });
        return newObj;
    };
});