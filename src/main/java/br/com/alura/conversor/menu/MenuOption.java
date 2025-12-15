package br.com.alura.conversor.menu;

public enum MenuOption {
    USD_BRL(1, "USD", "BRL", "USD -> BRL"),
    BRL_USD(2, "BRL", "USD", "BRL -> USD"),
    EUR_BRL(3, "EUR", "BRL", "EUR -> BRL"),
    BRL_EUR(4, "BRL", "EUR", "BRL -> EUR"),
    USD_EUR(5, "USD", "EUR", "USD -> EUR"),
    EUR_USD(6, "EUR", "USD", "EUR -> USD"),
    SAIR(0, "", "", "Sair");

    private final int code;
    private final String base;
    private final String target;
    private final String label;

    MenuOption(int code, String base, String target, String label) {
        this.code = code;
        this.base = base;
        this.target = target;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getBase() {
        return base;
    }

    public String getTarget() {
        return target;
    }

    public String getLabel() {
        return label;
    }

    public static MenuOption fromCode(int code) {
        for (MenuOption option : values()) {
            if (option.code == code) return option;
        }
        return null;
    }
}
