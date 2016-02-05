import grails.rest.render.json.JsonRenderer
import grails.rest.sample.User
import org.codehaus.groovy.grails.web.mime.MimeType

// Place your Spring DSL code here
beans = {

    // Register JSON renderer for User resource with detailed output.
    userDetailsRenderer(JsonRenderer, User) {
        // Grails will compare the name of the MimeType
        // to determine which renderer to use. So we
        // use our own custom name here.
        // The second argument, 'details', specifies the
        // supported extension. We can now use
        // the request parameter format=details to use
        // this renderer for the User resource.
        mimeTypes = [new MimeType('application/vnd.grails.rest.sample.details+json', 'details')]

        // Here we specify the named configuration
        // that must be used by an instance
        // of this renderer. See Bootstrap.groovy
        // for available registered named configuration.
        namedConfiguration = 'details'
    }

    // Register second JSON renderer for User resource with compact output.
    userShortRenderer(JsonRenderer, User) {
        mimeTypes = [new MimeType('application/vnd.grails.rest.sample.short+json', 'short')]

        // Named configuration is different for short
        // renderer compared to details renderer.
        namedConfiguration = 'short'
    }

    // Default JSON renderer as fallback.
    userRenderer(JsonRenderer, User) {
        mimeTypes = [new MimeType('application/json', 'json')]
    }
}
