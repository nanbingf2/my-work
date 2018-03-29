angular.module("noteApp",[])
.controller("noteController",function($scope){
    $scope.note="";
    $scope.save=function(){
        alert("保存成功");
    };

    $scope.clean=function(){
        $scope.note="";
    };

    $scope.leaf=function(){
        return 100-$scope.note.length;
    };
})