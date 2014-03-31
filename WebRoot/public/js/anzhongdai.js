/*!
 * anzhongdai v2.0.1
 * Copyright 2014 anzhongdai.com, Inc.
 */
;
if(typeof jQuery === 'undefined') {
	throw new Error('AZD requires jQuery')
}

/**
 * 安众贷工具类
 */
var AZD = {};

// 空函数
AZD.noop = function() {
};

// 是否存在DOM
AZD.existDOM = function(domId) {
	return($("#" + domId).length > 0);
};

// 设置CSS类
AZD.addClass = function(domId, clazz) {
	if(AZD.existDOM(domId)) {
		$("#" + domId).addClass(clazz);
	}
};

// 设置CSS类
AZD.setClass = function(object, clazz) {
	object.attr("class", clazz);
};

// CSS类切换
AZD.switchClass = function(object, one, two) {
	if(object.hasClass(one)) {
		object.removeClass(one);
		object.addClass(two);
	} else {
		object.removeClass(two);
		object.addClass(one);
	}
};

// 删除+增加CSS类
AZD.toggleClass = function(object, remove, add) {
	if(object.hasClass(remove)) {
		object.removeClass(remove);
	}

	if(!object.hasClass(add)) {
		object.addClass(add);
	}
};

// 模态窗体
AZD.modal = function(msg, title, btnMsg) {
	var id = "___modal_azd_modal_";
	if(!AZD.existDOM(id)) {
		var txt = '';
		txt += '<div id="' + id + '" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">';
		txt += '    <div class="modal-dialog">';
		txt += '        <div class="modal-content">';
		txt += '			<div class="modal-header">';
		txt += '                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>';
		txt += '                <h4 class="modal-title">标题</h4>';
		txt += '            </div>';
		txt += '            <div class="modal-body">内容提示！</div>';
		txt += '            <div class="modal-footer">';
		txt += '                <button type="button" class="btn btn-danger btn-modal" data-dismiss="modal">确定</button>';
		txt += '            </div>';
		txt += '        </div>';
		txt += '    </div>';
		txt += '</div>';

		// 增加DOM树
		$("body").append(txt);
	}

	// 参数设置
	$("#" + id + " .modal-body").html(msg);
	$("#" + id + " .modal-title").html((title || "标题"));
	$("#" + id + " .btn-modal").html((btnMsg || "确定"));

	// 弹出对话框
	$("#" + id).modal({
		backdrop: "static"
	});
};

// 警告提示
AZD.alert = function(msg, title, btnMsg) {
	var id = "___alert_azd_modal_";
	if(!AZD.existDOM(id)) {
		var txt = '';
		txt += '<div id="' + id + '" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">';
		txt += '    <div class="modal-dialog">';
		txt += '        <div class="modal-content">';
		txt += '			<div class="modal-header">';
		txt += '                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>';
		txt += '                <h4 class="modal-title">警告提示</h4>';
		txt += '            </div>';
		txt += '            <div class="modal-body text-danger">警告内容提示！</div>';
		txt += '            <div class="modal-footer">';
		txt += '                <button type="button" class="btn btn-danger btn-alert" data-dismiss="modal">确定</button>';
		txt += '            </div>';
		txt += '        </div>';
		txt += '    </div>';
		txt += '</div>';

		// 增加DOM树
		$("body").append(txt);
	}

	// 参数设置
	$("#" + id + " .modal-body").html(msg);
	$("#" + id + " .modal-title").html((title || "警告提示"));
	$("#" + id + " .btn-alert").html((btnMsg || "确定"));

	// 弹出对话框
	$("#" + id).modal({
		backdrop: "static"
	});
};

// 确认提示
AZD.confirm = function(callback, msg, btnYes, btnNo) {
	var id = "___confirm_azd_modal_";
	if(!AZD.existDOM(id)) {
		var txt = '';
		txt += '<div id="' + id + '" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">';
		txt += '    <div class="modal-dialog">';
		txt += '        <div class="modal-content">';
		txt += '            <div class="modal-body text-danger">确认提示内容！</div>';
		txt += '            <div class="modal-footer">';
		txt += '                <button type="button" class="btn btn-default btn-no" data-dismiss="modal">取消</button>';
		txt += '                <button type="button" class="btn btn-danger btn-yes" data-dismiss="modal">确定</button>';
		txt += '            </div>';
		txt += '        </div>';
		txt += '    </div>';
		txt += '</div>';

		// 增加DOM树
		$("body").append(txt);
	}

	// 参数设置
	$("#" + id + " .modal-body").html(msg);
	$("#" + id + " .btn-no").html((btnNo || "取消"));
	$("#" + id + " .btn-yes").html((btnYes || "确定"));

	// 回调函数绑定
	var func = (callback || AZD.noop);
	$("#" + id + " .btn-no").unbind("click");
	$("#" + id + " .btn-no").click(function(e) {
		func("no");
	});

	$("#" + id + " .btn-yes").unbind("click");
	$("#" + id + " .btn-yes").click(function(e) {
		func("yes");
	});

	// 弹出对话框
	$("#" + id).modal({
		backdrop: "static"
	});
};

// 根据URL获取操作值
AZD.findHrefOpt = function(href) {
	if(!href) {
		var href = self.location.href;
		if(href.indexOf("http://") == 0) {
			href = href.substr(7);
		} else if(href.indexOf("https://") == 0) {
			href = href.substr(8);
		}
	}

	// www.127.com/user/deposit-online.htm -> deposit
	var idxBegin = href.lastIndexOf("/");
	var idxDot = href.indexOf(".htm", idxBegin);
	var token = href.substring(idxBegin + 1, idxDot);
	if(token.indexOf("-") >= 0) {
		token = token.substring(0, token.indexOf("-"));
	}

	if(window.console) {
		window.console.log("菜单导航-用户后台-B:" + idxBegin + ", DOT:" + idxDot + ", T:" + token);
	}
	
	return token;
};

// 初始化树结构
AZD.constructTree = function(id, setting, nodes) {
	$.fn.zTree.init($("#" + id), setting, nodes);
};

// 获取URL所有请求参数
AZD.findURLParams = function() {
	var vars = [], hash;
	var hashes = self.location.href.slice(self.location.href.indexOf('?') + 1).split('&');
	for(var i = 0; i < hashes.length; i++) {
		hash = hashes[i].split('=');
		vars.push(hash[0]);
		vars[hash[0]] = hash[1];
	}
	
	return vars;
};

// 获取URL单个请求参数
AZD.findURLParam = function(name) {
	return AZD.findURLParams()[name];
};

/**
 * 初始化
 */
$(document).ready(function() {
	// 回到顶部
	$("body").append("<p id=\"back-to-top\" title=\"返回顶部\"><a href=\"#body\"><span></span></a></p>");
	$("#back-to-top").addClass("hidden-xs");
	$("#back-to-top").hide();

	$(window).scroll(function() {
		if($(window).scrollTop() > 100) {
			$("#back-to-top").fadeIn(300);
		} else {
			$("#back-to-top").fadeOut(300);
		}
	});
	$("#back-to-top").click(function() {
		$("body,html").animate({
			scrollTop: 0
		}, 300);
		return false;
	});

	$("#back-to-top").tooltip({
		animation: false,
		trigger: "hover",
		placement: "left"
	});

	// Tooltip插件
	$(".otip").tooltip({
		animation: false,
		trigger: "hover",
		placement: "bottom"
	});
	$(".ktip").tooltip({
		animation: false,
		trigger: "click",
		placement: "bottom"
	});

	$(".opop").popover({
		trigger: "hover"
	});
	$(".kpop").popover({
		trigger: "click"
	});

	// Toastr提示
	if(typeof toastr !== 'undefined') {
		toastr.options = {
			"closeButton": true,
			"debug": false,
			"positionClass": "toast-bottom-full-width",
			"onclick": null,
			"showDuration": "300",
			"hideDuration": "1000",
			"timeOut": "5000",
			"extendedTimeOut": "1000",
			"showEasing": "swing",
			"hideEasing": "linear",
			"showMethod": "fadeIn",
			"hideMethod": "fadeOut"
		};
	}

	// F12页面提示
	if(window.console) {
		window.console.info("%c对于那些看到一个页面就要按F12的web开发者来说，你是喜欢我们的代码呢，还是发现了什么bug？不如直接和我们联系吧！", "font-size:14px;");
		window.console.info("%c邮件联系 老牛啊 obullxl@gmail.com", "color:red;font-size:14px;");
	}

	// 禁用右键
	/*
	 * $(document).bind("contextmenu", function(e) { return false; });
	 */

	// 菜单导航
	var href = self.location.href;
	if(href.indexOf("http://") == 0) {
		href = href.substr(7);
	} else if(href.indexOf("https://") == 0) {
		href = href.substr(8);
	}
	var hrefOpt = AZD.findHrefOpt(href);
	if(window.console) {
		window.console.info("菜单导航, HREF: " + href + ", TOKEN: " + hrefOpt);
	}
	
	if(href.indexOf("/user/") >= 0) {
		/* 用户后台 */
		if(window.console) {
			window.console.log("菜单导航-用户后台-" + href);
		}
		
		$(".user-menus a").attr("class", "list-group-item");
		$(".user-menus a").prepend("<i class=\"fa fa-caret-right\"></i> ");

		for(var i = 1; i <= 3; i++) {
			var userMenu = $(".user-menus #user-menu0" + i);
			userMenu.attr("class", "list-group-item list-group-item-info pointer");

			userMenu.click(function(e) {
				$("." + $(this).data("clz")).toggleClass("hide");
				$(this).find(".fa").toggleClass("fa-plus").toggleClass("fa-minus");
			});
		}

		var menuItem = $("#menu-" + hrefOpt);
		if(menuItem.length) {
			menuItem.addClass("list-group-item-active");
			menuItem.find("i").attr("class", "glyphicon glyphicon-chevron-right");

			menuItem.parent("div").toggleClass("hide");
			var userMenu = menuItem.parent("div").prev();
			userMenu.find(".fa").toggleClass("fa-plus").toggleClass("fa-minus");
		}
	} else if(href.indexOf("/help/") >= 0) {
		/* 帮助中心 */
		if(window.console) {
			window.console.info("菜单导航-帮助中心" + href);
		}
		
		var dxtNavBar = $("#dxt-nb-help");
		if(dxtNavBar.length) {
			dxtNavBar.addClass("active");
		}

		$(".help-menus a").attr("class", "list-group-item");
		$(".help-menus a").prepend("<i class=\"fa fa-caret-right\"></i> ");

		$(".help-menus .help-menu").attr("class", "list-group-item list-group-item-info pointer").click(function(e) {
			$("." + $(this).data("clz")).toggleClass("hide");
			$(this).find(".fa").toggleClass("fa-plus").toggleClass("fa-minus");
		});

		var id = AZD.findURLParam("id");
		if(hrefOpt === "detail") {
			id = AZD.findURLParam("catg");
		}
		
		var menuItem = $("#help-" + id);
		if(menuItem.length) {
			menuItem.addClass("list-group-item-active");
			menuItem.find("i").attr("class", "glyphicon glyphicon-chevron-right");

			menuItem.parent("div").toggleClass("hide");
			var userMenu = menuItem.parent("div").prev();
			userMenu.find(".fa").toggleClass("fa-plus").toggleClass("fa-minus");
		}
	} else if(href.indexOf("/forum/") >= 0) {
		/* 用户论坛 */
		if(window.console) {
			window.console.info("菜单导航-用户论坛");
		}
		
		var dxtNavBar = $("#dxt-nb-forum");
		if(dxtNavBar.length) {
			dxtNavBar.addClass("active");
		}
	} else if(href.indexOf("/mngt/") >= 0) {
		// 3.管理后台
		if(window.console) {
			window.console.info("菜单导航-管理后台");
		}
	} else {
		// 4. "/home/" or OTHER
		if(window.console) {
			window.console.info("菜单导航-OTHER");
		}
		
		var dxtNavBar = $("#dxt-nb-" + hrefOpt);
		if(dxtNavBar.length) {
			dxtNavBar.addClass("active");
		}
	}

	//
	;
});

function fadeProgressModal(visiable) {
	if(visiable) {
		$("#modal-progress").modal("show");
	} else {
		$("#modal-progress").modal("hide");
	}
}

function fadeSuccessModal(data) {
	$("#success-biz-log").text(data.bizLog);
	$("#modal-success").modal("show");
}

function fadeFailureModal(data) {
	$("#failure-biz-log").text(data.bizLog);
	$("#failure-resp-code").text(data.respCode);
	$("#failure-resp-desp").text(data.respDesp);
	$("#modal-failure").modal("show");
}

/*
 * setTimeout(function() { $('.sidebar-nav').affix() }, 100);
 */

/**
 * 该方法必须与lhgdialog组件配合使用
 */
function showFailureTip(result) {
	$.dialog({
		title: "失败提示",
		icon: "error.gif",
		content: "错误码:<b>" + result.respCode + "</b><br/>错误描述:<b>" + result.respDesp + "</b>"
	});
}

/**
 * 该方法必须与lhgdialog组件配合使用
 */
function showSuccessTip(result) {
	var cfn = function() {
	};

	if(result.close) {
		cfn = result.close;
	}

	$.dialog({
		title: "成功提示",
		icon: "success.gif",
		content: result.msg,
		close: cfn
	});
};

/**
 * 发起Ajax请求 <p/> 必须参数: form, url; <br/>可选参数: smsg, sclose, scallback
 */
AZD.ajaxRquest = function(args) {
	var smsg = "恭喜您，操作成功！";
	if(args["smsg"]) {
		smsg = args["smsg"];
	}

	var sclose = function() {
	};
	if(args["sclose"]) {
		sclose = args["sclose"];
	}

	jQuery.ajax({
		type: "POST",
		dataType: "json",
		url: args["url"],
		data: $("#" + args["form"]).serialize(),

		success: function(result) {
			if(result.success) {
				showSuccessTip({
					msg: smsg,
					close: sclose(result)
				});
			} else {
				showFailureTip(result);
			}

			if(args["scallback"]) {
				args["scallback"](result);
			}
		}
	});
};

/* 查看图片 */
var viewImage = function(args) {
	$.dialog.setting.min = true;
	$.dialog.setting.max = true;
	$.dialog({
		title: args.title || "查看相册图片",
		padding: args.padding || 0,
		width: args.width || '700px',
		height: args.height || '500px',
		content: '<img src="' + args.url + '"/>'
	});
};
