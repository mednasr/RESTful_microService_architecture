var express        = require('express');
var app            = express();
var router         = express.Router();
var bodyParser     = require('body-parser');
var userRoute      = require('./routes/user');


app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

var UserRoute = new userRoute();

router.get('/api/users',           UserRoute.list);
router.get('/api/user/:id',        UserRoute.find);
router.put('/api/user/:id/edit',   UserRoute.update);
router.post('/api/user/:id/new',   UserRoute.create);


// REGISTER OUR ROUTES
// all of our routes will be prefixed with /api
app.use('/api', router);


// START THE SERVER
var port = process.env.PORT || 8080;
app.listen(port);
console.log('Listening on port ' + port);
