<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Group 12: Profile</title>
</head>
<body>

    <h3>Group 12: User Profile</h3>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%--<form:errors path="student1.*"/>--%>
    <form id="createForm" action=""  >
        <table>
            <tr>
                <td>ID : </td> <td>    <input type="text" name="id" ></td>
            </tr>

            <tr>
                <td>First Name : </td> <td>    <input type="text" name="firstname"  ></td>
            </tr>

            <tr>
                <td>Last Name: </td> <td>    <input type="text" name="lastname" ></td>
            </tr>

            <tr>
                <td>Email: </td> <td><input type="text" name="email"></td>
            </tr>

            <tr>
                <td>Address: </td>  <td><input type="text" name="address" ></td>
            </tr>

            <tr>
                <td>Organization: </td>  <td><input type="text" name="organization" ></td>
            </tr>

            <tr>
                <td>About Myself: </td>  <td><input type="text" name="aboutmyself"></td>
            </tr>

            <tr><td><input type="submit" value="CREATE" onclick="submitForm()"/></td></tr>

            </table>

    </form>
    <script>

        function submitForm() {
            var profileForm = document.getElementById("createForm");
            var action = "/profile/";
            action += profileForm.elements[0].value + "?";
            var param="";
            for( var i = 0; i < profileForm.length; i++) {
                var ele = profileForm.elements[i];
                if(ele.type == "text") {
                    param += ele.name + "=" + ele.value +"&";
                }
            }
            var newForm = document.createElement("form");
            newForm.method = "post";
            newForm.action = action + param;
            document.body.appendChild(newForm);
            newForm.submit();
        }
    </script>
</body>
</html>
