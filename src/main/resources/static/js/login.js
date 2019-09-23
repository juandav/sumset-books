const endpointAuth = "/api/auth";
const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

/** Forms */
const signupForm = document.getElementById('signupForm');
const signinForm = document.getElementById('signinForm');

signupForm.onsubmit = function(e) {
	e.preventDefault();	
	const name = e.target.name.value;
	const age = e.target.age.value;
	const email = e.target.email.value;
	const username = e.target.username.value;
	const password = e.target.password.value;
	const role = ["user"];
	fetch(`${endpointAuth}/signup`, {
        method: 'POST',
        headers: {
        	'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
        	name,
        	email,
        	username, 
        	password,
        	role
        })
    })
    .then(response => {
    	if (response.status === 200){
    		Swal.fire(
			  'Good job!',
			  'Registered user successfully',
			  'success'
			)
    	}
    })
}

signinForm.onsubmit = function(e) {
	e.preventDefault();
	const username = e.target.username.value;
	const password = e.target.password.value;
	fetch(`${endpointAuth}/signin`, {
        method: 'POST',
        headers: {
        	'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
        	username, 
        	password
        })
    })
    .then(response => response.json())
    .then(data => {
    	sessionStorage.setItem('token', data.accessToken);
    	window.location.replace("/app/home");
    })
}

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});