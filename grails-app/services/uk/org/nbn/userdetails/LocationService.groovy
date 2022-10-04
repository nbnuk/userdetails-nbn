package uk.org.nbn.userdetails


class LocationService extends au.org.ala.userdetails.LocationService{


    @Override
    Map<String,String> affiliationSurvey(Locale locale) {
        [
                'Academia and research': 'Academia and research',
                'Agriculture, forestry and fishing': 'Agriculture, forestry and fishing',
                'Artist, journalist, photographer':'Artist, journalist, photographer',
                'College and university student':'College and university student',
                'Construction, utilities and technology': 'Construction, utilities and technology',
                'Ecologist': 'Ecologist',
                'Environmental consultant': 'Environmental consultant',
                'LERC staff': 'LERC staff',
                'Local and national government': 'Local and national government',
                'Museums, botanical gardens and aquaria': 'Museums, botanical gardens and aquaria',
                'NGO staff': 'NGO staff',
                'Personal interest': 'Personal interest',
                'Recorder and recording scheme': 'Recorder and recording scheme',
                'Teaching and education': 'Teaching and education'
        ]
    }
}
