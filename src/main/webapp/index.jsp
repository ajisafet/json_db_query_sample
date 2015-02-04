<!DOCTYPE html>
<html>
	<head>
		<title></title>
		
		<!-- DataTables CSS -->
		<link rel="stylesheet" type="text/css" href="/JsonDbQuerySample/datatables_1.10.4/media/css/jquery.dataTables.css">
  
		<!-- jQuery -->
		<script type="text/javascript" charset="utf8" src="/JsonDbQuerySample/datatables_1.10.4/media/js/jquery.js"></script>
  
		<!-- DataTables -->
		<script type="text/javascript" charset="utf8" src="/JsonDbQuerySample/datatables_1.10.4/media/js/jquery.dataTables.js"></script>
		
		<script type="text/javascript" src="js/json/json2.js"></script>
		
		<style>
			
			*{
				font-family: Arial, Verdana, sans-serif;
				font-size: 12px;
			}
			fieldset{
				width: 400px;
				padding: 5px 10px 10px;
			}
			.title{
				float: left;
				width: 100px;
				text-align: right;
				margin-right: 10px;
			}
			
			input[type=text]{
				width:290px;
				border:0px;/*1px solid gray*/
				border-style: none none dotted;
				border-width: 0 0 1px;
				border-color: none none gray;
				padding:0;
			}
			
			input[type=text]:focus{
				width:288px;
				border:1px dotted gray;
				padding:0;
			}
			
			.eachrow{
				margin: 10px 0px;
			}
			
			.submitrow{
				/*text-align: right;*/
			}
			
			#submit_button{
				width: 150px;
				padding: 4px 5px;
				border: 1px solid black;
				border-radius: 5px;
				float: right;
				text-align: center;
			}
			
			#submit_button:hover, #submit_button:focus{
				color: white;
				background-color: black;
				cursor: pointer;
			}
			
			#book_form{
				float: left;
				width: 450px;
			}
			
			#book_section{
				float: right;
				width: 550px;
			}			
			
			#book_table {
			    /*border: 1px solid black;*/
			    border-collapse: collapse;
			    margin: 0 auto;
			    /*width: 500px;*/
			}
			
			#main{
				width: 1000px;
				margin: 10px auto;
			}
			
		</style>
		
		<!-- <script type="text/javascript" src="js/jquery/jquery-1.11.2.js"></script> -->
		
		<script type="text/javascript">
			
			var bookTable = null;
			
			$(document).ready(function() {
				console.log('ready() function');
				
				bookTable = $('#book_table').dataTable();
				
				
			});
			
			$(document).on('click', '#submit_button', submitData);
			
			var Book = function(id, isbn, title, author) {
				
				this.id = id;
				this.isbn = isbn;
				this.title = title;
				this.author = author;
				
				this.getId = function() {
					return this.id;
				};
				
				this.setId = function(id) {
					this.id = id;
				}
				
				this.setIsbn = function(isbn){
					this.isbn = isbn;
				};
				
				this.getIsbn = function() {
					return this.isbn;
				};
				
				this.setTitle = function(title) {
					this.title = title;
				};
				
				this.getTitle = function() {
					return this.title;
				};
				
				this.setAuthor = function(author) {
					this.author = author;
				}
				
				this.getAuthor = function() {
					return this.author;
				}
				
			}
			
			function myalert(event) {
				console.log('Hello!');
				var $submit_button = $(event.target);
				console.log('button clicked is: ' + $submit_button.attr('id'));
			}
			
			function submitData(event){
				
				var isbn = document.getElementById("book_isbn").value.trim();
				var title = document.getElementById("book_title").value.trim();
				var author = document.getElementById("book_author").value.trim();
				var id = null;
				
				var new_book = new Book (id, isbn, title, author);
				
				json_data = new Object();
				
				json_data['id'] = new_book.getId();
				json_data['isbn'] = new_book.getIsbn();
				json_data['title'] = new_book.getTitle();
				json_data['author'] = new_book.getAuthor();
				console.log('id: ' + id)
				console.log('author: ' + author);
				console.log('title: ' + title);
				console.log('isbn: ' + isbn);
				
				if (new_book.getIsbn() == '') {
				
					alert('ISBN number is empty!');
				
				} else {
					
					$.ajax({
						
						url : 'add_book.do',
						data : {book : JSON.stringify(new_book)},
						type : 'POST',
						dataType: 'text',
						success: function(data, textStatus, jqXHR){
							var json2 = JSON.parse(data);
							if (json2.success != null && json2.success != undefined) {
	
								alert("Success: " + json2.success);
								
							}
							
							console.log('Data isbn: ' + json2.key.isbn);
						}
						
					});
			
				}
			}
			
		</script>
	
	</head>
	<body>
		
		<div id="main">
			
			<h2>Hello World!</h2>
		
			<div id="book_form">
		
				<form method="POST" action="add_book.do">
				
					<fieldset id="book_info">
				
						<legend>Book Details</legend>
				
						<div class="eachrow">
							<label class="title" for="book_isbn">ISBN:</label>
							<input type="text" id="book_isbn" name="book_isbn"/>
						</div>
					
						<div class="eachrow">
							<label class="title" for="book_title">Book Title:</label>
							<input type="text" id="book_title" name="book_title"/>
						</div>
					
						<div class="eachrow">
							<label class="title" for="book_author">Author:</label>
							<input type="text" id="book_author" name="book_author"/>
						</div>
					
						<div class="submitrow">
							<span id="submit_button">Submit!</span>	
						</div>
					
					</fieldset>
				
				</form>
			
			</div>
			
			<div id="book_section">
				<table id="book_table">
					<thead>
						<tr>
							<th>id</th>
							<th>isbn</th>
							<th>title</th>
							<th>author</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
			
		</div>
			<!-- 
			<div>
				<span id="display_isbn">Display ISBN</span>
			</div>
			 -->
			<script type="text/javascript">
			/*
			document.getElementById('display_isbn').onclick = function() {
					alert("ISBN var: " + isbn.value );
				};
			*/
			</script>
	
	</body>
</html>
