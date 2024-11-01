package foundation.esoteric.minecraft.plugins.library.pack.resource

import be.seeseemelk.mockbukkit.MockBukkit
import foundation.esoteric.minecraft.plugins.library.TestPlugin
import foundation.esoteric.utility.file.FileUtility
import java.io.File
import kotlin.test.*

class ResourcePackTest {

    private var plugin: TestPlugin? = null
    private var resourcePackFolder: File? = null

    @BeforeTest fun mockResourcePackPlugin() {
        MockBukkit.mock()
        plugin = MockBukkit.load(TestPlugin::class.java)
        resourcePackFolder = File(plugin!!.dataFolder, "TestPluginResourcePack.zip")
    }

    @Test fun resourcePackSavingWorks() {
        assertTrue(resourcePackFolder!!.exists())
    }

    @Test fun resourcePackHashIsCorrect() {
        assertEquals(FileUtility.getSha1Hash(resourcePackFolder!!), "7c5c17ed5fe4a586336ec2e345eeb234b9c7948c")
    }

    @AfterTest fun unmockResourcePackPlugin() {
        MockBukkit.unmock()
    }
}
