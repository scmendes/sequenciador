// Angular model
var users = angular.module('tasks', []);
 
function mainController($scope, $http) {    
 
	var refresh = function (){
        $http.get('/api/tasklists')
            .success(function(data) {
                $scope.tasks = data._embedded.tasklists;
                $scope.taskForm = {};
                console.log("tasks: ", data);
            })
            .error(function(data) {
                console.log('Error: ' + data);
            });
    };
    refresh();
    $scope.CurrentDate = new Date();
    

    $scope.create = function() {
        $http.post('/api/tasklists', $scope.taskForm)
            .success(function(data) {
                refresh();
            })
            .error(function(data) {
                console.log('Error: ' + data);
            });
    };
 
    $scope.edit = function(id) {
        $http.get('/api/tasklists/' + id)
            .success(function(data) {
                $scope.taskForm = data;
                console.log(data);
            })
            .error(function(data) {
                console.log('Error: ' + data);
            });
    };

    $scope.update = function() {        
        $http.put('/api/tasklists/' + $scope.taskForm.key, $scope.taskForm)
        .success( function(response){
            refresh();
        });
    };
    
    $scope.remove = function(id) {        
        $http.delete('/api/tasklists/' + id, $scope.taskForm)
        .success( function(response){
            refresh();
        });
    };
}