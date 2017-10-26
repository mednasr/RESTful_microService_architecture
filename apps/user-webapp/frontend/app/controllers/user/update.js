import EmberValidations from 'ember-validations';
import UserModel from 'user-app/models/user';

export default Ember.Controller.extend(EmberValidations, {
    actions: {
        saveModalUpdate: function() {
            var self = this;
            var model = self.get("model")

            return Ember.RSVP.all([
                UserModel.update(model)
            ]).then(function(response) {
                alert("OK");
                return self.send('closeModalUpdate', true);
            }, function(error) {
                alert("Error!");
                return self.send('closeModalUpdate', false);
            });
        }
    },
	validations: {
        'model.firstName': {
            presence: true,
            presence: { message: 'Cannot be empty!' }
        },
		'model.lastName': {
            presence: true,
            presence: { message: 'Cannot be empty!' }
		},
        'model.birthDate': {
            presence: true,
            presence: { message: 'Cannot be empty!' }
        }
	}
})
