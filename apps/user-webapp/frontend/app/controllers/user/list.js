import Ember from 'ember';
import UserModel from 'user-app/models/user';

export default Ember.Controller.extend({
    filteredUsers: Ember.computed('model', 'userFilter', function() {
        if (!this.get('userFilter') || this.get('userFilter') === '')
            return this.get('model');

        var userFilter = this.get('userFilter');

        return this.get('model').filter(function(param) {
            return param.firstName.indexOf(userFilter) > -1
        });
    })
});
