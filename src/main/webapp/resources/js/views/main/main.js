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
	$scope.showResults = false;
	$scope.showSearch = true;
	$scope.searching = false;
	$scope.searchContainerModel = {isBigContainer :  true};
	$scope.results = [];
	
	$scope.search = function(){	
		$scope.searching = true;
		var requestObj = [$scope.searchTermService,$scope.searchTermLocation];
		console.log(requestObj);
		$http.post($scope.searchUrl,requestObj).success(function(data){
			console.log(data);	
			$scope.results = data.suppliers;
			$scope.searchContainerModel.isBigContainer = false;			
			$scope.showResults = true;
			$scope.searching = false;
			$scope.showSearch = false;
		})
	}
	
}]);