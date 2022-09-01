package properties;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:EnvConfig.properties")
public interface EnvConfig extends Config {

    @Key("BASE_URI")
    String baseUri();
}
