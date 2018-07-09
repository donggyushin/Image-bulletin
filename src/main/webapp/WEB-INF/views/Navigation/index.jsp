
<%
	String sessionedUser = null;
	sessionedUser = (String) session.getAttribute("sessionedUser");
%>

<div class="highNav">
	<div class="highNav__milestone">
		<h1 class="highNav__milestone__h1">
			<a class="highNav__a" href="/">Gyu</a>
		</h1>
	</div>
	<div class="highNav__managements">
		<%
			if (sessionedUser == null) {
		%>
		<span class="highNav__managements__span"><a href="/SignIn"
			class="highNav__a">Signin</a></span> <span
			class="highNav__managements__span"><a href="/SignUp"
			class="highNav__a">Signup</a></span>
		<%
			}
		%>

		<%
			if(sessionedUser != null){
				
				%>
				<span class="highNav__managements__span"><a href="/user/logout"
			class="highNav__a">logout</a></span>
				<%
				
				
			}
		%>



	</div>
</div>
