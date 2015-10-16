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
	$scope.mood = "happy";
	
	$scope.searchTags = function(val,isGeo) {		
	    return $http.get('api/tag/searchByName', {
	      params: {
	    	  tagName: val,
	    	  isGeo : isGeo
	      }
	    }).then(function(response){	    	
	      return response.data.tags.map(function(item){
	        return item.name;
	      });
	    });
	  };
	
	$scope.search = function(){	
		$scope.searching = true;
		var requestObj = ($scope.searchTermLocation === "") ? $scope.searchTermService : $scope.searchTermService + " " +$scope.searchTermLocation.replace(/\s/g,"+");
		console.log(requestObj);
		$http.post($scope.searchUrl,requestObj).success(function(data){		
			$scope.results = data.suppliers;
			
			if($scope.results.length <= 0){
				$scope.mood = "sad";
			}
			
			$scope.searchContainerModel.isBigContainer = false;			
			$scope.showResults = true;
			$scope.searching = false;
			$scope.showSearch = false;
		})
	}
	
}]);