/*
//Auto-calculate total fee
let subjects = document.querySelectorAll(".subject");
let totalBox = document.getElementById("total");
subjects.forEach(item => {
	item.addEventListener("change", () =>{
		let total = 0;
		subjects.forEach(sub => {
			if(sub.checked){
				total += parseInt(sub.value);
			}
		});
		totalBox.innerText = "₹" + total;
	});
});

document.getElementById("regForm").addEventListener("submit", function(e){
	e.preventDefault();
	e.preventDefault();
	let selectedSubjects = [];
	let totalFee=0;
	subjects.forEach(sub => {
		if(sub.checked){
			let subjectName = sub.parentElement.innerText.trim();
			selectedSubjects.push(subjectName);
			totalFee += parseInt(sub.value);
		}
	});
	if(selectedSubjects.length === 0){
		alert("Please select at least one subject");
		return;
	}
	let studentName= document.getElementById("name").value;
	let message=
		"Student Name: " + studentName + "\n\n" + "Selected Subject: \n- " + selectedSubjects.join("\n-") + "\n\n" + 
		"Total Fee: " + totalFee;
	alert(message);
});

*/

function calculateTotal() {
    let subjects = document.querySelectorAll(".subject");
    let total = 0;

    subjects.forEach(sub => {
        if (sub.checked) {
            total += parseInt(sub.value);
        }
    });

    document.getElementById("total").innerText = total;
    return total;
}

function submitForm() {
    let total = calculateTotal();

    //  Show message below form instead of popup alert
    document.getElementById("msg").innerText =
        "Registration Successful! Total Registration Fee: ₹" + total;
}
