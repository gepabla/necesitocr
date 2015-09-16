'use strict';

angular.module('necesitocr.mainView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/main', {
    templateUrl: 'resources/js/views/main/main.html',
    controller: 'MainCtrl'
  });
}])

.controller('MainCtrl', ['$scope','$http',function($scope,$http) {
	$scope.searchTermService = "";
	$scope.searchTermLocation = "";
	$scope.searchUrl = "api/supplier/getByTags";
	$scope.search = function(){	
		var requestObj = [$scope.searchTermService,$scope.searchTermLocation]
		console.log(requestObj);
		$http.post($scope.searchUrl,requestObj).success(function(data){
			console.log(data);
		})
	}
	
}]);