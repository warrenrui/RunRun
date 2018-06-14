Ext.ns('Cneport.ecss.goodsbills');
Cneport.ecss.goodsbills.LogisticsQuery = Ext.extend(Ext.Syis.lib.SyisQueryPanel, {
	limitSize: 100,
	type : null,
	constructor: function(_config) {
		
		if (_config == null) {
			_config = {};
		};
		Ext.apply(this, _config);
		var me = this;
		
		var conditionItems = [{
			layout: 'column',
    		items: [{
    			columnWidth: .25, layout: 'form',
				items: [{
					xtype: 'textfield', anchor: '95%', name: 'logisticsNo', fieldLabel: '物流运单号'
		        }]
    		}, {
    			columnWidth: .25, layout: 'form',
				items: [{
					xtype: 'textfield', anchor: '95%', name: 'logisticsName', fieldLabel: '物流企业名称'
		        }]
    		}, {
    			columnWidth: .25, layout: 'form',
				items: [{
					xtype: 'textfield', anchor: '95%', name: 'totalLogisticsNo', fieldLabel: '总运单号'
		        }]
    		}, {
    			columnWidth: .25, layout: 'form',
				items: [{
					xtype: 'textfield', anchor: '95%', name: 'orderNo', fieldLabel: '订单编号'
		        }]
    		}]
		}, {
			layout: 'column',
    		items: [{
    			columnWidth: .25, layout: 'form',
				items: [{
					xtype: 'textfield', anchor: '95%', name: 'ecpName', fieldLabel: '电商平台名称'
		        }]
    		}, {
    			columnWidth: .25, layout: 'form',
				items: [{
					xtype: 'textfield', anchor: '95%', name: 'consignee', fieldLabel: '收货人名称'
		        }]
    		}, {
    			columnWidth: .25, layout: 'form',
				items: [{
					xtype: 'datefield', anchor: '95%', name: 'dateFrom', fieldLabel: '入库日期 从', format: 'Y-m-d',
	 				listeners: {
						scope: this,
						select: function() {
							this.query_form.find('name', 'dateTo')[0].setMinValue(
								this.query_form.find('name', 'dateFrom')[0].getValue()
							);
						}
					}
		        }]
    		}, {
    			columnWidth: .25, layout: 'form',
				items: [{
					xtype: 'datefield', anchor: '95%', name: 'dateTo', fieldLabel: '至', format: 'Y-m-d',
	 				listeners: {
						scope: this,
						select: function() {
							this.query_form.find('name', 'dateFrom')[0].setMaxValue(
								this.query_form.find('name', 'dateTo')[0].getValue()
							);
						}
					}
		        }]
    		}]
		}, {
			layout: 'column',
    		items: [{
    			columnWidth: .25, layout: 'form',
				items: [{
            		xtype : 'combo', anchor : '95%', name : 'ieType', fieldLabel : '进出口标志',
            		hiddenName : 'ieType',
            		emptyText : '全部',
            		mode : 'local',
            		triggerAction : 'all',
					valueField : 'code', 
					displayField : 'name',
					editable : false,
					store : new Ext.data.ArrayStore({
						fields : ['code', 'name'],
						data : [ ['', '全部类型'], ['I', '进口'], ['E', '出口'] ]
					})
				}]
    		}, {
    			columnWidth: .25, layout: 'form',
				items: [{
					xtype: 'textfield', anchor: '95%', name: 'batchNumbers', fieldLabel: '批次号'
		        },{xtype : 'hidden', name : 'queryType',value : ''}]
    		}]
    	}];
		
		var gridColumn = [
			new Ext.grid.RowNumberer({ header: '序号', width: 35, align: 'center' }), 
			{header: "<div style='text-align:center'>物流运单号</div>", width : 100, dataIndex: 'logisticsNo', sortable: true},
			{header: "<div style='text-align:center'>物流企业名称</div>", width : 180, dataIndex: 'logisticsName', sortable: true},
			{header: "<div style='text-align:center'>总运单号</div>", width : 100, dataIndex: 'totalLogisticsNo', sortable: true},
			{header: "<div style='text-align:center'>订单编号</div>", width : 100, dataIndex: 'orderNo', sortable: true},
			{header: "<div style='text-align:center'>电商平台名称</div>", width : 180, dataIndex: 'ecpName', sortable: true},
			{header: "<div style='text-align:center'>收货人名称</div>", width : 80, dataIndex: 'consignee', sortable: true},
			{header: "<div style='text-align:center'>入库日期</div>", width : 70, dataIndex: 'updateTime', sortable: true},
			{header: "<div style='text-align:center'>进出口标志</div>", width : 90, dataIndex: 'ieTypeText', sortable: true},
			{header: "<div style='text-align:center'>状态</div>", width : 70, dataIndex: 'statusText', sortable: true},
			{header: "<div style='text-align:center'>比对信息</div>", width : 90, dataIndex: 'compareFlagText', sortable: true,
			 renderer: function(val, col, rec) {
				if((rec.data.compareFlag !='Y' && rec.data.compareFlag !='N')){
					return '未比对';
				} else {
					return val;
				}}
			}
		];
		
		var gridStore = new Ext.data.JsonStore({
			autoLoad: true,
			url: 'logistics/queryList',
			root: 'logisList',
			totalProperty: 'totalRows',
			baseParams: {
				queryType : me.type,
				limit: me.limitSize
			},
			remoteSort : true,
			fields: [ 'seqNo', 'logisticsNo', 'logisticsName', 'totalLogisticsNo', 'orderNo', 'ecpName', 'consignee', 'updateTime', 'ieTypeText', 
			'compareFlag', 'statusText', 'compareFlagText' ]
		});
		
		Cneport.ecss.goodsbills.LogisticsQuery.superclass.constructor.call(this, {
			queryConditionTitle: '运单信息查询',
			conditionItems: conditionItems,
			gridColumn: gridColumn,
			gridStore: gridStore,
			hyperLinkData: 'logisticsNo',
			pageSize: me.limitSize
		});
		this.initCondition();
		this.query_form.doLayout();
		
	},
	
	initCondition : function() {
		if(this.type == 'deleteQuery') {
			this.query_form.find('name', 'queryType')[0].setValue(this.type);
		}
	},
	
	// 查询条件重置
	resetCondition: function(){
		this.query_form.getForm().reset();
		this.initCondition();
	},
	
	view: function() {
		var me = this;
		var rec = this.query_grid.getSelectionModel().getSelected();
	 	if (rec != undefined) {
	 		var win = new Ext.Window({
				rec: rec,
				bufferResize : true,
				iconCls : 'btn-form',
				title : '运单信息详情',
				renderTo : 'syisbillQuery',
				closable : true,
				resizable : false,
				draggable : false,
				width : Ext.getCmp('frmPanel').getInnerWidth(),
				height : Ext.getCmp('frmPanel').getInnerHeight(),
				items : [ new Cneport.ecss.goodsbills.LogisticsInput({
					type : me.type,
					win : this
				}) ],
				listeners: {
					close: function(){
						this.query_grid.store.reload();
					},
					scope: this
				}
			}).show();
			
			win.items.get(0).initData(rec);
	 	} else {
			chooseLineAlert();
		}
	}
	
});
