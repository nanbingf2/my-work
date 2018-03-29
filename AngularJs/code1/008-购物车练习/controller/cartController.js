/**
 * Created by 1 on 2018/2/14.
 */
angular.module("cartApp",[]).controller("cartController",function($scope){
    $scope.cart=[{
        id:"0001",
        name:"oppo手机",
        quantity:5,
        price:1500
    },{
        id:"0002",
        name:"华为手机",
        quantity:4,
        price:2500
    },{
        id:"0003",
        name:"iphone8",
        quantity:6,
        price:7999
    },{
        id:"0004",
        name:"笔记本电脑",
        quantity:2,
        price:6500
    },{
        id:"0005",
        name:"摄像机",
        quantity:10,
        price:800
    }];

    /*
    求购买总价
     */
    $scope.totalPrice = function(){
        var total = 0;
        //遍历集合,将第一个参数代表的集合遍历出的元素作为第二个函数的值
        angular.forEach($scope.cart,function(item){
            total+=item.price*item.quantity;
        });
        return total;
    }

    /**
     * 求总购买数量
     */
    $scope.totalQuantity = function(){
        var total = 0;
        angular.forEach($scope.cart,function(item){
            total+=parseInt(item.quantity);
        });
        return total;
    }

    /**
     * 根据id找出元素坐标
     */
    var findIndex = function(id){
        var index=-1;
        //遍历数组,函数中的两个参数分别表示遍历出的元素别名和该元素在数组中的位置（从0开始）
        angular.forEach($scope.cart,function(item,key){
            if(id==item.id){
                index=key;
                return;
            }
        });
        return index;
    };


    /**
     * 移除商品方法
     */
    $scope.remove=function(id){
        var index=findIndex(id);
        if(index!=-1){
            //移除该元素
            $scope.cart.splice(index,1);
        }
    };

    /**
     * 购买数量减一
     */
    $scope.replace=function(id){
        var index = findIndex(id);
        var item = $scope.cart[index];
        if(item.quantity<=1){
            var message=confirm("是否移除该产品");
            if(message){
                //确认删除
                $scope.remove(id);
            }
        }else{
            --item.quantity;
        }
    };

    /**
     * 购买数量加一
     */
    $scope.add=function(id){
        var index = findIndex(id);
        $scope.cart[index].quantity++;
    };

    /**
     *对文本输入框的监视
     */
    //newValue,oldValue表示一个cart对象
    $scope.$watch("cart",function(newValue,oldValue){
        angular.forEach(newValue,function(item,key){
            if(item.quantity<1){
                var message = confirm("是否移除该产品");
                if(message){
                    //确认移除
                    $scope.remove(item.id);
                }else{
                    item.quantity=oldValue[key].quantity;
                }
                return;
            }
        })

    },true);


    //自动脏检查
});