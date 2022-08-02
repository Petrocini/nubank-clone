package br.com.lucaspetrocini.nubankclone.model;

public class AccountOption {

    private int optionIcon;
    private String title;

    public AccountOption(int optionIcon, String title) {
        this.optionIcon = optionIcon;
        this.title = title;
    }

    public int getOptionIcon() {
        return optionIcon;
    }

    public void setOptionIcon(int optionIcon) {
        this.optionIcon = optionIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
