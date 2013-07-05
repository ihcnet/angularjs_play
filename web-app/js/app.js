'use strict';

/* App Module */

angular.module('phonecat', ['phonecatFilters', 'phonecatServices']).
    config(['$routeProvider', function($routeProvider) {
        $routeProvider.
            when('/phone', {templateUrl: 'ng-templates/phone/list.html',   controller: PhoneListCtrl}).
            when('/phone/:phoneId', {templateUrl: 'ng-templates/phone/show.html', controller: PhoneDetailCtrl}).
            otherwise({redirectTo: '/phone'});
    }]);