import grails.util.*

description( "Creates a Helloworld" ) {
    usage "grails create-helloworld [NAME]"
    argument name:'Helloworld Name', description:"The name of the Helloworld to create", required:true
    flag name:'force', description:"Whether to overwrite existing files"
}

def model = model(args[0])
boolean overwrite = flag('force')

render template: template('test/Helloworld.groovy'),
       destination: file("grails-app/test/${model.packagePath}/${model.simpleName}.groovy"),
       model: model,
       overwrite: overwrite
