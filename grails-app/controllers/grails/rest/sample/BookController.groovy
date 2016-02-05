package grails.rest.sample

import grails.transaction.Transactional
import static org.springframework.http.HttpStatus.*
import static org.springframework.http.HttpMethod.*

@Transactional(readOnly = true)
class BookController {

    /*def index(Integer max) {

        println "Hello In Book controller"
        params.max = Math.min(max ?: 10, 100)
        respond Book.list(params), model:[bookCount: Book.count()]
    }*/

    def index(){}
}
