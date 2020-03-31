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

    def createModuleCommand = "ng g ng-alain:module ${modelName}"
    execute = createModuleCommand.execute(null, new File("../client"))
    execute.waitFor()


    createModuleCommand = "ng g ng-alain:curd curd -m ${modelName}"
    execute.waitFor()
    println createModuleCommand

    execute = createModuleCommand.execute(null, new File("../client"))

    def model = model('/Users/lyc/SourceCode/test/grails-alain-test/server/grails-app/domain/xyz/lyc/Address')
//    println model.asMap().toString()

    println ""
    println model.getPropertyName()

    println args.toString()
    println "liuyuchao"
}
else {
    error "No argument specified"
}
