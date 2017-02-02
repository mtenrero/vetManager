/**
 * Created by Adrian on 2/2/17.
 */
$(document).ready(function() {

  $('.datepicker').pickadate({
    min: new Date(),
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15 // Creates a dropdown of 15 years to control year
  });

  var picker = $('.datepicker').pickadate('picker');
  picker.set('select', new Date())

});
