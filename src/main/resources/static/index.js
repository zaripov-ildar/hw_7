angular.module('studentApp', []).controller('studentController', function ($scope, $http) {


    $scope.loadStudents = function () {
        $http({
            method: 'GET',
            url: 'http://localhost:8100/front/api/v1'
        }).then(function (response) {
            console.log("laefefe")
            console.log(response);
            $scope.students = response.data;
            $scope.student = {
                id: null,
                name: null,
                age: null
            }
        });
    };

    $scope.delete = function (id) {
        $http({
            method: 'DELETE',
            url: 'http://localhost:8100/front/api/v1/' + id
        }).then(function () {
            $scope.loadStudents();
        });
    };

    $scope.update = function (s) {
        $http.post('http://localhost:8100/front/api/v1', s)
            .then(function () {
                $scope.loadStudents();
            });
    }

    $scope.create = function () {
        if ($scope.student.name && $scope.student.age) {
            $http.post('http://localhost:8100/front/api/v1', $scope.student)
                .then(function () {
                    $scope.loadStudents();
                });
        } else alert("name or age can' be null!")
    }


    $scope.loadStudents();
})