/**
 * Created by 1 on 2018/2/14.
 */
angular.module("myApp",[])
.controller("myController",function($scope){
    $scope.firstName="Tom";
    $scope.lastName="Roger";
    $scope.fullName=function(){
        return $scope.firstName+"-"+$scope.lastName;
    }
})