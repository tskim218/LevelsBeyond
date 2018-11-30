angular
	.module('LevelsBeyond')
	.controller('AngularIssuesController', function($scope, AngularIssues)
	{

		$scope.issues = [];

		var i = 1;
		while (i < 5)
		{
			var iStr = i.toString();

			AngularIssues.getIssues(iStr).then(function(response)
			{
    			$scope.issues = $scope.issues.concat(response.data);

			}).catch(function(error)
			{
				console.log(error);
			});

			i++;

		}

	});