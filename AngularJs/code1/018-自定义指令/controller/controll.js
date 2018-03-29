angular.module("myApp",[])
//自定义指令
    .directive("myTag",function(){
        return {
            restrict:'ECAM',
            replace:'true',
            template:'<div>myTag</div>'//该内容用来替换节点元素的内容
        }
})
    .directive("myTag2",function(){
        return {
            restrict:'ECAM',
            replace:'true',
            //用来加载其他模板中的内容来替换节点内容,且被加载的模板中可以使用控制器中定义的属性
            // templateUrl:'../template/other.html'

            //使用templateUrl来加载type为text/ng-template的script标签中的内容来替换节点元素的内容
            //属性值为script标签的id值
            templateUrl:'template'
        }
    })
.controller("myController",function($scope){
    $scope.name='other';
})