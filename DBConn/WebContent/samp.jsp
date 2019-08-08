<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="jquery.min.js"></script>
        <script>
            $(document).ready(function(){
                 $("#t").keyup(function(){
                     var value = $(this).val();
                     $.get("index.jsp",{q:value},function(data){
                    
                     });
                 });
             });
        </script>

</head>
<body>
<form action="index.jsp" method="get">
<input type="text" placeholder="Enter Text Here.." name="q" value="bb" id="t"><br><br>
<input type="submit" value="Submit">
</form>
</body>
</html>