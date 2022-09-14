<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Spring Authentication - Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-center mt-5 mb-5">Login Here</h1>
        <div class="row justify-content-center">
            <div class="card col-lg-6">
                <div class="card-body">
                    <form:form action="/login" method="post">
                        <div class="mb-3">
                            <label for="username" class="form-label">Enter Username</label>
                            <input type="text" name="username" id="username" class="form-control" placeholder="Enter Username" />
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Enter Password</label>
                            <input type="password" name="password" id="password" class="form-control" placeholder="Enter Password" />
                        </div>
                        <div class="mb-3">
                            <input type="submit" class="btn btn-lg btn-primary form-control" />
                        </div>
                    </form:form>
                </div>
                <div class="card-footer">
                    <a href="/register">Don't have an account? Register Here</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>