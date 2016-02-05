package grails.rest.sample

import grails.rest.Resource
import groovy.transform.ToString

@Resource(uri = "/books")
@ToString
class Book {

    String name
    static constraints = {
    }
}
