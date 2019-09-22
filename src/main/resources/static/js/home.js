const endpointBooks = "/api/books";
const $searchForm = document.getElementById('searchForm');

function loanOpen() {
	Swal.fire(
			  'Good job!',
			  'You clicked the button!',
			  'success'
			)
}

$searchForm.onsubmit = function(e, values) {
	e.preventDefault();	
	let searchTerm = e.target.term.value;
	
	fetch(endpointBooks + '/' +  searchTerm, {
        method: 'GET',
        headers: {
            'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWFuZGF2IiwiaWF0IjoxNTY5MTg0MDY0LCJleHAiOjE1NjkyNzA0NjR9.tG2_wHIW7wOCYSImv54LAYHnVJCIcWcgqphHKGa8QeJQhU3WPr7DUIi-ydZwHBogPIFDoB5RtIqX_3LqRc7EEw'
        }
    })
    .then(response => response.json())
    .then(function(myJson) {
    	console.log(myJson)
    	const $bookProducts = document.getElementById('book-products');
    	if (myJson.length > 0) {
        	let books = myJson.map(item => `
        		<div class="product__card">
		          <img class="product__image" src=${item[2]} alt="book" />
		          <div class="product__content">
		            <span class="product__name"><b>${item[0]} - ${item[3]},</b> ------ <b>Estado:</b> ${item[8]? "Prestado": "Disponible"}</span>
		            <br />
		            <span class="product__price">${item[5]} - ${item[4]}</span>
		            <hr class="product__divider" />
		            <p class="product__description">${item[1]}</p>
		            
		            <button onClick="loanOpen()">${item[8]? "Prestar": "Regresar"}</button>
		          </div>
        		</div>        	
        	`);
    		let booksReduce = books.reduce((accumulator, currentValue) => accumulator + currentValue);
    		$bookProducts.innerHTML = `
    			<div class="product owl-carousel owl-theme">
    				${booksReduce}
    			</div>
    		`;
    		$(document).ready(function(){
			  $('.owl-carousel').owlCarousel({
			      slideSpeed : 300,
			      paginationSpeed : 400,
			      singleItem:true,
			      items : 1
			  });
			});
    	} else {
    		$bookProducts.innerHTML = "";
    	}
    });
}