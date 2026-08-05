/**
 * Recipes Controller.
 *
 */
recipesApp.controller('recipeController', ['$scope', '$routeParams', 'recipesService',
    function ($scope, $routeParams, recipesService) {
        $scope.recipeId = $routeParams.recipeId;
        $scope.recipeName = $routeParams.recipeName;
    }]);
