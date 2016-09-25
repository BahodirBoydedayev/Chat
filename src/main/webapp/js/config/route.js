app.config(function ($stateProvider, $urlRouterProvider) {

    $stateProvider
        .state('app', {
            templateUrl: '../../app/main/app.html',
            controller: 'appCtrl',
            url: '/main',
            //resolve: {
            //    currentUser: function (userService) {
            //        return userService.currentUser();
            //    }
            //}
        })
        .state('login', {
            url: '/login',
            templateUrl: '../../app/login/login.html',
            controller: 'loginCtrl'
        })
        .state('app.error404', {
            url: '/error404',
            templateUrl: '../../app/error/error404.html'
        });
    $urlRouterProvider.otherwise(function ($scope, $location, $state) {
        var token = window.localStorage.getItem('token');
        if (token) {
            $location.path('/main');
        }
        else {
            $location.path('/error404');
        }
    })
});