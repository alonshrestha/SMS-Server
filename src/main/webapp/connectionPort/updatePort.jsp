<%@ page import="np.com.alon.enumlist.HttpRequestList" %>


<jsp:include page="../headers/header.jsp"/>
<div class="main">
    <div class="container">
        <div class="row">
            <a href="${pageContext.request.contextPath}/connectionPorts?action=${HttpRequestList.ALL.toString()}" class="btn btn-success float-right">Port List</a>
        </div>

        <form action="${pageContext.request.contextPath}/connectionPorts" method="post">
            <input type="hidden" name="action" value="${HttpRequestList.UPDATE.toString()}"/>
            <input type="hidden" name="id" value="${connectionPort.id}"/>
            <div class="row form-row">
                <label>Port Number</label>
                <input type="text" name="portNumber" class="form-control" value="${connectionPort.portNumber}"/>
            </div>


            <div class="row form-row">
                <label>Port Bytes</label>
                <input type="text" name="byteLimit" class="form-control" value="${connectionPort.byteLimit}"/>
            </div>



            <input type="submit" value="Update" class="btn btn-primary"/>
        </form>
    </div>
</div>
