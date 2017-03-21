/**
 * Created by marcostenrero on 21/3/17.
 */
$(document).ready(function() {

    $('a .dropdown-button').dropdown({
            inDuration: 300,
            outDuration: 225,
            constrainWidth: false, // Does not change width of dropdown to that of the activator
            hover: true, // Activate on hover
            gutter: 0, // Spacing from edge
            belowOrigin: false, // Displays dropdown below the button
            alignment: 'left', // Displays dropdown with edge aligned to the left of button
            stopPropagation: false // Stops event propagation
        }
    );

    $('.modal').modal();

    $('.datepicker').pickadate({
        min: new Date(),
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 15 // Creates a dropdown of 15 years to control year
    });

    var picker = $('.datepicker').pickadate('picker');
    picker.set('select', new Date());

    $('#dropdownAppointment').find('li a').click(function () {
        console.log(this.getAttribute('pet'));
        $('#pet_code').val(this.getAttribute('pet'));
    });



});