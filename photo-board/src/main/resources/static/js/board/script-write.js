var write = {
	init : function() {
		var _this = this;
		$('#btnWrite').off('click').on('click', function() {
            _this.save();
        });
		
		$('#btnCancel').off('click').on('click', function() {
            _this.cancel();
        });
	},
	
	save : function() {
		var param = {
	            subject: $('#subject').val(),
	            writer : 'admin',
	            title : $('#title').val(),
	            platform : $('#platform').val(),
	            content : $('#content').val()
	    };

		var _subject = ($('#subject').val()).replace(/ /g, '-');
		
		console.log("_subejct : " + _subject);
		
		actionFetch('/board/photo/' + _subject, 'POST', param, function(data) {
			console.log(data);
		});
	},
	
	cancel : function() {
		location.href = "/";
	}
};

write.init();