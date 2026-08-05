recipesApp.config(['$routeProvider',
    function($routeProvider) {
      $routeProvider
        .when('/', {
          controller:'recipeListController',
          templateUrl:'resources/html/recipe-list.html',
        })
        .when('/recipe/:recipeId/:recipeName', {
          controller:'recipeController',
          templateUrl:'resources/html/recipe.html',
        })
        .otherwise({
          redirectTo:'/'
        });
    }]);
