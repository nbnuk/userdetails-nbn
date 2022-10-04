package userdetails.nbn

class UrlMappings {

    static mappings = {
        "/userDetails/findUser"(controller:'userDetails', action: 'search')
        "/admin/webservices"(controller:'admin', action: 'webservices')

    }
}
