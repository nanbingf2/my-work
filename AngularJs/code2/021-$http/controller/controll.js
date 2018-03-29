angular.module("myApp",[])
.controller("myController",function($scope,$http){
    $http.get()
        .then(function success(response){
            $scope.repData=response.data;
            console.log(repData);
        },function fail(reponse){

        })
})