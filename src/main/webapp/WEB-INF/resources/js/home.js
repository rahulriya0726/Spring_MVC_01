$(document).ready(function(){

	$("#selectedEmp").on("change", function () {
		   var employeeId = $("#selectedEmp").val(); 
		   alert(employeeId)
		    $.ajax({
		        type: "GET",
		        url: "/selectEmployeeById", 
		        data: {
		            id: employeeId
		        },
		        dataType: "json", 
		        success: function (response) {
		            console.log(response);
		        },
		        error: function () {
		            alert('Failed to fetch employee data.');
		        }
		    });
    });

});
