<%-- 
    Document   : shopingList
    Created on : 24-Feb-2023, 3:47:50 PM
    Author     : jaydu
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello,${Jaydutt}<a href="shoppinglist?logout">Logout</a>
        <h2>List</h2>
        <form action="" method="post">
            Add Item: <input type="text" name="itemToAdd">
            <input type="submit" value="AddItem">
        </form> 
        <form action="" method="post">
            Delete Item: <input type="submit" value="DeleteItem">
        </form>
        
    </body>
</html>
