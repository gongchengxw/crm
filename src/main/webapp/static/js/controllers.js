/**
 * Created by pulem3t on 06.03.16.
 */
'use strict';

var crmControllers = angular.module('crmControllers', []);

crmControllers.controller('StartViewCtrl', ['$scope',
    function StartViewCtrl($scope) {
        $scope.mainViewName = "partials/start.html";
    }
]);
crmControllers.controller('ProductViewCtrl', ['$scope',
    function ProductViewCtrl($scope) {
        $scope.mainViewName = "partials/products.html";
    }
]);
crmControllers.controller('OrdersViewCtrl', ['$scope',
    function OrdersViewCtrl($scope) {
        $scope.mainViewName = "partials/orders.html";
    }
]);
crmControllers.controller('ClientsViewCtrl', ['$scope',
    function ClientsViewCtrl($scope) {
        $scope.mainViewName = "partials/clients.html";
    }
]);
crmControllers.controller('VendorsViewCtrl', ['$scope',
    function VendorsViewCtrl($scope) {
        $scope.mainViewName = "partials/vendors.html";
    }
]);