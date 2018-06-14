Ext.namespace("Ext.xxr");
ex = Ext.xxr;

ex.Person = function(cfg) {
	if (cfg == null) {
		cfg = {}
	}
	Ext.apply(this, cfg);
	this.addEvents("nameChange", "sexChange");
}

Ext.extend(ex.Person, Ext.util.Observable, {
			name : "",
			sex : "",
			setName : function(_name) {
				if (this.name != _name) {
					this.fireEvent("nameChange", this, this.name, _name);
					this.name = _name;
				}
			},
			setSex : function(_sex) {
				if (this.sex != _sex) {
					this.fireEvent("sexChange", this, this.sex, _sex);
					this.sex = _sex;
				}
			}
		})