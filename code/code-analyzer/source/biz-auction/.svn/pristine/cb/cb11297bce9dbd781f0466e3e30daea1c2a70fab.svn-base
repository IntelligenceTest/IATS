
/**
 * 表单验证框架
 * 增加了中文提示
 * 增加了电话号码，手机号，邮政编码验证支持
 * @author weiyi.wang
 * @date 2015-3-2 15:37
 */

jQuery.extend(jQuery.validator.messages, {
    required: "必填字段",
	remote: "请修正该字段",
	email: "请输入正确的电子邮件格式",
	url: "请输入合法的网址",
	date: "请输入合法的日期",
	dateISO: "请输入合法的日期 (ISO).",
	number: "请输入合法的数字",
	digits: "只能输入整数",
	creditcard: "请输入合法的信用卡号",
	equalTo: "请再次输入相同的值",
	accept: "请输入拥有合法后缀名的字符串",
	maxlength: jQuery.validator.format("请输入一个 长度最多是 {0} 的字符串"),
	minlength: jQuery.validator.format("请输入一个 长度最少是 {0} 的字符串"),
	rangelength: jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),
	range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
	max: jQuery.validator.format("请输入一个最大为{0} 的值"),
	min: jQuery.validator.format("请输入一个最小为{0} 的值")
});

jQuery.validator.addMethod("zipCode", function(value, element) {   
    var zipCode = /^[0-9]{6}$/;
    return this.optional(element) || (zipCode.test(value));
}, "请正确填写邮政编码");

jQuery.validator.addMethod("cellphone", function(value, element) {  
	var cellphone = /^1[3|4|5|8][0-9]\d{4,8}$/;
	return this.optional(element) || (cellphone.test(value));
}, "请正确填写手机号码");

jQuery.validator.addMethod("tellphone", function(value, element) {  
	var tellphone = /^(([1-9]\d{6,7})|(0[1-9](\d{1,2}))-([1-9]\d{6,7})|(0[1-9](\d{1,2}))-([1-9]\d{6,7})-(\d{4}|\d{3}|\d{2}|\d{1})|([1-9]\d{6,7})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
	return this.optional(element) || (tellphone.test(value));
}, "请正确填写电话号码");