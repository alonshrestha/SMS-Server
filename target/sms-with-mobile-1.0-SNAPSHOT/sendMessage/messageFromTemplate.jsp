<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="np.com.alon.enumlist.HttpRequestList" %>


<jsp:include page="../headers/header.jsp"/>
<div class="main">
    <div class="container">
        <div class="row">
            <a href="${pageContext.request.contextPath}/directMessage" class="btn btn-success float-right">Direct Message</a>
        </div>

        <div class="row">
        </div>
        <form action="${pageContext.request.contextPath}/mmm" method="post">
            <input type="hidden" name="action" value="${HttpRequestList.MESSAGE_FROM_TEMPLATE.toString()}"/>
            <div class="row form-row">
                <label>Message Title</label>
                <select name="grade" class="form-control">
                    <c:forEach items="${grade}" var="g">
                        <option value="${g.id}">${g.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="row form-row">
                <label>Message Title</label>
                <select name="messageTemplate" class="form-control">
                    <c:forEach items="${messageTemplate}" var="m">
                        <option value="${m.id}">${m.title}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" value="save" class="btn btn-primary"/>
        </form>
    </div>
</div>
