const User = require('../users/models/users.model.js');

// Create and Save a new User
exports.create = (req, res) => {
    // Validate request
    if(!req.body.id) {
        return res.status(400).send({
            message: "Content can not be empty"
        });
    }

    // Create a User
    const patient = new User({
        _id: req.body.id,
        password: req.body.password,
        name: req.body.name,
        age: req.body.age,
        dob:req.body.dob,
        sex: req.body.sex,
        allergies: req.body.allergies,
        problem: req.body.problem
    });

    // Save User in the database
    patient.save()
    .then(data => {
        res.send(data);
    }).catch(err => {
        res.status(500).send({
            message: err.message || "Some error occurred while creating the User."
        });
    });
};

// Retrieve and return all patients from the database.
exports.findAll = (req, res) => {
    User.find()
    .then(patients => {
        res.send(patients);
    }).catch(err => {
        res.status(500).send({
            message: err.message || "Some error occurred while retrieving patients."
        });
    });
};

// Find a single patient with a patientId
exports.findOne = (req, res) => {
    User.findById(req.params.patientId)
    .then(patient => {
        if(!patient) {
            return res.status(404).send({
                message: "User not found with id " + req.params.patientId
            });            
        }
        res.send(patient);
    }).catch(err => {
        if(err.kind === 'ObjectId') {
            return res.status(404).send({
                message: "User not found with id " + req.params.patientId
            });                
        }
        return res.status(500).send({
            message: "Error retrieving patient with id " + req.params.patientId
        });
    });
};


// Delete a patient with the specified patientId in the request
exports.delete = (req, res) => {
    User.findByIdAndRemove(req.params.patientId)
    .then(patient => {
        if(!patient) {
            return res.status(404).send({
                message: "User not found with id " + req.params.patientId
            });
        }
        res.send({message: "User deleted successfully!"});
    }).catch(err => {
        if(err.kind === 'ObjectId' || err.name === 'NotFound') {
            return res.status(404).send({
                message: "User not found with id " + req.params.patientId
            });                
        }
        return res.status(500).send({
            message: "Could not delete patient with id " + req.params.patientId
        });
    });
};