$(function(){
	var flag = false;
	$.each($("#advbox input,#advbox select"), function(index, item) {
		if ($(item).val() != "" && $(item).val() != "99") {
		    flag = true;
		    return;
		};
	});

	if (flag) {
	    $("#advbox").toggle(0);
	    $(this).toggleClass("slink-2");
	};

	$("#slink").click(function() {
	      $("#advbox").toggle(0);
	      $(this).toggleClass("slink-2");
	});

});