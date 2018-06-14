Ext.onReady(function() {
			var _win = new Ext.Window({
						title : "测试窗口",
						layout : "form",
						width : 1000,
						height : 500,
						plain : true,
						style : "padding:5px",
						items : [{
									layout : "column",
									xtype : "panel",
									style : "padding:3px",
									baseCls : "x-plain",
									items : [{
												columnWidth : 0.2,
												labelWidth : 40,
												baseCls : "x-plain",
												layout : "form",
												defaultType : "textfield",
												items : [{
															fieldLabel : "姓名"
														}, {
															xtype:"datefield",
															width:150,
															fieldLabel : "生日"
														}, {
															fieldLabel : "身高"
														}, {
															fieldLabel : "体重"
														}]
											}, {
												columnWidth : 0.8,
												layout : "form",
												items : [{
															xtype : "textfield",
															fieldLabel : "个人照片",
															inputType : "image"

														}]
											}]
								}, {
									style : "padding:3px",
									labelWidth : 40,
									layout : "form",
									baseCls : "x-plain",
									defaultType : "textfield",
									items : [{
												fieldLabel : "邮箱",
												width : 400
											}, {
												fieldLabel : "地址",
												width : 400
											}]
								}],
						buttons : [{
									text : "确定"
								}, {
									text : "取消"
								}],
						listeners : {
							"show" : function(_win) {
								_win.findByType("textfield")[4].getEl().dom.src="1159116751e9dfc73fo.jpg"
							}
						}
					}).show();

		});