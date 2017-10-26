import EmberValidations from 'ember-validations';
import UserModel from 'user-app/models/user';

export default Ember.Controller.extend(EmberValidations, {
    actions: {
        saveModalNew: function() {
            var self = this;
            var model = self.get("model");

            return Ember.RSVP.all([
                UserModel.new(model)
            ]).then(function(response) {
                alert("OK");
                return self.send('closeModalNew', true);
            }, function(error) {
                alert("Error!");
                return self.send('closeModalNew', false);
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
