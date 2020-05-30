module.exports = (app) => {
    const notes = require('../controllers/user.controllers.js');

    // Create a new Note
    app.post('/user', notes.create);

    // Retrieve all Notes
    app.get('/user', notes.findAll);

    // Retrieve a single Note with noteId
    app.get('/user/:patientId', notes.findOne);

    // Delete a Note with noteId
    app.delete('/user/:patientId', notes.delete);
}