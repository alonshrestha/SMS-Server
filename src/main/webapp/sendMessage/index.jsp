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
            <input type="hidden" name="action" value="${HttpRequestList.DIRECT_MESSAGE.toString()}"/>
            <div class="row form-row">
                <label>Message Title</label>
                <input type="text" name="phoneNumber" class="form-control"/>
            </div>

            <div class="row form-row">
                <label>Message Title</label>
                <textarea rows="5" cols="40" name="messageBody" class="form-control"></textarea>
            </div>
            <input type="submit" value="save" class="btn btn-primary"/>
        </form>
    </div>
</div>
