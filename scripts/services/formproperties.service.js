coluApp.service('formProperties', function() {

    var editorEnabled = [false, false, false, false, false, false];
   
      this.enableEditor = function(id) {
          editorEnabled[id] = true;
          //console.log('hej')
      }

      this.disableEditor = function(id) {              
          editorEnabled[id] = false;
          return editorEnabled[id];
      }

      this.returnEditor = function(id){
        return editorEnabled[id];
      }
    
});