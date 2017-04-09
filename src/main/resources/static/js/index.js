var myApp = angular.module('myApp', ['ngMaterial']);
myApp.config(function ($mdThemingProvider) {
    $mdThemingProvider.theme('green', 'default')
        .primaryPalette('green')
});

// myApp.controller('Request', function($scope,$http)
// {
//     $scope.cloc = function () {
//         $http({
//             method: 'GET',
//             url: '/products'
//         }).then(function successCallback(response) {
//             console.log("success")
//             $scope.response = response;
//             // this callback will be called asynchronously
//             // when the response is available
//         }, function errorCallback(response) {
//             // called asynchronously if an error occurs
//             // or server returns response with an error status.
//         });
//     };
// });