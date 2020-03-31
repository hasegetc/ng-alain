description( "TODO: command description" ) {
  usage "grails ng-alain-edit"

  // TODO: populate arguments
  argument name:'arg1', description:"arg1 description", required:true

  // TODO: populate flags
  flag name:'flag1', description:"flag1 description"
}

if(args) {
    def modelName = args[0]

    def createModuleCommand = "ng g ng-alain:module ${modelName}"
    def execute = createModuleCommand.execute(null, new File("../client"))
    execute.waitFor()

    createModuleCommand = "ng g ng-alain:edit edit -m ${modelName} -t=curd"
    execute = createModuleCommand.execute(null, new File("../client"))
    execute.waitFor()
}
else {
    error "No argument specified"
}
