description( "TODO: command description" ) {
  usage "grails lyc-command"

  // TODO: populate arguments
  argument name:'arg1', description:"arg1 description", required:true

  // TODO: populate flags
  flag name:'flag1', description:"flag1 description"
}

if(args) {
    def modelName = args[0]

    def command = "pwd"
    def execute = command.execute()
    println execute.getText()

    def sourceClass = source(modelName)

    def file = new File(sourceClass.toString())
    Class parseClass = new GroovyClassLoader().parseClass(file);
    GroovyObject newInstance = (GroovyObject) parseClass.newInstance();

    def properties = newInstance.properties

    properties.each {
        println it.toString()
    }

    def values = newInstance.metaPropertyValues
    values.each {
        println it.name
        println it.type
    }

}
else {
    error "No argument specified"
}
