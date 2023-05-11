package villar.financial.financialcontrol.infrastructure.utils;

public class StringUtil {

    private StringUtil() {
    }

    public static boolean hasValue(String valor) {
        if (valor == null) {
            return false;
        }

        String novoValor = valor.trim();
        return (!novoValor.isEmpty());
    }
}
