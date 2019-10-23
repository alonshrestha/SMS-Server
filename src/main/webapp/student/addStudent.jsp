<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="np.com.alon.enumlist.HttpRequestList" %>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/main.css">


<jsp:include page="../headers/header.jsp"/>
<div class="main">
    <div class="container">
<%--        <div class="row">--%>
<%--            <a href="${pageContext.request.contextPath}/students" class="btn btn-success float-right">Message List</a>--%>
<%--        </div>--%>
        <br>
        <form name="myform" action="${pageContext.request.contextPath}/students" method="post"  onsubmit="return validateform()">
            <input type="hidden" name="action" value="${HttpRequestList.ADD.toString()}"/>
            <div class="row form-row">
                <label>First Name</label>
                <input type="text" name="firstName" class="form-control"/>
            </div>

            <div class="row form-row">
                <label>Last Name</label>
                <input type="text" name="lastName" class="form-control"/>
            </div>

            <div class="row form-row">
                <label>Parent name</label>
                <input type="text" name="parentName" class="form-control"/>
            </div>


            <div class="row form-row">
                <label>Parent Phone Number</label>
                <input type="text" name="parentPhoneNumber" value="+977" class="form-control"/>
            </div>


            <div class="row form-row">
                <label>Roll No</label>
                <input type="text" name="rollNo" class="form-control"/>
            </div>


            <div class="row form-row">
                <label>Grade</label>
                <select name="grade" class="form-control">
                <c:forEach items="${grades}" var="g">

                        <option value="${g.id}">${g.name}</option>
                </c:forEach>
                </select>
            </div>

            <br>


            <input  type="submit" value="save" class="btn btn-primary"/>
        </form >
    </div>
</div>
<script>
    function validateform(){
        var fname=document.myform.firstName.value;
        var lname = document.myform.lastName.value;
        var pname = document.myform.parentName.value;
        var mobile = document.myform.parentPhoneNumber.value;
        var roll = document.myform.rollNo.value;
        if (fname==null || fname=="" || lname==null || lname=="" || pname==null || pname=="" ){
            alert("Name can't be blank");
            return false;
        }else if(mobile.length<14 || mobile.length>14 ){
            alert("Please enter valid Phone Number");
            return false;
        }
        if (roll==null || roll==""){
            alert("Roll Number can't be blank");
        }
    }
</script>



