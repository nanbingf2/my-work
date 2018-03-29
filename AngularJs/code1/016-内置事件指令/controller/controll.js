angular.module("myApp",[])
.controller("myController",function($scope){
    $scope.status='false';
    $scope.changeStatus=function(){
        $scope.status=!$scope.status;
    }
})