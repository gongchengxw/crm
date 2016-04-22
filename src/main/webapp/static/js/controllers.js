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
crmControllers.controller('ProductViewCtrl', ['$scope', 'ProductsList', 'AddProduct',
    function ProductViewCtrl($scope, ProductsList, AddProduct) {
        $scope.mainViewName = "partials/products.html";
        $scope.addProduct = function(nameAdd) {
            AddProduct.add({name: nameAdd},
                function success(response){
                    getProducts();
                }
            );
        };
        var getProducts = function() {ProductsList.get({},
                function success(response) {
                    $scope.productsList = response[0];
                },
                function error(errorResponse) {
                    console.log("Error:" + JSON.stringify(errorResponse));
                }
            );
        };
        getProducts();
    }
]);
crmControllers.controller('OrdersViewCtrl', ['$scope', 'OrdersList', 'AddOrder',
    function OrdersViewCtrl($scope, OrdersList, AddOrder) {
        $scope.mainViewName = "partials/orders.html";
        $scope.addOrder = function(customerIdAdd, managerIdAdd, amountAdd, deliveryAddressAdd) {
            AddOrder.add({customerId: customerIdAdd, managerId: managerIdAdd, amount: amountAdd, deliveryAddress: deliveryAddressAdd},
                function success(response){
                    getOrders();
                }
            );
        };
        var getOrders = function() {OrdersList.get({},
                function success(response) {
                    $scope.ordersList = response[0];
                },
                function error(errorResponse) {
                    console.log("Error:" + JSON.stringify(errorResponse));
                }
            );
        };
        getOrders();
    }
]);
crmControllers.controller('CustomersViewCtrl', ['$scope', 'CustomersList', 'AddCustomer',
    function CustomersViewCtrl($scope, CustomersList, AddCustomer) {
        $scope.mainViewName = "partials/customers.html";
        $scope.addCustomer = function(firstNameAdd, lastNameAdd, addressAdd) {
            AddCustomer.add({firstName: firstNameAdd, lastName: lastNameAdd, address: addressAdd},
                function success(response){
                    getCustomers();
                }
            );
        };
        var getCustomers = function() {CustomersList.get({},
                function success(response) {
                    $scope.customersList = response[0];
                },
                function error(errorResponse) {
                    console.log("Error:" + JSON.stringify(errorResponse));
                }
            );
        };
        getCustomers();
    }
]);
crmControllers.controller('VendorsViewCtrl', ['$scope', 'VendorsList', 'AddVendor',
    function VendorsViewCtrl($scope, VendorsList, AddVendor) {
        $scope.mainViewName = "partials/vendors.html";
        $scope.addVendor = function(firstNameAdd, lastNameAdd) {
            AddVendor.add({firstName: firstNameAdd, lastName: lastNameAdd},
                function success(response){
                    getVendors();
                }
            );
        };
        var getVendors = function() {VendorsList.get({},
                function success(response) {
                    $scope.vendorsList = response[0];
                },
                function error(errorResponse) {
                    console.log("Error:" + JSON.stringify(errorResponse));
                }
            );
        };
        getVendors();
    }
]);