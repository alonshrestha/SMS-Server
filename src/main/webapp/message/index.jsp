<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="np.com.alon.enumlist.HttpRequestList" %>

<jsp:include page="../headers/header.jsp"/>
<div class="main">
    <div class="container">
        <br>
        <div class="row m-auto">
            <a href="${pageContext.request.contextPath}/addMessage?action=${HttpRequestList.ADD.toString()}"
               class="btn btn-success float-right">Add Message</a>
        </div>
        <br>
        <table class="table table-bordered table-striped table-responsive table-light table-hover">
            <tr>
                <td>S.N</td>
                <td>Title</td>
                <td style="width: 60% !important;">Message</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${messageTemplateList}" varStatus="i" var="m">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${m.title}</td>
                    <td>${m.messageBody}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/updateMessage?action=${HttpRequestList.UPDATE.toString()}&id=${m.id}"
                           class="btn btn-success">
                            Edit
                        </a>
                        <a href="${pageContext.request.contextPath}/updateMessage?action=${HttpRequestList.DELETE.toString()}&id=${m.id}"
                           class="btn btn-danger">
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </body>
</div>