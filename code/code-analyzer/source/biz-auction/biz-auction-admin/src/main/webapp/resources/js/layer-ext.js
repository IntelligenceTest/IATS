function msg_warn(msg){
	layer.msg(msg,{icon:0,shift:6});
}
function msg_error(msg){
	layer.msg(msg,{icon:5,shift:6});
}
function msg_success(msg,callback){
	layer.msg(msg,{icon:1,shift:1,time:1200},callback);
}
