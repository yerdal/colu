coluApp.service('formProperties', function() {

    var editorEnabled = [false, false, false, false, false, false];

      editorEnabled.enableEditor = function(id) {
        $scope.editorEnabled[id] = true;
      };


      editorEnabled.disableEditor = function(id) {
              
        $scope.editorEnabled[id] = false;
      };
  
      editorEnabled.saveIndex = function(id, index) {
        $scope.disableEditor(id);
        //("save", id);
        //console.log("sadsad", index);
        checkTimeStatus(index);

      };

      editorEnabled.save = function(id) {
        $scope.disableEditor(id);
        $scope.putData();
      };

      function isInArray(value, array) {
        return array.indexOf(value) > -1;
      }
    
});