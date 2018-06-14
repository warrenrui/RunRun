Ext.namespace("Ext.xxr");

Ext.xxr.Student = function(cfg) {
	if (cfg == null) {
		cfg = {}
	};
	Ext.apply(this, cfg);
}

Ext.extend(Ext.xxr.Student, Ext.xxr.Person, {
			job : "学生"
		});