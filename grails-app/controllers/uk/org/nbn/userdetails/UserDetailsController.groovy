package uk.org.nbn.userdetails

import au.org.ala.userdetails.User
import grails.converters.JSON

class UserDetailsController extends au.org.ala.userdetails.UserDetailsController{

    def findUser(Integer max) {
        if(params.q){
            def q = "%"+ params.q + "%"
            def userList = User.findAllByEmailLikeOrLastNameLikeOrFirstNameLike(q,q,q)
            def result = [results: userList, total: userList.size(), q:params.q]
            render result as JSON
        } else {
            params.max = Math.min(max ?: 20, 5000)
            def result =[results: User.list(params), total: User.count()]
            render result as JSON
        }
    }
}
