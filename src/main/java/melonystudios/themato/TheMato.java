package melonystudios.themato;

import melonystudios.themato.config.MTConfigs;
import melonystudios.themato.proxy.MTClientProxy;
import melonystudios.themato.proxy.MTCommonProxy;
import melonystudios.themato.proxy.MTServerProxy;
import melonystudios.themato.util.MTUtils;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TheMato.MOD_ID)
public class TheMato {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "themato";
    public final MTCommonProxy proxy;

    public TheMato() {
        MinecraftForge.EVENT_BUS.register(this);
        proxy = DistExecutor.safeRunForDist(() -> MTClientProxy::new, () -> MTServerProxy::new);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MTConfigs.COMMON_SPEC, "melonystudios/themato-common.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MTConfigs.CAVES_AND_CLIFFS_SPEC, "melonystudios/themato-cavesandcliffs.toml");
        ForgeMod.enableMilkFluid();
        MTConfigs.init();
        MTUtils.init();
    }
}