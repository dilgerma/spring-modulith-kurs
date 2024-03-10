package de.nebulit.todo

import java.util.UUID

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules

class ModuleTest  {
    @Test
    fun verifyModules() {
        var modules = ApplicationModules.of(SpringApp::class.java)
        modules.verify()
    }
}
