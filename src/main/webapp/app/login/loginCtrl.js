app.controller('loginCtrl', function ($http, $scope, $location, $state) {

    window.localStorage.removeItem("token");

    $scope.auth = function (user) {
        var token = btoa(user.username + ':' + user.password);
        $http({
            url: '/login',
            method: 'GET',
            headers: {
                'Authorization': 'Basic ' + token
            }
        }).success(function () {
            $http.defaults.headers.common.Authorization = 'Basic ' + token;
            window.localStorage.setItem("token", token);
            $state.go('app');
        }).error(function (error) {
        })
    };
});