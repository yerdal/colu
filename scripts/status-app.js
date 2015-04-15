angular.module('coluApp', [])
  .controller('statusController', ['$scope', function($scope) {
    $scope.time = {lowerLimit: '-30',
                   upperLimit: '30'};

    $scope.fuel = {upperLimit: '250'};


    $scope.editorEnabled = [false, false];
    
    $scope.enableEditor = function(id) {
      $scope.editorEnabled[id] = true;
    };
    
    $scope.disableEditor = function(id) {
      $scope.editorEnabled[id] = false;
    };
    
    $scope.save = function(id) {
      $scope.disableEditor(id);
    };
}]);