package villar.financial.financialcontrol.core.usecase.wallet.impl;

import villar.financial.financialcontrol.core.gateway.WalletGateway;
import villar.financial.financialcontrol.core.usecase.wallet.UseCaseWallet;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;
import villar.financial.financialcontrol.dataprovider.database.entity.Wallet;
import villar.financial.financialcontrol.entrypoint.dto.WalletDto;
import villar.financial.financialcontrol.infrastructure.utils.SecurityUtils;

public class UseCaseWalletImpl implements UseCaseWallet {

    private final WalletGateway walletGateway;

    public UseCaseWalletImpl(WalletGateway walletGateway) {
        this.walletGateway = walletGateway;
    }

    public WalletDto save(WalletDto dto) {
        final Account account = SecurityUtils.getLoggedInUser();
        Wallet wallet = new Wallet(dto, account);
        wallet = this.walletGateway.save(wallet);
        return new WalletDto(wallet);
    }
}
