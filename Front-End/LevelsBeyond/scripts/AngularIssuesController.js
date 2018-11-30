angular
	.module('LevelsBeyond')
	.controller('AngularIssuesController', function($scope, AngularIssues)
	{

		AngularIssues.getIssues().then(function(response)
		{
			$scope.issues = response.data;
		}).catch(function(error)
		{
			console.log(error);
		});

	});