/**
 * Created by 1 on 2018/2/14.
 */
angular.module("productApp",[])
.service("productService",function(){
    return [{
        id:"0001",
        name:"oppo手机",
        price:1500
    },{
        id:"0002",
        name:"华为手机",
        price:2500
    },{
        id:"0003",
        name:"iphone8",
        price:7999
    },{
        id:"0004",
        name:"笔记本电脑",
        price:6500
    },{
        id:"0005",
        name:"摄像机",
        price:800
    }];
})
.controller("productController",function($scope,productService){
    $scope.products=productService;
})