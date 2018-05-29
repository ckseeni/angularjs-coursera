(function(){
angular.module('LunchCheck',[])
.controller('LunchCheckController',LunchCheckController);

LunchCheckController.$inject = ['$scope'];
function LunchCheckController($scope) {
  $scope.col="";
  $scope.items="";
  $scope.result="";
  $scope.CheckIfTooMuch = function(){
    var arr = $scope.items.split(',');

    if(arr.length==1&&arr[0]==""){
      $scope.result = "Please enter data first";
    }
    else if(arr.length<=3){
      $scope.result = "Enjoy!";
    }
    else{
      $scope.result = "Too much!";
    }
  }
}

})();
