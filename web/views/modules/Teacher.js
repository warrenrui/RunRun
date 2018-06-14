Ext.namespace("Ext.xxr");

Ext.xxr.Teacher = function(cfg) {
	if (cfg == null) {
		cfg = {}
	}
	Ext.apply(this, cfg);
}

Ext.extend(Ext.xxr.Teacher, Ext.xxr.Person, {
			job : "教师",
			print : function() {
				alert(String.format("{0}是一位{1}{2}", this.name, this.sex,
						this.job));
			}
		})