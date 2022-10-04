package uk.org.nbn.userdetails

import au.org.ala.auth.PreAuthorise
import com.opencsv.CSVWriterBuilder
import com.opencsv.RFC4180ParserBuilder

@PreAuthorise
class AdminController extends au.org.ala.userdetails.AdminController{

    def webservices() {}

    def surveyResults() {
        def results = userService.countByProfileAttribute('userType', null, request.locale)
        def csvWriter = new CSVWriterBuilder(response.writer)
                .withParser(new RFC4180ParserBuilder().build())
                .build()
        response.status = 200
        response.contentType = 'text/csv'
        response.setHeader('Content-Disposition', "attachment; filename=user-survey-${new Date()}.csv")
        csvWriter.writeAll(results)
        csvWriter.flush()
    }

}
