<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<script type="text/javascript" src="js/json/json2.js"></script>
		
		<script type="text/javascript">
			
		</script>
		
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
			
		</style>
	</head>
	<body>
		
		<h2>Hello World!</h2>
		
		<!-- <div id="book_form"> -->
		
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
		<!-- </div> -->
	</body>
</html>
