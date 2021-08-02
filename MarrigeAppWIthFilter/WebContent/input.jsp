<h1 style="color:red ;text-align:center;">Check Marrige Elgibility </h1>
<center><img src="images/marriage.jpg" width="600" height="300" /></center><br>
<form action="marriageurl" method="POST">
	<table border="0px" bgcolor="cyan" align="center">
		<tr>
			<td>Enter Your Name</td>
			<td><input type="text" name="pname"/></td>
		</tr>
		
		<tr>
			<td>Enter Your Age</td>
			<td><input type="text" name="page"/></td>
		</tr>
		<tr>
			<td>Select Gender</td>
			<td><input type="radio" name="gender" value="M" checked/>Male
			<input type="radio" name="gender" value="F"/>FeMale
			 </td>
		</tr>
		<tr>
			<td><input type="submit" value="Check elgibility for marrige"></td>
			<td><input type="reset" value="reset"></td>
		</tr>
		<tr>
		<td colspan="2"><input type="hidden" name="cToken" value="${sToken}"/>
		</tr>
	</table>
</form>
<br><br>
request count from :::${reqCount}