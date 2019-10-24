<jsp:include page="headers/header.jsp"/>

<div class="row ml-2 mt-4">
    <div class="col-md-2">
        <div class="card">
            <h5 class="card-header font-weight-bold" style="background-color: black;color: white;text-align:center;">Grades</h5>
            <div class="card-body" style="text-align:center;">
                <h5 class="card-title font-weight-bold text-info" style="color: #cc3612 !important">${gradeCount}</h5>
            </div>
        </div>
    </div>
    <div class="col-md-2">
        <div class="card">
            <h5 class="card-header font-weight-bold" style="background-color: black;color: white;text-align:center;">Templates</h5>
            <div class="card-body" style="text-align:center;">
                <h5 class="card-title font-weight-bold text-info" style="color: #cc3612 !important">${messageTemplateCount}</h5>
            </div>
        </div>
    </div>

    <div class="col-md-2">
        <div class="card">
            <h5 class="card-header font-weight-bold" style="background-color: black;color: white;text-align:center;">Total Students</h5>
            <div class="card-body" style="text-align:center;">
                <h5 class="card-title font-weight-bold text-info" style="color: #cc3612 !important">${studentCount}</h5>
            </div>
        </div>
    </div>

    <div class="col-md-2">
        <div class="card">
            <h5 class="card-header font-weight-bold" style="background-color: black;color: white;text-align:center;">Messages Sent</h5>
            <div class="card-body" style="text-align:center;">
                <h5 class="card-title font-weight-bold text-info" style="color: #cc3612 !important">${messageSentStatusCount}</h5>
            </div>
        </div>
    </div>

</div>