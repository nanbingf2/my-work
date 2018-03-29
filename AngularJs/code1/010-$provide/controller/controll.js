/**
 * Created by 1 on 2018/2/14.
 */
angular.module("myApp",[],function($provide){
    //通过provider方法自定义服务
    // customService:服务名
    $provide.provider("customService",function(){
        this.$get=function(){
            return {
                message:"customService Message"
            };
        }
    });

    //通过factory自定义工厂
    //自定义工厂可以返回任意值
    $provide.factory("factoryService",function(){
        return [1,2,3,4,5,6];
    })


    //通过service自定义服务,自定义服务只能返回对象
    $provide.service("service",function(){
        return data={
            name:'zhangsan',
            age:18
        };
    })
})
.controller("myController",function($scope,customService,factoryService,service){
    $scope.name="zhangsan";
    console.log(customService.message);
    console.log(factoryService);
    console.log(service)
})