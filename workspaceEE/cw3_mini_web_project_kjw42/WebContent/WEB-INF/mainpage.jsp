<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<meta charset="utf-8">
    		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
			integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
		<script>
				function load(){
				window.alert("Hello World!");
				var interact = document.getElementById("Gondola");
				interact.remove();
				}
		</script>
			<style>
				.caret {
  				cursor: pointer;
  				user-select: none; /* Prevent text selection */
				}
				.caret::before {
  				content: "\25B6";
 				color: black;
 				display: inline-block;
 				margin-right: 6px;
				}
				ul {
 				list-style-type: none;
				}
			</style>
			<title>mainpage</title>
		</head>
		<body>
			<ul>
				<li>
				<a class="caret" onClick="load()" data-pid="0" data-cid="1" data-abstract="1">Vehicle</a>
					<ul class="east">
						<li id="Car" data-pid="1" data-cid="2" data-abstract="0"> Car	</li>
						<li id="Plane" data-pid="1" data-cid="3" data-abstract="0">Plane</li>
						<li id="Watercraft" data-pid="1" data-cid="4" data-abstract="0"><span class="caret" onClick="test()"> Watercraft</span>
							<ul class="nested">
								<li id="Ship" data-pid="4" data-cid="5" data-abstract="0">Ship</li>
								<li id="SailingVest" data-pid="4" data-cid="6" data-abstract="0">Sailing Vest</li>
								<li id="Boat" data-pid="4" data-cid="7" data-abstract="0"><span class="caret" onClick="clear()">Boat</span>
									<ul class="nested">
										<li id="Powerboat" data-pid="6" data-cid="8" data-abstract="0">Powerboat</li>
										<li id="Rowingboat" data-pid="6" data-cid="9" data-abstract="0"><span class="caret" onClick="load()">Rowingboat</span>
												<ul class="nested">
													<li id="Gondola" data-pid="8" data-cid="10" data-abstract="0"> Gondola<input type="radio" name="add"><input type="radio" name="delete" > </li>
												</ul>
				 							</li>
										</ul>
									</li>
								</ul>
							</li>
						</ul>
					</li>
				</ul>
			<br>
			<p id="demo"> Hello World!</p>
			<form action="../../controllers/extractClassInfo.java">
  					name:<br>
  					<input type="text" name="name"><br>
 			 		Abstract?<br>
  					<input type="text" name="abstract"><br>
  Cid?<br>
  <input type="text" name="cid"><br>
  Pid?<br>
  <input type="text" name="pid"><br>
		  			<input type="submit" value="Submit" onclick= "test()">
			</form>
			<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
			<script>
				function test(){
				var run = '<li><a>"Hello bro"</a><ul><li><a>"Nested!"</a></li></ul></li>'
				var btn = document.createElement("UL");   // Create a <button> element
				btn.innerHTML = run;   // Insert text
				document.getElementById("Gondola").appendChild(btn);
				}
			</script>
	</body>
</html>