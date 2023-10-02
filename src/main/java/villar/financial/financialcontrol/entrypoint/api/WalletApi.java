package villar.financial.financialcontrol.entrypoint.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import villar.financial.financialcontrol.core.usecase.wallet.UseCaseWallet;
import villar.financial.financialcontrol.entrypoint.dto.WalletDto;

@RestController
@RequestMapping("/wallet")
class WalletApi {

    private final UseCaseWallet useCase;

    WalletApi(UseCaseWallet useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<WalletDto> save(@RequestBody WalletDto dto) {
        final var save = this.useCase.save(dto);

        final var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(save.id())
                .toUri();

        return ResponseEntity.created(uri).body(save);
    }
}
