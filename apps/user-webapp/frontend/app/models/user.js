import Ember from 'ember';

var UserModel = Ember.Object.extend({
    firstName: null,
    lastName: null,
    birthDate: null
});

UserModel.reopenClass({
    list: function() {
        return {};

        return Ember.$.get('/api/user/list').then(function(response) {
            var items = []

            if (response) {
                response.forEach(function(item) {
                    items.push(UserModel.create(item))
                });
            }

            return items;
        });
    },
    findById: function(id) {
        return {};

        return Ember.$.get('/api/user/id/' + id).then(function(response) {
            if (!response) 
                return {}
            return UserModel.create(response)
        })
    },
    new: function(data) {
        return {};

        return Ember.$.ajax({
            url        : '/api/user',
            type       : 'POST',
            data       : JSON.stringify(data),
            dataType   : 'json',
            contentType: 'application/json'
        }).then(function (response) {
            if (!response.Value) response.Value = ""
            return response
        }, function (error) {
            console.log("User create error: " + error)
            return error
        });
    },
    update: function(data) {
        return {};

        return Ember.$.ajax({
            url        : '/api/user',
            type       : 'PUT',
            data       : JSON.stringify(data),
            dataType   : 'json',
            contentType: 'application/json'
        }).then(function (response) {
            if (!response.Value) response.Value = ""
            return response
        }, function (error) {
            console.log("User update error: " + error)
            return error
        });
    },
    delete: function(id) {
        return {};
        
        return Ember.$.ajax({
            url : '/api/user/id/' + id,
            type: 'DELETE'
        }).then(function (response) {
            if (!response) response = ""
            return response
        }, function (error) {
            console.log("User delete error: " + error)
            return error
        });
    }
});

export default UserModel;
