package io.rabobank.ret.plugin

import io.rabobank.ret.commands.PluginInitializeCommand
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import picocli.CommandLine

class {{cookiecutter.pluginClassName}}EntryCommandTest {

    private val commandLine = CommandLine({{cookiecutter.pluginClassName}}EntryCommand(), CustomInitializationFactory())

    @Test
    fun `should execute without error`() {
        commandLine.execute()
    }
}

class CustomInitializationFactory : CommandLine.IFactory {
    private val pluginInitializeCommand: PluginInitializeCommand = mock()
    override fun <K : Any?> create(cls: Class<K>?): K {
        return if (cls?.isInstance(pluginInitializeCommand) == true) {
            cls.cast(pluginInitializeCommand)
        } else {
            CommandLine.defaultFactory().create(cls)
        }
    }
}
