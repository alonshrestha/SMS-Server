<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="np.com.alon.enumlist.HttpRequestList" %>

<jsp:include page="../headers/header.jsp"/>
<div class="main">
    <div class="container">
       <br>
        <div class="row m-auto">
            <a href="${pageContext.request.contextPath}/connectionPorts?action=${HttpRequestList.ADD.toString()}" class="btn btn-success float-right">Add Port</a>
        </div>
        <br>
        <table class="table table-bordered table-striped table-hover table-light">
            <tr>
                <td>S.N</td>
                <td>Port Number</td>
                <td>Port Byte Limit</td>
                <td>Action</td>
            </tr>

                <tr>
                    <td>1</td>
                    <td>${connectionPort.portNumber}</td>
                    <td>${connectionPort.byteLimit}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/connectionPorts?action=${HttpRequestList.UPDATE.toString()}&id=${connectionPort.id}"
                           class="btn btn-success"
                        >
                            Edit
                        </a>


                    </td>
                </tr>
       </table>
    </div>
</div>