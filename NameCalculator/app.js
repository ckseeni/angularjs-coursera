(function(){
'use strict';
angular.module('NameCalculator',[])
.controller('NameCalculatorController',function($scope){
  $scope.name="";
  $scope.totalValue=0;
  $scope.displayNumeric = function(){
    var totalNameValue = calculator($scope.name);
    $scope.totalValue = totalNameValue;
  };
  function calculator(string){
    var total = 0;
    for(var i=0;i<string.length;i++){
      total+=string.charCodeAt(i);
    }
    return total;
  }
});
})();
