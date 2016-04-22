/**
 * Created by pulem3t on 06.03.16.
 */
'use strict';

var crmServices = angular.module('crmServices', ['ngResource']);

crmServices.factory('VendorsList',['$resource',
    function($resource) {
        return $resource("vendors/getVendors", {}, {
            get: {method:'GET', cache:false, isArray: true}
        });
    }
]);

crmServices.factory('ProductsList',['$resource',
    function($resource) {
        return $resource("products/getProducts", {}, {
            get: {method:'GET', cache:false, isArray: true}
        });
    }
]);

crmServices.factory('CustomersList',['$resource',
    function($resource) {
        return $resource("customers/getCustomers", {}, {
            get: {method:'GET', cache:false, isArray: true}
        });
    }
]);

crmServices.factory('AddCustomer',['$resource',
    function($resource) {
        return $resource("customers/addCustomer", {}, {
            add: {method:'POST', responseType:'json', cache:false, isArray: false}
        });
    }
]);

crmServices.factory('OrdersList',['$resource',
    function($resource) {
        return $resource("orders/getOrders", {}, {
            get: {method:'GET', cache:false, isArray: true}
        });
    }
]);