angular.module('necesitocr.directives', [])
.directive('searchContainer', function($rootScope) {
    return {
        restrict: 'A',
        scope : {
        	searchContainerModel : "=searchContainer"
        },
        link: function(scope, element, attrs) {  
        	scope.$watch("searchContainerModel",function(){
        		if(!scope.searchContainerModel.isBigContainer){
        			var windowHeight = $(window).height();            
                    var elem = $(element);
                    elem.animate({height : 300});
                    var eva = elem.find(".eva-container img.searching");
                    eva.animate({height : 200,width : 200});
        		}else{
        			var windowHeight = $(window).height();            
                    var elem = $(element);
                    elem.animate({height : windowHeight});
                    var eva = elem.find(".eva-container img.searching");
                    eva.animate({height : 400,width : 400});
        		}
        	},true);
            var windowHeight = $(window).height();            
            var elem = $(element);
            elem.height(windowHeight);
        }
    };
})