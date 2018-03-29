/**
 * Created by 1 on 2018/2/14.
 */
angular.module("myApp",[])
.service("Data",function(){
    return [1,2,3,4,5,6];
})
    /*隐式依赖注入*/
.controller("firstController",function($scope,Data){
    $scope.data=Data;
    console.log(Data);
})
/*显式依赖注入*/
.controller("secondController",['$scope','$filter',function(a,b){
    console.log(a);
    console.log(b('json')([1,2,3,4,5,6]));
}]);