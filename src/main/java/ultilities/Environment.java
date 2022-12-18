package ultilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"file:environmentConfig/${env}.properties"})
public interface Environment extends Config {
    @Key("User.Url")
    String userUrl();

    @Key("Admin.Url")
    String adminUrl();
}
