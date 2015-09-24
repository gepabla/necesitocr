'use strict';

// Declare app level module which depends on views, and components
angular.module('necesitocr', [
  'ngRoute',
  'necesitocr.mainView',
  'necesitocr.directives'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/main'});
}]);

