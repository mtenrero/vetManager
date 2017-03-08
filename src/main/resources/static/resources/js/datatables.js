/**
 * Created by Marcos on 31/01/2017.
 */
$(document).ready(function() {
    $('.datatable').DataTable( {
        columnDefs: [
            {
                targets: [ 0, 1, 2 ],
                className: 'mdl-data-table__cell--non-numeric'
            }
        ]
    } );
} );