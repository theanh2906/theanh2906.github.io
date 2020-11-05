<%@include file="commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Untitled Document</title>
<%@include file="commons/css_import.jsp"%>
</head>

<body class="container-fluid">
	<h1 class="text-center title">Summarization Tools</h1>
	
	<form:form class="row" method="POST" action="${pageContext.request.contextPath}/home/submit" modelAttribute="input" acceptCharset="UTF-8">
		<div class="form-group col-6">
			<label for="textInput">Input text here</label>
			<form:textarea path="textInput" class="form-control" rows="8" />
		</div>
		<div class="form-group col-6">
			<label>Output</label>
			<textarea class="form-control" rows="8" readonly>${summary}</textarea>
		</div>
		<div class="form-group col-6">
			<label for="method">Type</label> <br> 
			<form:radiobutton 
			name="method" 
			value="frequency" 
			path="choice"
			checked="checked"/> Word Frequency  
			<form:radiobutton 
			name="method" 
			value="svd" 
			path="choice" /> Singular Value Decomposition<br>
			<br> <label>Number of sentences:</label><br> 
			<form:radiobutton name="sentenceNum" path="sentenceNum" value="5" checked="checked"/> 5
			<form:radiobutton name="sentenceNum" path="sentenceNum" value="10"/> 10
		</div>
		<div class="form-group col-6">
			<label>Open file:</label> <br> <input type="file"
				name="inputFile" id="inputFile">
		</div>
		<div class="form-group col-12 text-center">
			<textarea class="form-control" rows="8" readonly>${stat}</textarea>
			<br>
			<form:button type="submit" class="btn btn-primary mr-2">Submit</form:button>
			<form:button type="reset" class="btn btn-primary mr-2">Reset</form:button>
			<button type="button" onclick="random()" class="btn btn-primary mr-2">Random</button>
			<button class="btn btn-primary mr-2">Compare</button>
			<!-- <button class="btn btn-primary mr-2">Show graph</button> -->
		</div>
	</form:form>

	
	<script type="text/javascript">
		document.getElementById('inputFile').addEventListener('change', function(){
			var fr = new FileReader();
			fr.onload = function() {
				document.getElementById('textInput').innerHTML = fr.result;
			}
			fr.readAsText(this.files[0]);
		})
	</script>
</body>
</html>
