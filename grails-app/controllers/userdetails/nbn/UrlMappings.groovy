package userdetails.nbn

class UrlMappings {

    static mappings = {
        "/userDetails/findUser"(controller:'userDetails', action: 'findUser')
        "/admin/webservices"(controller:'admin', action: 'webservices')

    }
}
