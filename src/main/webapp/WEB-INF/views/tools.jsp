<%@include file="commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<%@include file="commons/css_import.jsp"%>
</head>
<body>
	<div class="row m-3">
		<div class="col-6">
			<label for="textInput">Input text here</label>
			<textarea id="input" class="form-control" rows="8"></textarea>
		</div>
		<div class="col-6">
			<label>Output</label>
			<textarea id="output" class="form-control" rows="8" readonly></textarea>
		</div>
	</div>

	<script type="text/javascript">
		$("#input").keyup(function(){
			var value = $("#input").val().replace(/[\r\n]{2,}/g, "\n").trim();
			
			$("#output").val(value);
		})
	</script>

</body>
</html>