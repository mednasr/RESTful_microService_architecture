var UserRoute = function() {};

UserRoute.prototype.list = function(req, res) {
    res.status(200);
    res.json([
        { "name": 'Ahmet',  "age": "26" },
        { "name": 'Mehmet', "age": "32" },
        { "name": 'Ali',    "age": "23" }
    ]);
};

UserRoute.prototype.find = function(req, res) {
    res.json({
        "name": 'Ahmet', "age": "26"
    });
};

UserRoute.prototype.update = function(req, res) {
    return {};
};

UserRoute.prototype.create = function(req, res) {
    return {};
};

// exporting anonymous prototype
module.exports = UserRoute;
