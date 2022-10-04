<!doctype html>
<html>
<head>
    <meta name="layout" content="${grailsApplication.config.skin.layout}"/>
    <meta name="section" content="home"/>
    <title>User Administration | ${grailsApplication.config.skin.orgNameLong}</title>
    <asset:stylesheet src="application.css" />
</head>
<body>
    <div class="row">
        <div class="col-md-12" id="page-body" role="main">
            <h1>User Administration</h1>
            <ul class="userdetails-menu">
                <li><g:link controller="user" action="list">Find a user</g:link></li>
                <li><g:link controller="admin" action="resetPasswordForUser">Reset user password</g:link></li>
                <li><g:link controller="role" action="list">Roles</g:link></li>
                <li><g:link controller="authorisedSystem" action="list">Authorised systems</g:link></li>
                <li><g:link controller="admin" action="bulkUploadUsers">Bulk create user accounts</g:link></li>
                <li><g:link controller="admin" action="exportUsers">Export users to CSV file</g:link></li>
                <g:if test="${grailsApplication.config.getProperty('attributes.affiliations.enabled', Boolean, false)}">
                    <li><g:link controller="admin" action="surveyResults">Get user survey results</g:link></li>
                </g:if>
                <li><g:link controller="alaAdmin" action="index">ALA admin page</g:link></li>
            </ul>

        </div>
    </div>
</body>
</html>
