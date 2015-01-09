snackbar.factory('modalService', function($modal) {
	var instance = {
			modal: {}
	};
	
	instance.openModal = function(size, modalType, scope){
			instance.modal.modalInstance = $modal.open({
                    templateUrl: 'views/partials/modal-' + modalType + '.html',
                    size: size,
                    scope: scope,
                    backdrop: 'static'
			    });
	};
	
	instance.dismissModal = function() {
		instance.modal.modalInstance.close();
		instance.modal = {};
	};

	return instance;
});
