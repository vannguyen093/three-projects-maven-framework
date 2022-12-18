package ultilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"file:environmentConfig/${env}.properties"})
public interface Environment extends Config {
    @Key("UserNopCommerce.Url")
    String userNopCommerceUrl();

    @Key("AdminNopCommerce.Url")
    String adminNopCommerceUrl();

    @Key("UserLiveGuru.Url")
    String userLiveGuruUrl();

    @Key("AdminLiveGuru.Url")
    String adminLiveGuruUrl();

    @Key("UserBankGuru.Url")
    String userBankGuruUrl();
}
