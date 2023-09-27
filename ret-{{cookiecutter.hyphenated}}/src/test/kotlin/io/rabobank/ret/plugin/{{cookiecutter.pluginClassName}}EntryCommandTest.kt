package io.rabobank.ret.plugin

import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import picocli.CommandLine
import picocli.CommandLine.Command

class {{cookiecutter.pluginClassName}}EntryCommandTest {

    private val commandLine = CommandLine({{cookiecutter.pluginClassName}}EntryCommand(), CustomInitializationFactory())

    @Test
    fun `should execute without error`() {
        commandLine.execute()
    }
}

class CustomInitializationFactory : CommandLine.IFactory {
    override fun <K : Any> create(cls: Class<K>): K =
        if (cls.isAnnotationPresent(Command::class.java)) {
            mock(cls)
        } else {
            CommandLine.defaultFactory().create(cls)
        }
}
