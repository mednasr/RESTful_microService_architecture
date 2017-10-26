import Ember from 'ember';
import UserModel from 'user-app/models/user';

export default Ember.Route.extend({
	model() {
		return [
			{
				id         : "1",
				firstName  : "Necip Fazil",
				lastName   : "Kisakurek",
				birthDate  : "1904/05/26"
			},{
				id         : "2",
				firstName  : "Mehmet Akif",
				lastName   : "Ersoy",
				birthDate  : "1873/12/20"
			},{
				id         : "3",
				firstName  : "Kemal",
				lastName   : "Sunal",
				birthDate  : "1944/11/11"
			}
		];
	},
    actions: {
        showModalNew: function() {
            var modalName = 'user.new';
            var model     = UserModel.create();

            this.controllerFor(modalName).set('model', model);
            this.render(modalName, {
                into  : 'user.list',
                outlet: 'modal'
            });
        },
        closeModalNew: function(refresh) {
            if (refresh) this.refresh();

            return this.disconnectOutlet({
                parentView: 'source.list',
                outlet    : 'modal'
            });
        },
        showModalUpdate: function(param) {
            var modalName = 'user.update';
            var model     = UserModel.create(param);

            this.controllerFor(modalName).set('model', model);
            this.render(modalName, {
                into  : 'user.list',
                outlet: 'modal'
            });
        },
        closeModalUpdate: function(refresh) {
            if (refresh) this.refresh();

            return this.disconnectOutlet({
                parentView: 'user.list',
                outlet    : 'modal'
            });
        },
        delete: function(id) {
            var self = this;
            
            return Ember.RSVP.all([
                UserModel.delete(id)
            ]).then(function(response) {
                alert("OK");
                self.transitionTo('user.list');
                self.refresh();
            }, function(error) {
                alert("Error!");
            });
        }
    }
});
