var myApp = angular.module('myApp', ['ngMaterial','ngMessages','validation.match','material.svgAssetsCache']);
myApp.config(function ($mdThemingProvider) {
    $mdThemingProvider.theme('green', 'default')
        .primaryPalette('green');
    $mdThemingProvider.theme('docs-dark', 'default')
        .primaryPalette('green');
    $mdThemingProvider.theme('dark-yel', 'default')
        .primaryPalette('yellow')
        .dark();
});
myApp.controller('AppCtrl', function ($scope, $mdDialog, $mdMedia, $mdToast) {
    // Hide & show password function
    $scope.customFullscreen = true;
    var last = {
        bottom: false,
        top: true,
        left: false,
        right: true
    };

    $scope.toastPosition = angular.extend({}, last);
    $scope.getToastPosition = function () {
        sanitizePosition();
        return Object.keys($scope.toastPosition)
            .filter(function (pos) {
                return $scope.toastPosition[pos];
            })
            .join(' ');
    };
    function sanitizePosition() {
        var current = $scope.toastPosition;
        last = angular.extend({}, current);
    }

    $scope.showlogin = function () {
        var pinTo = $scope.getToastPosition();
        $mdToast.show(
            $mdToast.simple()
                .position('bottom right')
                .textContent('You already logined!')
                .hideDelay(3000)
        );
    };
    $scope.sendemail = function () {
        $mdToast.show(
            $mdToast.simple()
                .position('bottom right')
                .textContent('Message with instruction will send on your email.')
                .hideDelay(3000)
        );
    };

    $scope.registration = function () {
        $mdToast.show(
            $mdToast.simple()
                .position('bottom right')
                .textContent('You already registered!')
                .hideDelay(3000)
        );
    };

    myApp.controller('ToastCtrl', function ($scope, $mdToast) {
        $scope.closeToast = function () {
            $mdToast.hide();
        };
    });


    $scope.hideShowPassword = function () {
        if ($scope.inputType == 'password')
            $scope.inputType = 'text';
        else
            $scope.inputType = 'password';
    };
    $scope.forgetpassword = function (ev) {
        var useFullScreen = ($mdMedia('sm') || $mdMedia('xs')) && $scope.customFullscreen;
        $mdDialog.show({
            controller: DialogController,
            templateUrl: 'forgetpassword.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose: true,
            fullscreen: $scope.customFullscreen,
            openFrom: ({top: -50}),
            closeTo: ({
                left: 0
            })
        });
    };
    $scope.SingUp = function (ev) {
        var useFullScreen = ($mdMedia('sm') || $mdMedia('xs')) && $scope.customFullscreen;
        $mdDialog.show({
            controller: DialogController,
            templateUrl: 'SingUp.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose: true,
            openFrom: ({top: -50}),
            fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.

        });
    };
    function DialogController($scope, $mdDialog) {
        $scope.hide = function () {
            $mdDialog.hide();
        };

        $scope.cancel = function () {
            $mdDialog.cancel();
        };

        $scope.answer = function (answer) {
            $mdDialog.hide(answer);
        };
    }
});

