includeTargets << new File("${angularScaffoldingPluginDir}/scripts/_NgGenerate.groovy")

target(default: 'Generates HTML Angular JS view templates for a specified domain class') {
	depends checkVersion, parseArguments, packageApp

	promptForName type: 'Domain Class'
	generateController = false
	generateForName = argsMap.params[0]

	generateForOne()
}
