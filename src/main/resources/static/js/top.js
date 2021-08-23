var app = app || {
	dispDate : function() {
		var html = "";

		// 一桁の数字を0埋め
	    var fm = function(num) {
	        num += "";
	        if (num.length == 1) {
	            num = "0" + num;
	        }
	        return num;
	    };

		var date = new Date();

		var seconds = fm(date.getSeconds());
		var minutes = fm(date.getMinutes());
		var hours = fm(date.getHours());

		var year = fm(date.getFullYear());
		var month = fm(date.getMonth() + 1) ;

		var day = fm(date.getDate());

		html = year + "/" + month + "/" + day + "::" + hours + ":" + minutes + ":" + seconds;
		document.getElementById("id-result").innerHTML = html;

		setInterval("app.dispDate()",1000);
	}
};

window.onload = function() {
	app.dispDate();
};
