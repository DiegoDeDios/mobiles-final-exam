var mongoose = require('mongoose'); 

const userSchema = new mongoose.Schema({ //Patient schema
    _id: String,
    password: String,
    name: String,
    age: String,
    dob:String,
    sex: String,
    allergies: String,
    problem: String
 });


 module.exports = mongoose.model('Users', userSchema);

 //id=3d&name=diego&age=10&sex=M&allergies=no&problem=NA