var myApp = angular.module('myApp', ['ngMaterial']);
myApp.config(function ($mdThemingProvider) {
    $mdThemingProvider.theme('green', 'default')
        .primaryPalette('green')
});
