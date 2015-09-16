'use strict';

// Declare app level module which depends on views, and components
angular.module('necesitocr', [
  'ngRoute',
  'necesitocr.mainView'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/main'});
}]);

