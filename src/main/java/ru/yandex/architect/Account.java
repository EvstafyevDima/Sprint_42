package ru.yandex.architect;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        int count = name.length(); // Подсчет количество знаков
        Boolean isNoSpaceAtTheBeginning = !name.startsWith(" ");// нет пробела в начале
        Boolean isNoSpaceAtTheEnd = !name.endsWith(" "); // нет пробела в конце

        if(count >= 3 && count <= 19 && isNoSpaceAtTheBeginning  && isNoSpaceAtTheEnd){

            int counter = 0;
            char[] chArray = name.toCharArray();
            for(int i = 0; i < chArray.length; i++){
                if(chArray[i] == ' '){
                    counter++;
                }
            }

            if (counter == 1) {
                System.out.println("true");
                return true;
            }

            else {
                System.out.println("false!");
                return false;
            }
        }

        return false;
    }
}
