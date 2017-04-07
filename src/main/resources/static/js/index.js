var myApp = angular.module('myApp', ['ngMaterial','ngMessages']);
myApp.config(function ($mdThemingProvider) {
    $mdThemingProvider.theme('green', 'default')
        .primaryPalette('green')
});
