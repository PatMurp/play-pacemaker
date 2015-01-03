// BMI calcuator
function bmi() {
	// Set variables for calculation
	var w = parseFloat(document.frm.weight.value);
	var h = parseFloat(document.frm.height.value);

	// Form validation
	var errors = '';

	// Convert height to centimetres & weight to kg
	if (document.frm.opHeight.value == "Meter") {
		h = h * 100;
	}
	if (document.frm.opHeight.value == "Inch") {
		h = h * 2.54;
	}
	if (document.frm.opWeight.value == "Lb") {
		w = w * 0.4536;
	}

	// Check weight and height for invalid values
	if (isNaN(w)) {
		errors += 'The weight value is not a number.\n';
	}
	if (isNaN(h)) {
		errors += 'The height value is not a number.\n';
	}
	if ((w < 20) || (w > 200)) {
		errors += 'Please enter a valid weight.\n';
	}
	if ((h < 100) || (h > 250)) {
		errors += 'Please enter a valid height.\n';
	}

	// Display any error messages
	if (errors) {
		alert('The following error(s) occurred:\n' + errors);
		return 0;
	}
	
	// Calculate BMI
	var answer = Math.round(10 * ((w * 10000 / (h * h)))) / 10;
	
	// Display BMI Value on page
	document.getElementById('feedback').innerHTML = 'Your BMI is ' + answer;
	
	// Check BMI value and display BMI Classification
	if (answer <= 15.99) {
		document.getElementById('answerOut').innerHTML = "Classification: Severe Thinness";

		return false;
	}
	if (answer >= 16.00 && answer <= 16.99) {
		document.getElementById('answerOut').innerHTML = "Classification: Moderate Thinness";

		return false;
	}
	if (answer >= 17.00 && answer <= 18.49) {
		document.getElementById('answerOut').innerHTML = "Classification: Mild Thinness";

		return false;
	}
	if (answer >= 18.50 && answer <= 24.99) {
		document.getElementById('answerOut').innerHTML = "Classification: Normal Weight";

		return false;
	}
	if (answer >= 25.00 && answer <= 29.99) {
		document.getElementById('answerOut').innerHTML = "Classification: Overweight";
		return false;
	}
	if (answer >= 30.00 && answer <= 34.99) {
		document.getElementById('answerOut').innerHTML = "Classification: Obese Class I";
		return false;
	}
	if (answer >= 35.00 && answer <= 39.99) {
		document.getElementById('answerOut').innerHTML = "Classification: Obese Class II";
		return false;
	}
	if (answer >= 40.0) {
		document.getElementById('answerOut').innerHTML = "Classification: Obese Class III";
		return false;
	}

}
// Reset bmi calcuator values
function resetAll() {
	document.getElementById('feedback').innerHTML = "";
	document.getElementById('answerOut').innerHTML = "";
	return true;
}

// Show and hide activity table on report page
$(function() {
    $("#show").click(function() {
        $("#viewHide").show(function() {
        });
    });
    $("#hide").click(function() {
        $("#viewHide").hide("normal");
    });
   
});
