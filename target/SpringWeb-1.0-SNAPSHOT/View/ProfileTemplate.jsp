
<html>
<head>
    <title>Group 12: Profile</title>
    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
</head>
<body>

<h3>Group 12: User Profile</h3>


<form id="createForm" action="">
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
            <td>About Myself: </td>  <td><input type="text" name="aboutMyself"></td>
        </tr>

        <tr><td><input type="submit" value="CREATE" /></td></tr>

    </table>

</form>
<script>
    $('#createForm').submit(function(e){

        var profileForm = document.getElementById("createForm");
        var action = "/profile/";
        action += profileForm.elements[0].value + "?";
        var param="";
        for( var i = 1; i < profileForm.length; i++) {
            var ele = profileForm.elements[i];
            if(ele.type == "text") {
                param += ele.name + "=" + ele.value +"&";
            }
        }

        $.ajax({
            type:"POST",
            url: action+param,
            success:function(response) {

                document.open();
                document.write(response);
                document.close();
            }
        });

        e.preventDefault();
    })

</script>
</body>
</html>

