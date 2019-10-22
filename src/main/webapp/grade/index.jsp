<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="np.com.alon.enumlist.HttpRequestList" %>

<jsp:include page="../headers/header.jsp"/>
<div class="main">
    <div class="container">
        <br>
        <div class="row m-auto">
            <a href="${pageContext.request.contextPath}/grades?action=${HttpRequestList.ADD.toString()}" class="btn btn-success float-right">Add Grade</a>
        </div>
        <br>
        <table class="table table-bordered table-striped table-hover table-light">
            <tr>
                <td>S.N</td>
                <td>Grade</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${gradeList}" varStatus="i"  var="g">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${g.name}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/grades?action=${HttpRequestList.UPDATE.toString()}&id=${g.id}"
                           class="btn btn-success"
                        >
                            Edit
                        </a>

                        <a href="${pageContext.request.contextPath}/grades?action=${HttpRequestList.DELETE.toString()}&id=${g.id}"
                           class="btn btn-danger"
                        >
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>


        </table>
    </div>
</div>