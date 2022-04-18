
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Question Ana Answer</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
            function val(v)
            {
                document.getElementById(v).innerHTML = "";
            }
            function validation()
            {
                var flag = true;

                var name2 = document.regform.question.value.trim();
                var email2 = document.regform.answer.value.trim();
                

               
                if (name2 === "")
                {
                    document.getElementById('name_error').innerHTML = "Question cannot be empty";
                    flag = false;
                }

               
                if (email2 === "")
                {
                    document.getElementById('email_error').innerHTML = "Answer cannot be empty";
                    flag = false;
                }
                
                return flag;
            }
        </script>
<style>
.col-md-6{

background-color: yellow;
}
.textFieldDesign {
	 padding: 5px 10px;
    width: 600px;
    border-radius: 5px;
    border: 1px solid gray;
}
</style>
</head>
<body>
<br><br><br>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form method="post" name="regform" onsubmit="return validation()" action="setQuestions">
					<br>
					<br>
					<br> <input type="text" placeholder="Enter Your Question" name="question" class="textFieldDesign" onkeyup="val('name_error')" /> <br> <span id="name_error" style="color: red"> </span> <br> <br>
					<br> <input type="text" placeholder="Enter Your Answer" name="answer" class="textFieldDesign" onkeyup="val('email_error')" /> <br> <span id="email_error" style="color: red"> </span> <br> <br>
					<br>
					<div class="container" style="text-align: center">
					<button type="submit" class="btn btn-primary">submit</button>
					</div>
					
				</form>
				<form action="refresh">
				<input type="number" name="s" value=${s } hidden="true">
				<button type="submit" class="btn btn-primary">Refresh</button>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>