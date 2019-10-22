<%@ page import="np.com.alon.enumlist.HttpRequestList" %>


<jsp:include page="../headers/header.jsp"/>
<div class="main">
    <div class="container">
<%--        <div class="row">--%>
<%--            <a href="${pageContext.request.contextPath}/connectionPorts?action=${HttpRequestList.ALL.toString()}" class="btn btn-success float-right">Port List</a>--%>
<%--        </div>--%>

        <form action="${pageContext.request.contextPath}/connectionPorts" method="post">
            <input type="hidden" name="action" value="${HttpRequestList.ADD.toString()}"/>
            <div class="row form-row" style="margin-top: 30px;">
                <label>Port Number</label>
                <input type="text" name="portNumber" class="form-control"/>
            </div>


            <div class="row form-row" style="margin-top: 10px;">
                <label>Port Bytes</label>
                <input type="text" name="byteLimit" class="form-control"/>
            </div>



            <input style="margin-top: 10px;" type="submit" value="save" class="btn btn-primary"/>
        </form>
    </div>
</div>
