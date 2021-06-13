var signup = {
	init : function() {
		var _this = this;
		
		$('#btnSignUp').off('click').on('click', function() {
            _this.save();
        });
		
		$('#btnCancel').off('click').on('click', function() {
            _this.cancel();
        });
	},
	
	save : function() {
		var param = {
	            email: $('#email').val(),
	            name : $('#name').val(),
	            pwd : $('#pwd').val()
	    };
		
		actionFetch('/auth/signup', 'POST', param, function(data) {
			if(data.result == 'dup') {
				//이메일 중복처
				
				return;
			}
			else if(data.result == 'errs') {
				//에러 처리
				return;
			}
			
			href.location = '/auth/signin';
		});
	},
	
	cancel : function() {
		href.location = '/';
	}
};

signup.init();