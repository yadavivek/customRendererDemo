import grails.converters.JSON
import grails.rest.sample.Book
import grails.rest.sample.User

class BootStrap {

    def init = { servletContext ->

        new Book(name: "Grails").save()
        new Book(name: "Groovy").save()

        new User(username: "vivek", firstName: "Vivek", lastName: "Yadav", email: "vivek@mail.com").save(failOnError:true)
        new User(username: "puneet", firstName: "Puneet", lastName: "Behl", email: "puneet@mail.com").save(failOnError:true)

        JSON.createNamedConfig("details") {
            it.registerObjectMarshaller(User) { User user ->
                final String fullname = [user.firstName, user.lastName].join(' ')
                final userMap = [
                        id      : user.id,
                        username: user.username,
                        email   : user.email,
                ]
                if (fullname) {
                    userMap.fullname = fullname
                }
                userMap
            }
        }

        JSON.createNamedConfig('short') {
            it.registerObjectMarshaller(User) { User user ->
                final userMap = [
                        id      : user.id,
                        username: user.username
                ]
                userMap
            }
            // Add for other resources a marshaller within
            // named configuration.
        }


    }
    def destroy = {
    }
}
