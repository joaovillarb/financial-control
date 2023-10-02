package villar.financial.financialcontrol.core.gateway;

import villar.financial.financialcontrol.dataprovider.database.entity.Wallet;

public interface WalletGateway {

    Wallet save(Wallet wallet);

}
