/**
 * Created by pulem3t on 06.03.16.
 */
'use strict';

var crmApp = angular.module('crmApp', [
    'ngRoute',
    'crmControllers',
    'crmServices'
]);

crmApp.config(['$routeProvider', '$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider.
        when('/',{
            templateUrl:'partials/main.html',
            controller:'StartViewCtrl'
        }).when('/products', {
            templateUrl: 'partials/main.html',
            controller: 'ProductViewCtrl'
        }).when('/orders', {
            templateUrl: 'partials/main.html',
            controller: 'OrdersViewCtrl'
        }).when('/customers', {
            templateUrl: 'partials/main.html',
            controller: 'CustomersViewCtrl'
        }).when('/vendors', {
            templateUrl: 'partials/main.html',
            controller: 'VendorsViewCtrl'
        });

        $locationProvider.html5Mode(false).hashPrefix('!');
    }
]);