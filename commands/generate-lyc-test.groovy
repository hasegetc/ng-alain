import org.grails.cli.interactive.completers.DomainClassCompleter

description( "Generates a LycTest" ) {
  usage "grails generate-lyc-test [DOMAIN CLASS]"
  argument name:'Domain Class', description:"The name of the domain class", required:true
  completer DomainClassCompleter
  flag name:'force', description:"Whether to overwrite existing files"
}

if(args) {
  def classNames = args
  if(args[0] == '*') {
    classNames = resources("file:grails-app/domain/**/*.groovy").collect { className(it) }
  }
  for(arg in classNames) {
    def sourceClass = source(arg)
    boolean overwrite = flag('force')
    if(sourceClass) {
      def model = model(sourceClass)
      render template: template('lyctest/LycTest.groovy'),
             destination: file("grails-app/lyctest/${model.packagePath}/${model.convention('LycTest')}.groovy"),
             model: model,
             overwrite: overwrite

      addStatus "Generation completed for ${projectPath(sourceClass)}"
    }
    else {
      error "Domain class not found for name $arg"
    }
  }
}
else {
    error "No domain class specified"
}
