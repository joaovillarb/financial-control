package villar.financial.financialcontrol.dataprovider.database.gateway;

import villar.financial.financialcontrol.core.gateway.WalletGateway;
import villar.financial.financialcontrol.dataprovider.database.entity.Wallet;
import villar.financial.financialcontrol.dataprovider.database.gateway.abstracts.AbstractGatewayImpl;
import villar.financial.financialcontrol.dataprovider.database.repository.WalletRepository;

import java.util.UUID;

public class WalletGatewayImpl extends AbstractGatewayImpl<WalletRepository, Wallet, UUID> implements WalletGateway {

    public WalletGatewayImpl(WalletRepository repository) {
        super(repository);
    }


}
