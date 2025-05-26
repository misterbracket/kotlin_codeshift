#!/usr/bin/env kotlin

@file:Repository("https://jitpack.io")
@file:DependsOn("com.github.orangain.ktast:ast:0.10.0")
@file:DependsOn("com.github.orangain.ktast:ast-psi:0.10.0")
@file:DependsOn(
    "com.github.orangain:ktcodeshift:0.4.0",
)
@file:Suppress("ktlint:standard:no-wildcard-imports")

import ktast.ast.*
import ktast.builder.*
import ktcodeshift.*


println("******* PROGRAM START ***************** ")

transform { fileInfo ->
    val tree = Ktcodeshift.parse(fileInfo.source)

    // Create the new import
    val newImport =
        Node.ImportDirective(
            names = listOf(Node.Expression.NameExpression("io.pleo.commsgateway.requestmodels.requests.NotificationRequest")),
            aliasName = null,
        )

    // Ensure all imports are on separate lines by putting them in separate entries
    val modifiedTree =
        tree.copy(
            importDirectives = tree.importDirectives + listOf(newImport),
        )

    println(Dumper.dump(modifiedTree)) // Dumps the modified AST

    modifiedTree.toSource()
}

println("******* PROGRAM END ***************** ")
