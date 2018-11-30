angular
	.module('LevelsBeyond')
	.factory('AngularIssues', function($http)
	{
		
		function getIssues()
		{
			return $http.get('https://api.github.com/repos/angular/angular/issues');
		}
		return {
			getIssues: getIssues
		}

	});


