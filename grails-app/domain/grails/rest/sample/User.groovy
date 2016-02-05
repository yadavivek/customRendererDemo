package grails.rest.sample

import grails.rest.Resource

@Resource(uri = "/users", formats = ['json', 'short', 'details'])
class User {

    String username
    String lastName
    String firstName
    String email

    static constraints = {
        email email: true
        lastName nullable: true
        firstName nullable: true
    }
}