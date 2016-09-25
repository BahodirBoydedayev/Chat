app.service('userService', function ($http) {

    var _this = this;

    _this.currentUser = function () {
        return $http.get('api/users/currentUser');
    };

    _this.contacts = function (id) {
        return $http.get('api/users/')
    }
});
